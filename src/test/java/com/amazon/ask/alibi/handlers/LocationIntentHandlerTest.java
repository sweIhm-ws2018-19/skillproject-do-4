package com.amazon.ask.alibi.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationIntentHandlerTest {
    private HandlerInput getMockHandlerInput(String location) {
        HandlerInput mockHandlerInput =
                mock(HandlerInput.class);
        RequestEnvelope envelope = mock(RequestEnvelope.class);
        when(mockHandlerInput.getRequestEnvelope()).thenReturn(envelope);
        IntentRequest request = mock(IntentRequest.class);
        when(envelope.getRequest()).thenReturn(request);
        Intent mockIntent = mock(Intent.class);
        when(request.getIntent()).thenReturn(mockIntent);
        Slot mockLocationSlot = mock(Slot.class);
        if (location != null) {
            when(mockLocationSlot.getValue()).thenReturn(location);
            Map<String, Slot> dummyMap = new HashMap<>();
            dummyMap.put(LocationIntentHandler.LOC_SLOT, mockLocationSlot);
            when(mockIntent.getSlots()).thenReturn(dummyMap);
        }
        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());

        AttributesManager mockAttributesManager = mock(AttributesManager.class);
        when(mockHandlerInput.getAttributesManager()).thenReturn(mockAttributesManager);

        return mockHandlerInput;
    }

    @Test
    public void testHandleNull() {
        HandlerInput mockInput = getMockHandlerInput(null);
        LocationIntentHandler mockHandler = new LocationIntentHandler();
        Optional<Response> response = mockHandler.handle(mockInput);
        assertTrue(response.isPresent());
        String responseString = response.get().toString();
        assertTrue(responseString.contains("Ich kenne deinen Ort nicht. Bitte versuche es noch einmal."));
    }
    
    @Test
    public void testHandleNotNull() {
        HandlerInput mockInput = getMockHandlerInput("Malmo");
        String date = "12.11.2018";
        Slot mockDateSlot = mock(Slot.class);
        DateIntentHandler.dateSlot = mockDateSlot;
        when(mockDateSlot.getValue()).thenReturn(date);
        LocationIntentHandler mockHandler = new LocationIntentHandler();
        Optional<Response> response = mockHandler.handle(mockInput);
        System.out.println(response);
        assertTrue(response.isPresent());
        assertFalse(response.get().toString().isEmpty());
        DateIntentHandler.dateSlot = null;
    }
}
