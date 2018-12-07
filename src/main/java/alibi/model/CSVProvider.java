package alibi.model;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Collection;
import java.util.TreeSet;
import java.util.logging.Logger;

/**
 * Class for providing alibis from a CSV file.
 * @author tphan.
 * @version 1.0.0
 * 19.11.2018
 */
public final class CSVProvider implements AlibiProvider {

    /**
     * Default CSV source.
     */
    public static final String DEFAULT_SOURCE = "Default CSV source.csv";

    /**
     * CSV source.
     */
    private final String source;

    /**
     * Constructor.
     */
    public CSVProvider() {
        this.source = DEFAULT_SOURCE;
    }

    /**
     * Constructor.
     * @param newSource  source.
     */
    public CSVProvider(final String newSource) {
        this.source = newSource;
    }

    @Override
    public Collection<Alibi> provideAlibi(final Collection<String> criteria) {
        Collection<Alibi> alibis = new TreeSet<>();
        try {
            Files.readAllLines(Paths.get(source))
                    .forEach(line -> alibis.add(convertToAlibi(line)));
        } catch (IOException iox) {
            iox.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return alibis;
    }

    /**
     * Converts a CSV line into an alibi.
     * @param line  the line to be converted.
     * @return an alibi based on line.
     */
    private Alibi convertToAlibi(final String line) {
        String[] parts = line.split(Alibi.TO_STRING_SEPARATOR);
        if (parts.length != Alibi.NUMBER_OF_ATTRIBUTES) {
            throw new RuntimeException("illegal csv format");
        }
        return new Alibi(parts);
    }
}
