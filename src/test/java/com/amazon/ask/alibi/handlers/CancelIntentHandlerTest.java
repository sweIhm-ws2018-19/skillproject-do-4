package com.amazon.ask.alibi.handlers;

import org.junit.jupiter.api.Test;

public class CancelIntentHandlerTest {
    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new CancelIntentHandler()).run();
    }

    @Test
    public void testHandle() {
        MockHandlerInputFactory.createHandleTest(new CancelIntentHandler(), "Alibi Erstellung abgebrochen. Auf Wiedersehen!").run();
    }
}
