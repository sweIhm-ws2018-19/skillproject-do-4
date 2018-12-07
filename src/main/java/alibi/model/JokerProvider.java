package alibi.model;

import java.text.ParseException;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Provides joke alibis.
 * @author tphan.
 * @version 1.0.0
 * 29.11.2018
 */
public class JokerProvider implements AlibiProvider {
    @Override
    public final Collection<Alibi> provideAlibi(final Collection<String> criteria) {
        Collection<Alibi> result = new TreeSet<>();
        result.add(new Alibi("", "", "", "", "hast Date mit Alexa gehabt.", "", ""));
        result.add(new Alibi("", "", "", "", "hast für Softwareentwicklung 3 gelernt.", "", ""));
        result.add(new Alibi("", "", "", "", "hast mit 40 Grad Fieber im Bett gelegen.", "", ""));
        return result;
    }
}
