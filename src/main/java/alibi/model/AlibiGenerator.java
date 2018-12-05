package alibi.model;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class which generates alibis.
 * @author tphan
 * @version 1.0.0
 * 19.11.2018
 */
public final class AlibiGenerator {

    /**
     * Response prefix.
     */
    private static final String RESPONSE_PREFIX = "Du hast ";
    /**
     * The sources of the alibi data.
     */
    private final Collection<AlibiProvider> providers;

    /**
     * The filters of the alibi data.
     */
    private final Collection<AlibiFilter> filters;

    /**
     * Constructor for use in productive version.
     * @param start  start of the alibi timespan.providers
     * @param end    end of the alibi timespan.
     */
    public AlibiGenerator(final String start, final String end) {
        providers = new ArrayList<>();
        filters = new ArrayList<>();

//        providers.add(new CSVProvider());
        providers.add(new JokerProvider());

//        filters.add(new TimeFilter(start, end));
        filters.add(new UniversalFilter());
    }

    /**
     * Constructor for use during testing.
     * @param providers  initial providers.
     * @param filters    initial filters.
     */
    AlibiGenerator(final Collection<AlibiProvider> providers, Collection<AlibiFilter> filters) {
        this.providers = providers;
        this.filters = filters;
    }

    /**
     * Extracts the search criteria from the raw request.
     * Currently a mock dummy implementation.
     * @param rawRequest  the request as accepted by the generator.
     * @return  a selection of terms (phrases and words) that will
     * be given to the providers.
     */
    private Collection<String> extractCriteriaFrom(final String rawRequest) {
        List<String> criteria = new ArrayList<>();
        criteria.add(rawRequest);
        return criteria;
    }

    /**
     * Composes the generator's response.
     * Currently a mock dummy implementation.
     * @param alibis   the filtered alibis.
     * @return a response as given by the generator.
     */
    private String composeResponse(final Collection<Alibi> alibis) {
        String response = RESPONSE_PREFIX;
        ArrayList<Alibi> list = new ArrayList<>(alibis);
        response += list.get(new Random().nextInt(list.size())).getActivity();
        return response;
    }

    /**
     * Generates the alibi(s) from a given request and returns the result(s).
     * @param request  the request as accepted by the generator.
     * @return  the response as given by the generator.
     */
    public String generateAlibi(final String request) {
        final Collection<String> criteria = extractCriteriaFrom(request);
        Collection<Alibi> allAlibis = new TreeSet<>();
        Collection<Alibi> allValidAlibis = new TreeSet<>();

        for (AlibiProvider provider : providers) {
            allAlibis.addAll(provider.provideAlibi(criteria));
        }

        for (AlibiFilter filter : filters) {
            allValidAlibis.addAll(filter.filter(allAlibis));
        }
        return composeResponse(allValidAlibis);
    }
}
