package alibi.model;

import java.util.Collection;

/**
 * Abstract class for alibi providers.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public interface AlibiProvider {

    /**
     * Provides alibis according to the search criteria.
     *
     * @param criteria the search criteria.
     * @return alibis found by this instance.
     */
    Collection<Alibi> provideAlibi(Collection<String> criteria);
}
