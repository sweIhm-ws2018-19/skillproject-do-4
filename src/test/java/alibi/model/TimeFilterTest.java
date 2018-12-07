package alibi.model;

import alibi.model.TimeFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;


public class TimeFilterTest {
    private static final String BEGIN = "00.00 01.01.2010";
    private static final String END = "00.00 01.01.2021";
    private static final String BEFORE = "00.00 01.01.2009";
    private static final String AFTER = "00.00 01.01.2022";

    @Test
    public void testCompareToYear() {
        String begin = "00.00 01.01.2000";
        String end = "00.00 01.01.2001";
        TimeFilter filter = new TimeFilter(begin, end);
        assertEquals(-1, filter.compare(begin, end));
        assertEquals(1, filter.compare(end, begin));
        assertEquals(0, filter.compare(end, end));
    }

    @Test
    public void testCompareToCombination() {
        String begin = "01.00 01.03.2000";
        String end = "10.00 01.01.2001";
        TimeFilter filter = new TimeFilter(begin, end);
        assertEquals(-1, filter.compare(begin, end));
    }

    @ParameterizedTest
    @CsvSource({
            BEGIN + "," + END + "," + BEGIN + "," + END + "," + "true",
            BEGIN + "," + BEGIN + "," + BEGIN + "," + BEGIN + "," + "true",
            END + "," + AFTER + "," + BEGIN + "," + END + "," + "false",
            BEFORE + "," + BEFORE + "," + BEGIN + "," + END + "," + "false",
            BEGIN + "," + AFTER + "," + BEGIN + "," + END + "," + "true"
    })
    public void testFilter(
            String alibiBegin,
            String alibiEnd,
            String filterBegin,
            String filterEnd,
            boolean accepts) throws ParseException {
        Alibi alibi = new Alibi(
                "foo",
                "foo",
                "foo",
                "foo",
                "foo",
                alibiBegin,
                alibiEnd);
        TimeFilter filter = new TimeFilter(filterBegin, filterEnd);
        assertEquals(accepts, filter.filter(alibi),
                "for alibiBegin = " + alibiBegin + " and " +
                        " alibiEnd = " + alibiEnd +
                        " for filter with begin = " + filterBegin + " and " +
                        " filterEnd = " + filterEnd + " expected to be " + accepts +
                        " which is not the case");
    }

}
