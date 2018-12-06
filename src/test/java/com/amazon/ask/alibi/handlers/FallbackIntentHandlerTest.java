package com.amazon.ask.alibi.handlers;

import org.junit.jupiter.api.Test;

public class FallbackIntentHandlerTest {
    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new FallbackIntentHandler()).run();
    }

    @Test
    public void testHandle() {
        MockHandlerInputFactory.createHandleTest(new FallbackIntentHandler(), "Tut mir leid, das wei").run();
    }
}
