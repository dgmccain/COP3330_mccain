import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    void TestScore() {
        //bmi score will round because bmi object is set to round all values to 2 decimal places...
        BodyMassIndex bmiTest = new BodyMassIndex(70.5678, 140.000);
        assertEquals(19.7, bmiTest.BMIScore);
    }

    @Test
    void TestCategory1() {
        BodyMassIndex bmiTest = new BodyMassIndex(74.12, 140.03953);
        assertEquals("Underweight", bmiTest.BMICategory);
    }

    //TEST OTHER 3 CATEGORIES...
    @Test
    void TestCategory2() {
        BodyMassIndex bmiTest = new BodyMassIndex(70.3, 130);
        assertEquals("Normal weight", bmiTest.BMICategory);
    }

    @Test
    void TestCategory3() {
        BodyMassIndex bmiTest = new BodyMassIndex(68, 170);
        assertEquals("Overweight", bmiTest.BMICategory);
    }

    @Test
    void TestCategory4() {
        BodyMassIndex bmiTest = new BodyMassIndex(71.01, 251.301);
        assertEquals("Obese", bmiTest.BMICategory);
    }
}