import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class TestFeline {

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

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Хищник");
        assertTrue(food.contains("Животные"));
    }
}