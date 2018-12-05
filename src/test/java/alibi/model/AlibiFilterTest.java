package alibi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collection;
import java.util.function.Predicate;


public class AlibiFilterTest {
    static Collection<Alibi> defaultCollection;


    @BeforeAll
    public static void setup() {
        ClassLoader classLoader = AlibiFilterTest.class.getClassLoader();
        File file = new File(classLoader.getResource("alibisource.csv").getFile());
        assertTrue(file.exists());
        CSVProvider csvProvider = new CSVProvider(file.getAbsolutePath());
        defaultCollection = csvProvider.provideAlibi(null);
    }



    class LambdaAlibiFilter extends AlibiFilter {

        Predicate<Alibi> filter;

        LambdaAlibiFilter(Predicate<Alibi> alibiPredicate) {filter = alibiPredicate;}

        @Override
        public boolean filter(Alibi alibi) {
            return filter.test(alibi);
        }
    }

    @Test
    public void testFilterAcceptEach() {
        AlibiFilter testFilter = new LambdaAlibiFilter((alibi) -> true);
        Collection<Alibi> filteredAlibis = testFilter.filter(defaultCollection);
        assertEquals(3, filteredAlibis.size());
    }

    @Test
    public void testFilterDenyEach() {
        AlibiFilter testFilter = new LambdaAlibiFilter((alibi) -> false);
        Collection<Alibi> filteredAlibis = testFilter.filter(defaultCollection);
        assertEquals(0, filteredAlibis.size());
    }

    @Test
    public void testFilterSpecificEnd() {
        AlibiFilter testFilter =  new LambdaAlibiFilter((Alibi alibi) -> alibi.getEnd() == "00.00 00.00.0020");
        Collection<Alibi> filteredAlibis = testFilter.filter(defaultCollection);
        assertEquals(1, filteredAlibis.size(),
                "filtered alibis from alibisource.csv looling for \"00.00 00.00.0020\" as " +
                        "alibi end. expected one alibi. got none");
    }
}
