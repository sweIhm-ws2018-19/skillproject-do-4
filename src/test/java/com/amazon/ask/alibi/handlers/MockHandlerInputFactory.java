package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.mockito.ArgumentMatchers;

import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockHandlerInputFactory {
    private MockHandlerInputFactory() {};
    public static HandlerInput createCanHandleInputHandler(boolean canHandle) {
        HandlerInput input = mock(HandlerInput.class);
        when(input.matches(ArgumentMatchers.<Predicate<HandlerInput>>any())).thenReturn(canHandle);
        return input;
    }

    public static HandlerInput createMockInputHandler() {
        HandlerInput mockHandlerInput =
                mock(HandlerInput.class);
        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        return mockHandlerInput;
    }

    public static Runnable  createCanHandleTest(RequestHandler handler) {
        return () -> {
            assertTrue(handler.canHandle(createCanHandleInputHandler(true)));
            assertFalse(handler.canHandle(createCanHandleInputHandler(false)));
        };
    }

    public static Runnable createHandleTest(RequestHandler handler, String answerString) {
        return () -> {
            Optional<Response> response = handler.handle(createMockInputHandler());
            assertTrue(response.isPresent());
            assertTrue(response.get().toString().contains(answerString));
        };
    }
}
