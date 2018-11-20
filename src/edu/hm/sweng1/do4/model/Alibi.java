package edu.hm.sweng1.do4.model;

import java.text.ParseException;

/**
 * Class which represents alibis.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public class Alibi implements Comparable {
    public static final int NUMBER_OF_ATTRIBUTES = 7;
    public static final String TO_STRING_SEPARATOR = "]-[";

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
     * The social environment of the subject which should support the alibi's authenticity..
     */
    private final String environment;

    /**
     * The alleged activity of the subject during the timespan covered by the alibi.
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
     * @param target       initial target.
     * @param subject      initial subject.
     * @param location     initial location.
     * @param environment  initial environment.
     * @param activity     initial activity.
     * @param start        initial start.
     * @param end          initial end.
     */
    public Alibi(String target, String subject, String location, String environment, String activity, String start, String end) throws ParseException {
        this.target = target;
        this.subject = subject;
        this.location = location;
        this.environment = environment;
        this.activity = activity;
        this.start = start;
        this.end = end;
    }
    /**
     * Constructor.
     * @param args  initial values.
     */
    public Alibi(String... args) {
        this.target = args[0];
        this.subject = args[1];
        this.location = args[2];
        this.environment = args[3];
        this.activity = args[4];
        this.start = args[5];
        this.end = args[6];
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
    public String toString(){
        return target + TO_STRING_SEPARATOR + subject + TO_STRING_SEPARATOR + location + TO_STRING_SEPARATOR + environment + TO_STRING_SEPARATOR + activity + TO_STRING_SEPARATOR + start + TO_STRING_SEPARATOR + end;
    }
    @Override
    public int compareTo(Object o) {
        return o != null ? this.toString().compareTo(o.toString()) : 1;
    }
}
