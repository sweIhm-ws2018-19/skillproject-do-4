package edu.hm.sweng1.do4.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TimeFilterTestParametrized {
    private Alibi alibi;
    private TimeFilter filter;
    private boolean accepts;

    public TimeFilterTestParametrized(
            final String alibiBegin,
            final String alibiEnd,
            final String filterBegin,
            final String filterEnd,
            final boolean accepts) throws ParseException {
        alibi = new Alibi(
                "foo",
                "foo",
                "foo",
                "foo",
                "foo",
                alibiBegin,
                alibiEnd);
        this.filter = new TimeFilter(filterBegin, filterEnd);
        this.accepts = accepts;
    }

    @Test
    public void testFilter() {
        assert (filter.filter(alibi));
    }


    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        String begin = "00.00 00.00.0010";
        String end = "00.00 00.00.0021";
        String before = "00.00 00.00.0009";
        String after = "00.00 00.00.0022";
        return Arrays.asList(new Object[][] {
                {begin, end, begin, end, true},
                {begin, begin, begin, begin, true},
                {begin, end, begin, begin, false},
                {before, end, begin, end, false},
                {begin, after, begin, end, false}
        });
    }
}
