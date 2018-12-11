package alibi.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Collection;
import java.util.TreeSet;

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
     * Logger.
     */
    public static final Logger LOGGER = LogManager.getLogger(CSVProvider.class);

    /**
     * I/O error message.
     */
    private static final String IO_ERROR_MESSAGE =
            "I/O error occurred in CSVProvider while parsing CSV file";

    /**
     * Format error message.
     */
    private static final String FORMAT_ERROR_MESSAGE =
            "illegal csv format in CSVProvider";

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
            LOGGER.error(IO_ERROR_MESSAGE, iox);
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
            LOGGER.error(FORMAT_ERROR_MESSAGE);
            return null;
        }
        return new Alibi(parts);
    }
}
