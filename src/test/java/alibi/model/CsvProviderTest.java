
package alibi.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class CsvProviderTest {


    @Test
    public void testProvideAlibi() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("alibisource.csv").getFile());
        assertTrue(file.exists());
        CSVProvider provider = new CSVProvider(file.getAbsolutePath());
        Collection<Alibi> coll = provider.provideAlibi(null);
        assertEquals(3, coll.size());
        for (Alibi item : coll) {
            assertEquals("teacher", item.getTarget());
            assertEquals("school", item.getLocation());
            assertEquals("whatthehell", item.getSubject());
            assertEquals("studying", item.getActivity());
            assertEquals("noone", item.getEnvironment());
            assertEquals("00.00 00.00.0000", item.getStart());
        }
        ArrayList<Alibi> list = new ArrayList(coll);
        assertEquals("00.00 00.00.0010", list.get(0).getEnd());
        assertEquals("00.00 00.00.0020", list.get(1).getEnd());
        assertEquals("00.00 00.00.0030", list.get(2).getEnd());
    }

    @Test
    public void testProvideAlibiFailsOnNonExistentFile() throws UnsupportedEncodingException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream stderr = new PrintStream(stream, true, "UTF-8");
        System.setErr(stderr);
        CSVProvider provider = new CSVProvider("not_existing_file");
        provider.provideAlibi(null);
        String errorOutput = stream.toString();
        assertFalse(errorOutput.isEmpty());
    }

    @Test
    public void testProvideAlibiOnNonCsvFile() throws UnsupportedEncodingException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream stderr = new PrintStream(stream, true, "UTF-8");
        System.setErr(stderr);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file_for_csv_provider_with_incorrect_format").getFile());
        assertTrue(file.exists());
        CSVProvider provider = new CSVProvider(file.getAbsolutePath());
        provider.provideAlibi(null);
        String errorOutput = stream.toString();
        assertFalse(errorOutput.isEmpty());
    }

    @Test
    public void testCtorNoArgs() {
        assertDoesNotThrow((ThrowingSupplier<CSVProvider>) CSVProvider::new);
    }
}
