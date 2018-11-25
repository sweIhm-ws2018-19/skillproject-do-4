package edu.hm.sweng1.do4.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class CsvProviderTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCtorInvalidFile() {
        CSVProvider provider = new CSVProvider("banana");
    }

    @Test(expected = NullPointerException.class)
    public void testCtorNullFile() {
        CSVProvider provider = new CSVProvider(null);
    }

    @Test
    public void testProvideAlibi() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("alibisource.csv").getFile());
        CSVProvider provider = new CSVProvider(file.getAbsolutePath());
        Collection<Alibi> coll = provider.provideAlibi(null);
    }
}
