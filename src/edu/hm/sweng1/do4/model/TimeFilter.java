package edu.hm.sweng1.do4.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class which filters alibis according to the timespan.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public class TimeFilter extends AlibiFilter {

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
     * @param start  start.
     * @param end    end.
     */
    public TimeFilter(String start, String end) {
        this.start = start;
        this.end = end;
        this.format = DEFAULT_DATE_FORMAT;
    }

    /**
     * Constructor.
     * @param start  start.
     * @param end    end.
     * @param format    format.
     */
    public TimeFilter(String start, String end, String format) {
        this.start = start;
        this.end = end;
        this.format = format;
    }

    @Override
    public boolean filter(final Alibi alibi) {
        return compare(alibi.getStart(), start) <= 0 || compare(end, alibi.getEnd()) >= 0;
    }

    /**
     * Compares two dates in String format with a given format.
     * @param firstDate   the first date.
     * @param secondDate  the second date.
     * @return -1, if firstDate is before secondDate.
     *         0, if firstDate is equal to secondDate.
     *         1, if firstDate is after secondDate.
     */
    public int compare(String firstDate, String secondDate){
        try {
            Date first = new SimpleDateFormat(format).parse(firstDate);
            Date second = new SimpleDateFormat(format).parse(secondDate);
            return first.compareTo(second);
        } catch(ParseException pex){
            throw new RuntimeException(pex.getMessage());
        }
    }
}