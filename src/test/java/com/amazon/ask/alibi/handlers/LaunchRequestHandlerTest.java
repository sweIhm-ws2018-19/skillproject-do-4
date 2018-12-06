package com.amazon.ask.alibi.handlers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaunchRequestHandlerTest {
    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new LaunchRequestHandler()).run();
    }

    @Test
    public void testHandle() {
        MockHandlerInputFactory.createHandleTest(new LaunchRequestHandler(),
                "Willkommen bei deiner Pers")
                .run();
    }
}
