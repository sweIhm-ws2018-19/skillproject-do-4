package com.amazon.ask.alibi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlibiStreamHandlerTest {
    @Test
    public void testGetSkill() {
        assertDoesNotThrow(AlibiStreamHandler::new);
    }
}
