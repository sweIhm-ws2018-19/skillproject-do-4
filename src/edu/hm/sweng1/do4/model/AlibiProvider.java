package edu.hm.sweng1.do4.model;

import java.util.Collection;

/**
 * Abstract class for alibi providers.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public abstract class AlibiProvider {

    /**
     * Constructor.
     */
    public AlibiProvider(){}

    /**
     * Provides alibis according to the search criteria.
     * @param searchCriteria  the search criteria.
     * @return alibis found by this instance.
     */
    public abstract Collection<Alibi> provideAlibi(final Collection<String> searchCriteria);
}
