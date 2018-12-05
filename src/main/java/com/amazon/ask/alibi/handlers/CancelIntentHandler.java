package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.CancelIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Alibi Erstellung abgebrochen. Auf Wiedersehen!";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Alibi", speechText)
                .build();
    }


}
