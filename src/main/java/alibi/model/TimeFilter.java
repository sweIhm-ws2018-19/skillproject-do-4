package alibi.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class which filters alibis according to the timespan.
 *
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public final class TimeFilter extends AlibiFilter {

    /**
     * The default format expected of a date.
     */
    public static final String DEFAULT_DATE_FORMAT = "HH.mm dd.MM.YYYY";

    /**
     * The start date of the filter.
     */
    private final String start;

    /**
     * The end date of the filter.
     */
    private final String end;

    /**
     * Format for parsing time input.
     */
    private DateTimeFormatter format;

    /**
     * Constructor.
     * @param newStart start.
     * @param newEnd   end.
     */
    public TimeFilter(final String newStart, final String newEnd) {
        this.start = newStart;
        this.end = newEnd;
        this.format = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
    }

    @Override
    public boolean filter(final Alibi alibi) {
        final boolean frontExcess = compare(alibi.getStart(), start) <= 0;
        final boolean frontOverlap = compare(start, alibi.getEnd()) <= 0;
        final boolean backExcess = compare(end, alibi.getEnd()) <= 0;
        final boolean backOverlap = compare(alibi.getStart(), end) <= 0;
        return (frontExcess && frontOverlap) || (backExcess && backOverlap);
    }

    /**
     * Compares two dates in String format with a given format.
     * @param firstDate  the first date.
     * @param secondDate the second date.
     * @return -1, if firstDate is before secondDate.
     * 0, if firstDate is equal to secondDate.
     * 1, if firstDate is after secondDate.
     */
    public int compare(final String firstDate, final String secondDate) {
        LocalDateTime first = LocalDateTime.parse(firstDate, format);
        LocalDateTime second = LocalDateTime.parse(secondDate, format);
        return first.compareTo(second);
    }
}
