package alibi.model;

/**
 * Test for model.
 * @author tphan.
 * @version 1.0.0
 * 29.11.2018
 */
public final class TestModel {

    /**
     * Private constructor.
     */
    private TestModel() { }

    /**
     * Main-method.
     * @param args arguments for main.
     */
    public static void main(final String... args) {
        final String output = new AlibiGenerator("", "").generateAlibi("");
        System.out.println(output);
    }

}
