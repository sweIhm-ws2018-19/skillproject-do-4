package com.amazon.ask.alibi.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.alibi.handlers.WhatsMyAlibiIntentHandler.DATE_SLOT;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlibiIntentHandlerTest {
    private HandlerInput createHandlerInput(Map<String, Slot> intents) {
        HandlerInput handlerInput = mock(HandlerInput.class);
        RequestEnvelope envelope = mock(RequestEnvelope.class);
        IntentRequest intentRequest = mock(IntentRequest.class);
        Intent intent = mock(Intent.class);
        when(handlerInput.getRequestEnvelope()).thenReturn(envelope);
        when(envelope.getRequest()).thenReturn(intentRequest);
        when(intentRequest.getIntent()).thenReturn(intent);
        when(intent.getSlots()).thenReturn(intents);
        when(handlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        AttributesManager attributesManager = mock(AttributesManager.class);
        when(handlerInput.getAttributesManager()).thenReturn(attributesManager);
        return handlerInput;
    }

    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new AlibiIntentHandler()).run();
    }

    public void testHandleNull() {
        Map<String, Slot> map = new HashMap<>();
        map.put(WhatsMyAlibiIntentHandler.DATE_KEY, null);
        HandlerInput input = createHandlerInput(map);

        AlibiIntentHandler handler = new AlibiIntentHandler();
        Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
        assertTrue(response.get().toString().contains("Ich kenne dein Datum nicht"));
    }

    public void testHandleNonNullDate() {
        String date = "14.23.1938";
        Map<String, Slot> map = new HashMap<>();
        Slot mockSlot = mock(Slot.class);
        when(mockSlot.getValue()).thenReturn(date);
        map.put(DATE_SLOT, mockSlot);
        HandlerInput input = createHandlerInput(map);

        AlibiIntentHandler handler = new AlibiIntentHandler();
        Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
    }
}
