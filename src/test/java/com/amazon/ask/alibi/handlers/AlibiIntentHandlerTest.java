package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.RequestEnvelope;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlibiIntentHandlerTest {
//    private HandlerInput createHandlerInput(Map<String, Slot> intents) {
//        HandlerInput handlerInput = mock(HandlerInput.class);
//        RequestEnvelope envelope = mock(RequestEnvelope.class);
//        IntentRequest intentRequest = mock(IntentRequest.class);
//        Intent intent = mock(Intent.class);
//        when(handlerInput.getRequestEnvelope()).thenReturn(envelope);
//        when(envelope.getRequest()).thenReturn(intentRequest);
//        when(intentRequest.getIntent()).thenReturn(intent);
//        when(intent.getSlots()).thenReturn(intents);
//        when(handlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
//        return handlerInput;
//    }

    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new AlibiIntentHandler()).run();
    }

//    @Test
//    public void testHandleNull() {
//        Map<String, Slot> map = new HashMap<>();
//        map.put(WhatsMyAlibiIntentHandler.DATE_KEY, null);
//        HandlerInput input = createHandlerInput(map);
//
//        AlibiIntentHandler handler = new AlibiIntentHandler();
//        handler.handle(input);
//    }
}
