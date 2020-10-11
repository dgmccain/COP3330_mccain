abstract class Shape { //abstract class...
    /*
    // Declare 2D Shapes here...
    Shape2D Square;
    Shape2D Triangle;
    Shape2D Circle;

    // Declare 3D Shapes here...
    Shape3D Cube;
    Shape3D Pyramid;
    Shape3D Sphere;
    */

    /* Declare abstract methods for all Shape2D, and all but one for Shape3D here */
    //see if public needs to be protected instead...
    public abstract String getName() //abstract method...
    public abstract double getArea(); //abstract method...
}

abstract class Shape2D extends Shape { //abstract class...
    // Declare variables either here or in shape...

    /*
    double length;
    double height;
    */
}

abstract class Shape3D { //abstract class...
    public abstract double getVolume(); //abstract method...
    /*
    include length and height from Shape2D, then add width/base...
     */
}

// Consider Square class here that extends Shape2D...
/*
// This is what is automatically created within ShapeTest.java file to satisfy shape object...
public class Square extends Shape {
    public Square(int i) {
        super();
    }
}
*/