package com.amazon.ask.alibi.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhatsMyAlibiIntentHandlerTest {

    private HandlerInput getMockHandlerInput(String date) {
        HandlerInput mockHandlerInput =
                mock(HandlerInput.class);
        Map<String, Object> maps = new HashMap<>();
        maps.put(WhatsMyAlibiIntentHandler.DATE_KEY, date);
        AttributesManager mockAttributeManager = mock(AttributesManager.class);
        when(mockHandlerInput.getAttributesManager()).thenReturn(mockAttributeManager);
        when(mockAttributeManager.getSessionAttributes()).thenReturn(maps);
        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        return mockHandlerInput;
    }

    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new WhatsMyAlibiIntentHandler()).run();
    }

    @Test
    public void testHandleSucces() {
        String date = "19.8.1998";
        Optional<Response> output = new WhatsMyAlibiIntentHandler().handle(getMockHandlerInput(date));
        assertTrue(output.isPresent());
        String response = output.toString();
        assertTrue(response.contains(date));
    }

    @Test
    public void testHandleNull() {
        Optional<Response> output = new WhatsMyAlibiIntentHandler().handle(getMockHandlerInput(null));
        assertTrue(output.isPresent());
        String response = output.get().toString();
        assertTrue(response.contains("Ich weiss nicht was dein Datum sein soll"));
    }
}
