package edu.hm.sweng1.do4.model;

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
public class CSVProvider extends AlibiProvider {

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
    public CSVProvider(){
        this.source = DEFAULT_SOURCE;
    }

    /**
     * Constructor.
     * @param source  source.
     */
    public CSVProvider(final String source){
        this.source = source;
    }

    @Override
    public Collection<Alibi> provideAlibi(Collection<String> searchCriteria) {
        Collection<Alibi> alibis = new TreeSet<>();
        try{
            Files.readAllLines(Paths.get(source)).forEach(line -> alibis.add(convertToAlibi(line)));
        } catch (IOException iox) {
            iox.printStackTrace();
        }
        return alibis;
    }

    /**
     * Converts a CSV line into an alibi.
     * @param line  the line to be converted.
     * @return an alibi based on line.
     */
    private Alibi convertToAlibi(String line) {
        String[] parts = line.split(Alibi.TO_STRING_SEPARATOR);
        if(parts.length != Alibi.NUMBER_OF_ATTRIBUTES){
            throw new RuntimeException("CSV format failed");
        }
        return new Alibi(parts);
    }
}
