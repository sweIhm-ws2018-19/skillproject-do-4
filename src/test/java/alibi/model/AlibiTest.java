package alibi.model;

import main.java.alibi.model.Alibi;
import org.junit.Assert;
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
        Assert.assertEquals("teacher", alibi.getTarget());
    }

    @Test
    public void testGetSubject() {
        Assert.assertEquals("whatthehell", alibi.getSubject());
    }

    @Test
    public void testGetLocation() {
        Assert.assertEquals("school", alibi.getLocation());
    }

    @Test
    public void testGetEnvironment() {
        Assert.assertEquals("noone", alibi.getEnvironment());
    }

    @Test
    public void testGetActivity() {
        Assert.assertEquals("studying", alibi.getActivity());
    }

    @Test
    public void testGetStart() {
        Assert.assertEquals("morning", alibi.getStart());
    }

    @Test
    public void testGetEnd() {
        Assert.assertEquals("never", alibi.getEnd());
    }

    @Test
    public void testToString() {
        Assert.assertEquals(
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
        Assert.assertEquals("comparing an alibi to itself, expected 0, got " + alibi.compareTo(alibi),
                0, alibi.compareTo(alibi));
    }
}
