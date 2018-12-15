package com.amazon.ask.alibi.handlers;

import alibi.model.AlibiGenerator;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.response.ResponseBuilder;

import java.util.*;

import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.LOC_KEY;
import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.LOC_SLOT;




public class LocationIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) { return input.matches(Predicates.intentName("LocationIntent")); }

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
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(LOC_KEY, location));


            // Alibi Generator works like this:
            // String output = new AlibiGenerator(startTimeAsString, endTimeAsString).generateAlibi(otherCriteriaAsString);

            String date = DateIntentHandler.dateSlot.getValue();

            String output = new AlibiGenerator(date,date).generateAlibi(location);

            speechText = "Verstanden dein eingegebener Ort ist "+location+". Das generierte Alibi lautet: "+output;



            repromptText = "Verstanden dein eingegebener Ort ist "+location+". Das generierte Alibi lautet: "+output;

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
