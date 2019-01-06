package com.amazon.ask.alibi.handlers;

import alibi.model.AlibiGenerator;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.response.ResponseBuilder;

import java.text.Normalizer;
import java.util.*;

//import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.LOC_KEY;
//import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.LOC_SLOT;




public class LocationIntentHandler implements RequestHandler {

    public static final String LOC_KEY = "LOCATION";
    public static final String LOC_SLOT = "Ort";


    /**
     * Since we don't want to have Diacritics in our Code we need to remove those from
     * the Input given from the User.
     *
     * @param s String with Diacritics
     * @return The Location without any Diacritics.
     */
    public static String RemoveDiacritics(String s) {

        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "e");
        return s;

    }

    @Override
    public boolean canHandle(HandlerInput input) { return input.matches(Predicates.intentName("LocationIntent")); }

    /**
     * The Method takes the Location Input from the User and saves it to a Map.
     * This Value will now transformed to a Slot.
     * Since the Slot is empty Alexa creates a response.
     * Otherwise it returns an Alibi in relation to the Location.
     * @param input Location
     * @return response Build
     */
    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();


        // Get the date slot from the list of slots.
        Slot locSlot = slots.get(LOC_SLOT);


        String speechText, repromptText;
        boolean isAskResponse = false;

        // Check for location and create output to user.
        if (locSlot != null) {
            // Store the user's location in the Session and create response.
            String location = locSlot.getValue();

            // change ü to ue
            location = RemoveDiacritics(location);

            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(LOC_KEY, location));

            // get the date from the DateIntentHandler
            String date = DateIntentHandler.dateSlot.getValue();

            // generate an alibi out of date and location
            String output = new AlibiGenerator(date,date).generateAlibi("Location: "+location);
            // Integrate here Location Provider
            //

            // Alexa output
            speechText = "Verstanden. " + "Dein Alibi lautet: "+output;
            repromptText = "Verstanden. " + "Dein Alibi lautet: "+output;

        } else {
            // Render an error since we don't know what the specific date is.
            speechText = "Ich kenne deinen Ort nicht. Bitte versuche es noch einmal.";
            repromptText =
                    "Ich weiss wirklich nicht was dein Ort sein soll ist.";
            isAskResponse = true;
        }

        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSimpleCard("Alibi", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(false);

        if (isAskResponse) {
            responseBuilder.withShouldEndSession(false)
                    .withReprompt(repromptText);
        }

        return responseBuilder.build();

    }
}
