package alibi.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlibiGeneratorTest {
    private static List<AlibiProvider> alibiProviders;
    private static List<AlibiFilter>  alibiFilters;
    @BeforeAll
    public static void setup() {
        alibiFilters = new ArrayList<>();
        alibiFilters.add(new UniversalFilter());
        alibiProviders = new ArrayList<>();
        ClassLoader classLoader = AlibiGeneratorTest.class.getClassLoader();
        Path file = Paths.get(classLoader.getResource("alibisource.csv").getPath());
        assertTrue(Files.exists(file));
        alibiProviders.add(new CSVProvider(file.toString()));
    }

    @Test
    public void generateAlibi() {
        AlibiGenerator generator = new AlibiGenerator(alibiProviders, alibiFilters);
        String output = generator.generateAlibi("foo");
        assertNotEquals(null, output, "alibi generator generated null output");
        assertFalse(output.isEmpty());
    }

    @Test
    public void testCtorStringString() {
        assertDoesNotThrow(() -> new AlibiGenerator((String) null, null));
    }
}
