import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    void BodyMassIndex() {
        BodyMassIndex bmiTest = new BodyMassIndex(1.5, 55);
        assertEquals(17.7, bmiTest);
    }
}