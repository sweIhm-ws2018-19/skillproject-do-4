package alibi.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationProviderTest {
    private static final String LOCATION_TAG = "Location: ";
    private static final String LOCATION_SANITY_CSV = "/LocationProviderInfo.csv";

    static AlibiProvider provider;

    @BeforeAll
    public static void setup() {
        provider = new LocationProvider();
    }

    @ParameterizedTest(name = "{index} => location={0}, noOfAlibis={1}, example={2}")
    @CsvFileSource(resources = LOCATION_SANITY_CSV)
    public void testProvideAlibi(String location, int noOfAlibis, String example) {
        List<String> locationList = Arrays.asList(LOCATION_TAG + location);
        Collection<Alibi> alibis = provider.provideAlibi(locationList);
        assertEquals(noOfAlibis, alibis.size(), "mismatcch between expected number of alibis and actual number of alibis");
        assertTrue(alibis.stream().anyMatch(alibi -> alibi.getActivity().equals(example)),
                "expected alibis" +
                "to contain \"" + example + "\", but does not");
    }
}
