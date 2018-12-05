package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.function.Predicate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HandlerInputFactory {
    private HandlerInputFactory() {};
    public static HandlerInput createCanHandleInputHandler(boolean canHandle) {
        HandlerInput input = mock(HandlerInput.class);
        when(input.matches(ArgumentMatchers.<Predicate<HandlerInput>>any())).thenReturn(canHandle);
        return input;
    }
}
