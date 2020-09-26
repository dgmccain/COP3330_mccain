import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    void TestScore() {
        //bmi score will round because bmi object is set to round all values to 2 decimal places...
        BodyMassIndex bmiTest = new BodyMassIndex(70.5678, 140.000);
        assertEquals(19.76, bmiTest.BMICalculated);
    }

    @Test
    void TestCategory() {
        BodyMassIndex bmiTest = new BodyMassIndex(70, 140);
        assertEquals("Normal weight", bmiTest.BMICategory);
    }
}