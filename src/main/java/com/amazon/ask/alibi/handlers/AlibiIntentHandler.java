package com.amazon.ask.alibi.handlers;

import alibi.model.*;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.model.Request;
import com.amazon.ask.response.ResponseBuilder;


import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;


public class AlibiIntentHandler implements RequestHandler {


	public static final String DATUM_SLOT = "Datum";

	@Override
	public boolean canHandle(HandlerInput input) {
		
		return input.matches(Predicates.intentName("erstelleAlibi"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		String alibiDate = (String) input.getAttributesManager().getSessionAttributes().get(DATUM_SLOT);

		String speechText;

		if(alibiDate != null && !alibiDate.isEmpty()) {
			speechText = String.format("Dein Datum war %s",alibiDate);
			Alibi alibi = new Alibi(alibiDate);
		}else{
			speechText = "Error";
		}




		ResponseBuilder responseBuilder = input.getResponseBuilder();






		return input.getResponseBuilder()
				.withSpeech(speechText)
				.withSimpleCard("Alibi",speechText)
				.build();


	}
	
	

}
