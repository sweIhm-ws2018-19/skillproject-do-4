package main.java.alibi.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class which filters alibis according to the timespan.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public final class TimeFilter extends AlibiFilter {

    /**
     * The default format expected of a date.
     */
    public static final String DEFAULT_DATE_FORMAT = "HH.mm dd.MM.yyyy";

    /**
     * The start date of the filter.
     */
    private final String start;

    /**
     * The end date of the filter.
     */
    private final String end;

    /**
     * The date format of the filter.
     */
    private final String format;

    /**
     * Constructor.
     * @param newStart  start.
     * @param newEnd    end.
     */
    public TimeFilter(final String newStart, final String newEnd) {
        this.start = newStart;
        this.end = newEnd;
        this.format = DEFAULT_DATE_FORMAT;
    }

    /**
     * Constructor.
     * @param newStart  start.
     * @param newEnd    end.
     * @param newFormat    format.
     */
    public TimeFilter(final String newStart,
                      final String newEnd, final String newFormat) {
        this.start = newStart;
        this.end = newEnd;
        this.format = newFormat;
    }

    @Override
    public boolean filter(final Alibi alibi) {
        return compare(alibi.getStart(), start) <= 0
                || compare(end, alibi.getEnd()) >= 0;
    }

    /**
     * Compares two dates in String format with a given format.
     * @param firstDate   the first date.
     * @param secondDate  the second date.
     * @return -1, if firstDate is before secondDate.
     *         0, if firstDate is equal to secondDate.
     *         1, if firstDate is after secondDate.
     */
    public int compare(final String firstDate, final String secondDate) {
        try {
            Date first = new SimpleDateFormat(format).parse(firstDate);
            Date second = new SimpleDateFormat(format).parse(secondDate);
            return first.compareTo(second);
        } catch (ParseException pex) {
            throw new RuntimeException(pex.getMessage());
        }
    }
}
