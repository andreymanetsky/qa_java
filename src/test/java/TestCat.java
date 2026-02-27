import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestCat {

    @Mock
    private Feline mockFeline;

    @Test
    public void testGetSoundReturnsCorrectValue() {
        Cat cat = new Cat(mockFeline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFoodReturnsMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(mockFeline);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}