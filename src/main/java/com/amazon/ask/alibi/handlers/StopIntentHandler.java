/**
 * 
 */
package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

public class StopIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.StopIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder()
				.withSpeech("Auf Wiedersehen!"+ " Ich hoffe ich konnte dir helfen!")
				.withSimpleCard("Alibi", "Auf Wiedersehen!")
				.build();
	}
	
	

}
