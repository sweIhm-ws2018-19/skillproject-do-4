package alibi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class AlibiTest {

    private static Alibi alibi;


    @BeforeAll
    public static void setup() throws ParseException {
        alibi = new Alibi(
                "teacher",
                "whatthehell",
                "school",
                "noone",
                "studying",
                "morning",
                "never"
        );
    }

    @Test
    public void testCtor() throws ParseException {
        Alibi alibi = new Alibi(
                "",
                "",
                "",
                "",
                "",
                "",
                "");
    }

    @Test
    public void testGetTarget() { assertEquals("teacher", alibi.getTarget()); }

    @Test
    public void testGetSubject() { assertEquals("whatthehell", alibi.getSubject()); }

    @Test
    public void testGetLocation() { assertEquals("school", alibi.getLocation()); }

    @Test
    public void testGetEnvironment() { assertEquals("noone", alibi.getEnvironment()); }

    @Test
    public void testGetActivity() { assertEquals("studying", alibi.getActivity()); }

    @Test
    public void testGetStart() { assertEquals("morning", alibi.getStart()); }

    @Test
    public void testGetEnd() { assertEquals("never", alibi.getEnd()); }

    @Test
    public void testToString() {
        assertEquals(
                "teacher" + Alibi.TO_STRING_SEPARATOR +
                "whatthehell" + Alibi.TO_STRING_SEPARATOR +
                "school" + Alibi.TO_STRING_SEPARATOR +
                "noone" + Alibi.TO_STRING_SEPARATOR +
                "studying" + Alibi.TO_STRING_SEPARATOR +
                "morning" + Alibi.TO_STRING_SEPARATOR +
                "never", alibi.toString());
    }

    @Test
    public void testCompareToSelf() {
        assertEquals(0, alibi.compareTo(alibi));
    }


    @Test
    public void testCompareToNull() {
        assertEquals(1, alibi.compareTo(null));
    }

    @Test
    public void testCtorVariadic() {
        Alibi alibi = new Alibi(new String[]{"foo", "bar", "baz", "foobar", "foobaz", "foofoo", "foofoofoo"});
        assertEquals("foo", alibi.getTarget());
        assertEquals("bar", alibi.getSubject());
        assertEquals("baz", alibi.getLocation());
        assertEquals("foobar", alibi.getEnvironment());
        assertEquals("foobaz", alibi.getActivity());
        assertEquals("foofoo", alibi.getStart());
        assertEquals("foofoofoo", alibi.getEnd());
    }
}
