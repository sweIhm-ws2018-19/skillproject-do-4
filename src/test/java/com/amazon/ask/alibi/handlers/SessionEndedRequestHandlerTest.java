package com.amazon.ask.alibi.handlers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SessionEndedRequestHandlerTest {
    @Test
    public void testHandle() {
        SessionEndedRequestHandler testHandler = new SessionEndedRequestHandler();
        assertDoesNotThrow(() -> testHandler.handle(MockHandlerInputFactory.createMockInputHandler()));
    }
}
