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
                "",
                "",
                "",
                "",
                "",
                "",
                "");
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
        assertEquals("comparing an alibi to itself, expected 0, got " + alibi.compareTo(alibi),
                0, alibi.compareTo(alibi));
    }
}
