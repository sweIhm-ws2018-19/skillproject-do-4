package alibi.model;

import main.java.alibi.model.TimeFilter;
import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class TimeFilterTest {

    @Test
    public void testCompareToYear() {
        String begin = "00.00 00.00.0000";
        String end = "00.00 00.00.0001";
        TimeFilter filter = new TimeFilter(begin, end);
        Assert.assertEquals(-1, filter.compare(begin, end));
        Assert.assertEquals(1, filter.compare(end, begin));
        Assert.assertEquals(0, filter.compare(end, end));
    }

    @Test
    public void testCompareToCombination() {
        String begin = "01.00 00.02.0000";
        String end = "10.00 00.00.0001";
        TimeFilter filter = new TimeFilter(begin, end);
        Assert.assertEquals(-1, filter.compare(begin, end));
    }

}
