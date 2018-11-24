package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;


public class AlibiIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		
		return input.matches(Predicates.intentName("AlibiIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "Sag mir das Datum deiner Erinnerung";
		return input.getResponseBuilder()
				.withSpeech(speechText)
				.withSimpleCard("GetAlibi", speechText)
				.build();
	}
	
	

}
