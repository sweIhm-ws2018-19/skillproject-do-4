package com.amazon.ask.alibi.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DateIntentHandlerTest {
    private HandlerInput getMockHandlerInput(String date) {
        HandlerInput mockHandlerInput =
                mock(HandlerInput.class);
        RequestEnvelope envelope = mock(RequestEnvelope.class);
        when(mockHandlerInput.getRequestEnvelope()).thenReturn(envelope);
        IntentRequest request = mock(IntentRequest.class);
        when(envelope.getRequest()).thenReturn(request);
        Intent mockIntent = mock(Intent.class);
        when(request.getIntent()).thenReturn(mockIntent);
        Slot mockDateSlot = mock(Slot.class);
        if (date != null) {
            when(mockDateSlot.getValue()).thenReturn(date);
            Map<String, Slot> dummyMap = new HashMap<>();
            dummyMap.put(DateIntentHandler.DATE_SLOT, mockDateSlot);
            when(mockIntent.getSlots()).thenReturn(dummyMap);
        }
        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());

        AttributesManager mockAttributesManager = mock(AttributesManager.class);
        when(mockHandlerInput.getAttributesManager()).thenReturn(mockAttributesManager);

        return mockHandlerInput;
    }

    @Test
    public void testHandleNull() {
        HandlerInput mockHandlerInput = getMockHandlerInput(null);
        Optional<Response> response = new DateIntentHandler().handle(mockHandlerInput);
        assertTrue(response.isPresent());
        assertTrue(response.get().toString().contains("Ich weiss wirklich nicht was dein Datum ist."));
    }

    @Test
    public void testHandleDate() {
        String date = "12-Sep-2018";
        HandlerInput mockHandlerInput = getMockHandlerInput(date);
        Optional<Response> response = new DateIntentHandler().handle(mockHandlerInput);
        assertTrue(response.isPresent());
        String responseString = response.get().toString();
        assertTrue(responseString.contains(date));
        assertTrue(responseString.contains("Danke. Dein eingegebenes Datum ist"));
    }
}
