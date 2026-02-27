import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestLion {
    @Mock
    private Feline mockFeline;

    @Test
    public void testLionCreationMale() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionCreationFemale() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionCreationWithInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Не самец и не самка", mockFeline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    public void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        int kittens = lion.getKittens();
        assertEquals(3, kittens);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Антилопы", "Зебры");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
