package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class LocationIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return false;
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return Optional.empty();
    }
}
