package com.amazon.ask.alibi.handlers;

import java.util.Optional;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import static com.amazon.ask.request.Predicates.intentName;

public class FallbackIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.FallbackIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "Tut mir leid, das weiß ich nicht. Versuche es mit Hilfe!";
		return input.getResponseBuilder()
				.withSpeech(speechText)
				.withSimpleCard("Alibi", speechText)
				.withReprompt(speechText)
				.build();
	}

}
