package edu.hm.sweng1.do4.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TimeFilterTest {

    @Test(expected = NullPointerException.class)
    public void testCtorWithNull() {
        TimeFilter filter = new TimeFilter(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoDateInput() {
        TimeFilter filter = new TimeFilter("banana", "pie");
    }

    @Test
    public void testCompareToYear() {
        String begin = "00.00 00.00.0000";
        String end = "00.00 00.00.0001";
        TimeFilter filter = new TimeFilter(begin, end);
        assertEquals(-1, filter.compare(begin, end));
        assertEquals(1, filter.compare(end, begin));
        assertEquals(0, filter.compare(end, end));
    }

    @Test
    public void testCompareToCombination() {
        String begin = "01.00 00.02.0000";
        String end = "10.00 00.00.0001";
        TimeFilter filter = new TimeFilter(begin, end);
        assertEquals(-1, filter.compare(begin, end));
    }

    @Test
    public void testFilterNull() {
        String begin = "00.00 00.00.0010";
        String end = "00.00 00.00.0021";
        TimeFilter filter = new TimeFilter(begin, end);
        Alibi newAlibi = null;
        assertFalse(filter.filter(newAlibi));
    }

}
