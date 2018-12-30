package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;


public class WhatsMyAlibiIntentHandler implements RequestHandler {
    public static final String DATE_KEY = "DATE";
    public static final String DATE_SLOT = "Datum";

    public static final String LOC_KEY = "LOCATION";
    public static final String LOC_SLOT = "Ort";


    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("WhatsMyAlibiIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText;
        String date = (String) input.getAttributesManager().getSessionAttributes().get(DATE_KEY);

        if (date != null && !date.isEmpty()) {
            speechText = String.format("Das gegebene Datum ist %s. Bis Bald.", date);
        } else {
            speechText = "Ich weiss nicht was dein Datum sein soll. Sag mir zuerst dein Datum.";

        }

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Alibi",speechText)
                .build();
    }
}
