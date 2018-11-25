package edu.hm.sweng1.do4.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;

public class AlibiTest {

    Alibi alibi = null;

    @Before
    public void initialize() throws ParseException {
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
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    @Test
    public void testVariadicCtor() {
        Alibi alibi = new Alibi(null);
    }

    @Test
    public void testGetTarget() {
        assertEquals("teacher", alibi.getTarget());
    }

    @Test
    public void testGetSubject() {
        assertEquals("whatthehell", alibi.getSubject());
    }

    @Test
    public void testGetLocation() {
        assertEquals("school", alibi.getLocation());
    }

    @Test
    public void testGetEnvironment() {
        assertEquals("noone", alibi.getEnvironment());
    }

    @Test
    public void testGetActivity() {
        assertEquals("studying", alibi.getActivity());
    }

    @Test
    public void testGetStart() {
        assertEquals("morning", alibi.getStart());
    }

    @Test
    public void testGetEnd() {
        assertEquals("never", alibi.getEnd());
    }

    @Test
    public void testToString() {
        assertEquals("[teacher]-[whatthehell]-[school]-[noone]-[studying]-[morning]-[never]", alibi.toString());
    }

    @Test
    public void testCompareToNull() {
        assertEquals(1, alibi.compareTo(null));
    }

    @Test
    public void testCompareToSelf() {
        assertEquals(0, alibi.compareTo(alibi));
    }
}
