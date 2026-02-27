import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFelineParametrised {

    private final int kittensCount;
    private final int expectedKittensCount;

    public TestFelineParametrised(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[] getKittensData() {
        return new Object[][] {
                {0, 0},
                {3, 3},
                {4, 4},
                {25, 25}
        };
    }

    @Test
    public void testGetKittensWithParameters() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(kittensCount);
        assertEquals(expectedKittensCount, kittens);
    }
}
