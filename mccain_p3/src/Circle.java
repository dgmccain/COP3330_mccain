import java.lang.Math.*;

public class Circle extends Shape2D {
    //private variables of Circle...
    private final double pi = Math.PI;
    private final double radius;

    //constructor...
    public Circle(double radiusInput) {
        //store input to private variables within Circle...
        radius = radiusInput;
    }

    //check to see if overriding is correct...
    @Override
    public String getName() {
        return "circle"; //returns name of shape...
    }

    @Override
    public double getArea() {
        return (pi * radius * radius); //returns area of shape...
    }
}
