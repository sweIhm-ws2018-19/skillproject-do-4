package com.amazon.ask.alibi.handlers;




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

		// Get the color slot from the list of slots.
		Slot dateSlot = slots.get(DATE_SLOT);

		String speechText, repromptText;
		boolean isAskResponse = false;

		// Check for favorite color and create output to user.
		if (dateSlot != null) {
			// Store the user's favorite color in the Session and create response.
			String date = dateSlot.getValue();
			input.getAttributesManager().setSessionAttributes(Collections.singletonMap(DATE_KEY, date));

			speechText =
					String.format("Dein Datum ist %s. Du kannst mich jetzt nach deinem Datum fragen.", date);
			repromptText =
					"Frage nach deinem Datum";

		} else {
			// Render an error since we don't know what the users favorite color is.
			speechText = "Ich kenne Deine Lieblingsfarbe nicht. Bitte versuche es noch einmal.";
			repromptText =
					"Ich weiss nicht welches Deine Lieblingsfarbe ist. Sag mir Deine Lieblingsfarbe. Sage zum Beispiel: ich mag blau.";
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
	
	


