package com.amazon.ask.alibi.handlers;

import org.junit.jupiter.api.Test;

public class HelpIntentHandlerTest {
    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new HelpIntentHandler()).run();
    }

    @Test
    public void testHandle() {
        MockHandlerInputFactory.createHandleTest(new HelpIntentHandler(), "Ich erstelle dir ein Alibi. Gib Datum und Zeitpunkt an.").run();
    }
}
