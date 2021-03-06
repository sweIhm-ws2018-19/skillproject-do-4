package com.amazon.ask.alibi.handlers;

import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class SimpleHandlerTests {
    @ParameterizedTest
    @MethodSource("createHandlers")
    public void testCanHandle(RequestHandler handler) {
        MockHandlerInputFactory.createCanHandleTest(handler).run();
    }

    @ParameterizedTest
    @MethodSource("createHandlerPairs")
    public void testHandle(RequestHandler handler, String contains) {
        MockHandlerInputFactory.createHandleTest(handler, contains).run();
    }

    private static Stream<Arguments> createHandlers() {
        return Arrays.asList(
                new CancelIntentHandler(),
                new DateIntentHandler(),
                new FallbackIntentHandler(),
                new HelpIntentHandler(),
                new LaunchRequestHandler(),
                new LocationIntentHandler(),
                new SessionEndedRequestHandler(),
                new StopIntentHandler()
        ).stream().map(Arguments::of);
    }

    private static Stream<Arguments> createHandlerPairs() {
        return Arrays.<Arguments>asList(
                Arguments.of(new CancelIntentHandler(), "Alibi Erstellung abgebrochen. Auf Wiedersehen!"),
                Arguments.of(new FallbackIntentHandler(), "Tut mir leid, das wei"),
                Arguments.of(new HelpIntentHandler(), "Ich erstelle dir ein Alibi. Gib Datum und Zeitpunkt an."),
                Arguments.of(new LaunchRequestHandler(), "Willkommen bei deiner Pers"),
                Arguments.of(new SessionEndedRequestHandler(), ""),
                Arguments.of(new StopIntentHandler(), "Auf Wiedersehen!")
        ).stream();
    }
}
