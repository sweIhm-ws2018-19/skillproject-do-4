package edu.hm.sweng1.do4.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Abstract class for alibi filters.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public abstract class AlibiFilter {

    /**
     * Constructor.
     */
    public AlibiFilter(){}

    /**
     * Filters alibis according to the corresponding restraints.
     * @param alibis  the alibis to be filtered.
     * @return the filtered alibis.
     */
    public Collection<Alibi> filter(final Collection<Alibi> alibis){
        Collection<Alibi> result = new TreeSet<>();
        alibis.stream().filter(this::filter).forEach(result::add);
        return result;
    }

    /**
     * Filters a single Alibi by applying corresponding restraints.
     * @param alibi  the alibi to be filtered.
     * @return true, if this alibi is to be kept.
     *         false, if this alibi is to be filtered.
     */
    public abstract boolean filter(Alibi alibi);
}
