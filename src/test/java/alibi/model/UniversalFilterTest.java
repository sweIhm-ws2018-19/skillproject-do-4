package alibi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniversalFilterTest {
    @Test
    public void testFilterNull() {
        AlibiFilter filter = new UniversalFilter();
        assertTrue(filter.filter((Alibi) null));
    }
}
