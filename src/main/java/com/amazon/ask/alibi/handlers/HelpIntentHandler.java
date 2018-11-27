package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import static com.amazon.ask.request.Predicates.intentName;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class HelpIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.HelpIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "Ich erstelle dir ein Alibi. Gib Datum und Zeitpunkt an.";
		return input.getResponseBuilder()
				.withSpeech(speechText)
				.withSimpleCard("Alibi", speechText)
				.withReprompt(speechText)
				.build();
		
	}

}
