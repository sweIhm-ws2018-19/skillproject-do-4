package alibi.model;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JokerProviderTest {
    @Test
    public void testProvideAlibiCount() {
        AlibiProvider provider = new JokerProvider();
        Collection<Alibi> alibis = provider.provideAlibi(null);
        assertEquals(3, alibis.size());
        for (Alibi alibi : alibis) {
            assertFalse(alibi.getActivity().isEmpty());
        }
    }
}
