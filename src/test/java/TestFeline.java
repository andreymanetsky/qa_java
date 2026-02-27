import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestFeline {

    private final int kittensCount;
    private final int expectedKittensCount;

    public TestFeline(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = feline.eatMeat();
        assertTrue(expectedFood.contains("Животные"));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittensReturnsDefaultValue() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
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

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Хищник");
        assertTrue(food.contains("Животные"));
    }
}