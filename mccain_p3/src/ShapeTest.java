import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    //Square Tests...
    @Test
    public void TestSquareName()
    {
        Shape shape = new Square(10);
        assertEquals("square", shape.getName());
    }

    @Test
    public void TestSquareArea()
    {
        //Shape2D shape = new Square(10);
        //assertEquals(100, shape.getArea());
    }

    @Test
    public void TestSquareArea2()
    {
        //Shape2D shape = new Square(0.5);
        //assertEquals(0.25, shape.getArea());
    }


    //Triangle Tests...
    @Test
    public void TestTriangleName()
    {
        //Shape shape = new Triangle(100, 100);
        //assertEquals("triangle", shape.getName());
    }

    @Test
    public void TestTriangleArea()
    {
        //Shape2D shape = new Triangle(10, 10);
        //assertEquals(50, shape.getArea());
    }

    @Test
    public void TestTriangleArea2()
    {
        //Shape2D shape = new Triangle(0.5, 0.25);
        //assertEquals(0.063, shape.getArea(), 0.001);
    }


    //Circle Tests...
    @Test
    public void TestCircleName()
    {
        //Shape shape = new Circle(10);
        //assertEquals("circle", shape.getName());
    }

    @Test
    public void TestCircleArea()
    {
        //Shape2D shape = new Circle(10);
        //assertEquals(314.16, shape.getArea(), 0.01);
    }

    @Test
    public void TestCircleArea2()
    {
        //Shape2D shape = new Circle(0.5);
        //assertEquals(0.79, shape.getArea(), 0.01);
    }
}