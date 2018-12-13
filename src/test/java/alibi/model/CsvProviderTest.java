
package alibi.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class CsvProviderTest {

    PrintStream stderr;
    ByteArrayOutputStream errorStream;


    Supplier<String> getErrorMessage(String filename, boolean expected) {
        String exists = expected ? "should exist, but doesnt" : "should not exist, but does";
        return () -> "File \"" + filename + "\"" + exists;
    }

    /**
     * returns path to file if it exists, else null.
     * @param filename filename.
     * @return /path/to/file or null.
     */
    private String pathFromFilename(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filename);
        return resource == null ? null : resource.getPath();
    }

    @BeforeEach
    public void setup() throws UnsupportedEncodingException {
        errorStream = new ByteArrayOutputStream();
        stderr = new PrintStream(errorStream, true, "UTF-8");
        System.setErr(stderr);
    }

    @AfterEach
    public void teardown() {
        String errorOutput = errorStream.toString();
        if (!errorOutput.isEmpty()) {
            System.out.println("got an errormessage");
            System.out.println(errorOutput);
        }
        //TODO: include this when logging works
        //assertTrue(errorOutput.isEmpty());
    }


    @Test
    public void testProvideAlibi() {
        String filename = "alibisource.csv";
        String path = pathFromFilename(filename);
        assertTrue(Files.exists(Paths.get(path)), getErrorMessage(filename, true));
        CSVProvider provider = new CSVProvider(path);
        Collection<Alibi> coll = provider.provideAlibi(null);
        assertEquals(3, coll.size(), "wrong number of provided alibis");
        for (Alibi item : coll) {
            assertEquals("teacher", item.getTarget());
            assertEquals("school", item.getLocation());
            assertEquals("whatthehell", item.getSubject());
            assertEquals("studying", item.getActivity());
            assertEquals("noone", item.getEnvironment());
            assertEquals("01.00 01.01.2000", item.getStart());
        }
        ArrayList<Alibi> list = new ArrayList(coll);
        assertEquals("01.00 01.01.2010", list.get(0).getEnd());
        assertEquals("01.00 01.01.2020", list.get(1).getEnd());
        assertEquals("01.00 01.01.2030", list.get(2).getEnd());
    }

    @Test
    public void testProvideAlibiFailsOnNonExistentFile() throws UnsupportedEncodingException {
        String path = "/not_existing_file";
        String nonExistingPath = pathFromFilename(path);
        assertNull(nonExistingPath, getErrorMessage(path, false));
        CSVProvider provider = new CSVProvider(path);
        assertDoesNotThrow(() -> provider.provideAlibi(null));
    }

    @Test
    public void testProvideAlibiFailOnCsvWithInsufficientColumns() {
        String filename = "CsvProviderInsufficientRows.csv";
        String tooLittleColumns = pathFromFilename(filename);
        assertNotNull(tooLittleColumns, getErrorMessage(filename, true));
        CSVProvider provider = new CSVProvider(tooLittleColumns);
        Collection<Alibi> alibis = provider.provideAlibi(null);
        assertEquals(0, alibis.size(), "expected empty alibi collection");
    }

    @Test
    public void testProvideAlibiOnNonCsvFile() throws UnsupportedEncodingException {
        String file = "file_for_csv_provider_with_incorrect_format";
        String path = pathFromFilename(file);
        assertNotNull(path, getErrorMessage(file, true));
        CSVProvider provider = new CSVProvider(path);
        Collection<Alibi> alibis = provider.provideAlibi(null);
        assertEquals(0, alibis.size(), "expected 0 alibis");
    }

    @Test
    public void testCtorNoArgs() {
        assertDoesNotThrow((ThrowingSupplier<CSVProvider>) CSVProvider::new);
    }
}
