package com.amazon.ask.alibi.handlers;




import alibi.model.AlibiGenerator;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;

import com.amazon.ask.model.*;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.response.ResponseBuilder;


import java.util.*;

import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.DATE_KEY;
import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.DATE_SLOT;

import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.LOC_KEY;
import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.LOC_SLOT;


public class AlibiIntentHandler implements RequestHandler {

	private static Random random = new Random();

	/*
	returns a random location
	 */
	private static String getRandomLocation(List<String> locList){

		int index = random.nextInt(locList.size());
		return locList.get(index);
	}


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
		//Map<String ,Slot> slots2 = intent.getSlots();

		//List of Locations
		List<String> locList = new ArrayList<>();
		locList.add("Muenchen");
		locList.add("London");
		locList.add("Malmo");
		locList.add("Bruessel");


		// Get the date slot from the list of slots.
		Slot dateSlot = slots.get(DATE_SLOT);

		// Get the loc slot from the list of slots.
		//Slot locSlot = slots2.get(LOC_SLOT);

		String speechText, repromptText;
		boolean isAskResponse = false;

		// Check for date and create output to user.
		if (dateSlot != null) {
			// Store the user's date in the Session and create response.
			String date = dateSlot.getValue();
			input.getAttributesManager().setSessionAttributes(Collections.singletonMap(DATE_KEY, date));

			//String location = locSlot.getValue();
			String location = getRandomLocation(locList);
			//input.getAttributesManager().setSessionAttributes(Collections.singletonMap(LOC_KEY, location));

			// Alibi Generator works like this:
			// String output = new AlibiGenerator(startTimeAsString, endTimeAsString).generateAlibi(otherCriteriaAsString);

			AlibiGenerator generator = new AlibiGenerator(date,date);

			speechText = generator.generateAlibi("Location: " + location);

			repromptText = generator.generateAlibi(location);

		} else {
			// Render an error since we don't know what the specific date is.
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
	
	


