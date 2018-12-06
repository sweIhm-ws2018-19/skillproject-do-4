package com.amazon.ask.alibi.handlers;




import alibi.model.AlibiGenerator;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;

import com.amazon.ask.model.*;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.response.ResponseBuilder;


import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.DATE_KEY;
import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.DATE_SLOT;


public class AlibiIntentHandler implements RequestHandler {


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

		// Get the date slot from the list of slots.
		Slot dateSlot = slots.get(DATE_SLOT);

		String speechText, repromptText;
		boolean isAskResponse = false;

		// Check for date and create output to user.
		if (dateSlot != null) {
			// Store the user's date in the Session and create response.
			String date = dateSlot.getValue();
			input.getAttributesManager().setSessionAttributes(Collections.singletonMap(DATE_KEY, date));

			AlibiGenerator generator = new AlibiGenerator(date,date);

			speechText = generator.generateAlibi("Moos");

			repromptText = generator.generateAlibi("Moos");

		} else {
			// Render an error since we don't know what the users favorite color is.
			speechText = "Ich kenne dein Datum nicht. Bitte versuche es noch einmal.";
			repromptText =
					"Ich weiss wirklich nicht was dein Datum ist.";
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
	
	


