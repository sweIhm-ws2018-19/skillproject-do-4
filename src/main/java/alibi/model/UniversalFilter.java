package alibi.model;

/**
 * Confirms all alibis.
 * @author tphan.
 * @version 1.0.0
 * 29.11.2018
 */
public class UniversalFilter extends AlibiFilter {

    @Override
    public final boolean filter(final Alibi alibi) {
        return true;
    }
}
