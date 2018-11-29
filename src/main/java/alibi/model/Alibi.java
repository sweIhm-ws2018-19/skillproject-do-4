package alibi.model;

import java.text.ParseException;

/**
 * Class which represents alibis.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public final class Alibi implements Comparable {

    /**
     * The number of attributes.
     */
    public static final int NUMBER_OF_ATTRIBUTES = 7;

    /**
     * Separator used in toString()-method.
     */
    public static final String TO_STRING_SEPARATOR = ":-:";

    /**
     * The target who is supposed to believe the alibi.
     */
    private final String target;

    /**
     * The subject for which the alibi is created.
     */
    private final String subject;

    /**
     * The location of the subject to which the alibi is supposed to testify.
     */
    private final String location;

    /**
     * The social environment of the subject which
     * should support the alibi's authenticity.
     */
    private final String environment;

    /**
     * The alleged activity of the subject during the
     * timespan covered by the alibi.
     */
    private final String activity;

    /**
     * The start of the alibi's timespan.
     */
    private final String start;

    /**
     * The end of the alibi's timespan.
     */
    private final String end;

    /**
     * Constructor.
     * @param newTarget       initial target.
     * @param newSubject      initial subject.
     * @param newLocation     initial location.
     * @param newEnvironment  initial environment.
     * @param newActivity     initial activity.
     * @param newStart        initial start.
     * @param newEnd          initial end.
     * @throws ParseException if there is a parse error with the dates.
     */
    public Alibi(final String newTarget,
                 final String newSubject,
                 final String newLocation,
                 final String newEnvironment,
                 final String newActivity,
                 final String newStart,
                 final String newEnd) throws ParseException {
        this.target = newTarget;
        this.subject = newSubject;
        this.location = newLocation;
        this.environment = newEnvironment;
        this.activity = newActivity;
        this.start = newStart;
        this.end = newEnd;
    }
    /**
     * Constructor.
     * @param args  initial values.
     */
    public Alibi(final String... args) {
        this.target = args[0];
        this.subject = args[1];
        this.location = args[2];
        this.environment = args[2 + 1];
        this.activity = args[2 + 2];
        this.start = args[2 + 2 + 1];
        this.end = args[2 + 2 + 2];
    }

    /**
     * Getter for target.
     * @return target.
     */
    public String getTarget() {
        return target;
    }

    /**
     * Getter for subject.
     * @return subject.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Getter for location.
     * @return location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for environment.
     * @return environment.
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * Getter for activity.
     * @return activity.
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Getter for start.
     * @return start.
     */
    public String getStart() {
        return start;
    }

    /**
     * Getter for end.
     * @return end.
     */
    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return target + TO_STRING_SEPARATOR
                + subject + TO_STRING_SEPARATOR
                + location + TO_STRING_SEPARATOR
                + environment + TO_STRING_SEPARATOR
                + activity + TO_STRING_SEPARATOR
                + start + TO_STRING_SEPARATOR + end;
    }
    @Override
    public int compareTo(final Object o) {
        if (o == null) {
            return 1;
        } else {
            return this.toString().compareTo(o.toString());
        }
    }
}
