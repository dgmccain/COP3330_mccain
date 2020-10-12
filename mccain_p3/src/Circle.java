import java.lang.Math.*;

public class Circle extends Shape2D {
    //private variables of Circle...
    private final double pi = Math.PI; //Math.PI is more precise than just 3.14...
    private final double radius;

    //constructor...
    public Circle(double radiusInput) {
        //store inputs to private variables within Triangle...
        radius = radiusInput;
    }

    //check to see if overriding is correct...
    @Override
    public String getName() {
        return "circle"; //returns name of shape...
    }

    @Override
    public double getArea() {
        double area = (pi * radius * radius);
        return area; //returns area of shape...
    }
}
