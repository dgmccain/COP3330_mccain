import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    void TestHeight() {
        BodyMassIndex bmiTest = new BodyMassIndex(70, 140);
        assertEquals(70, bmiTest.BMIHeight);
    }

    @Test
    void TestWeight() {
        BodyMassIndex bmiTest = new BodyMassIndex(70, 140);
        assertEquals(140, bmiTest.BMIWeight);
    }

    @Test
    void TestBMI() {
        BodyMassIndex bmiTest = new BodyMassIndex(70, 140);
        assertEquals(20.09, bmiTest.BMICalculated);
    }

    @Test
    void TestCategory() {
        BodyMassIndex bmiTest = new BodyMassIndex(70, 140);
        assertEquals("Normal weight", bmiTest.BMICategory);
    }

    /*
    @Test
    void BodyMassIndex() {
        BodyMassIndex bmiTest = new BodyMassIndex(70, 140);
        assertEquals(70, bmiTest.BMIHeight);
        assertEquals(140, bmiTest.BMIWeight);
        assertEquals(20.09, bmiTest.BMICalculated);
        assertEquals(20.09, bmiTest.BMICategory);
    }
    */
}