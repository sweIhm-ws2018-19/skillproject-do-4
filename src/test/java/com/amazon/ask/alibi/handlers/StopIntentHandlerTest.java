package com.amazon.ask.alibi.handlers;

import com.amazon.ask.model.Response;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StopIntentHandlerTest {
    @Test
    public void testCanHandle() {
        MockHandlerInputFactory.createCanHandleTest(new StopIntentHandler()).run();
    }

    @Test
    public void testHandle() {
        MockHandlerInputFactory.createHandleTest(new StopIntentHandler(), "Auf Wiedersehen!").run();
    }
}
