package com.amazon.ask.alibi.handlers;




import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;

import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;


public class AlibiIntentHandler implements RequestHandler {


	@Override
	public boolean canHandle(HandlerInput input) {

		return input.matches(Predicates.intentName("erstelleAlibi"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		String speechText = "alibi erstellung gestartet...";
		return input.getResponseBuilder()
				.withSpeech(speechText)
				.withSimpleCard("Alibi", speechText)
				.withReprompt(speechText)
				.build();
	}


}
	
	


