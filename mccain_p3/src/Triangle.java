public class Triangle extends Shape2D {
    //private variables of Triangle...
    private final double base;
    private final double height;

    //constructor...
    public Triangle(double baseInput, double heightInput) {
        //store inputs to private variables within Triangle...
        base = baseInput;
        height = heightInput;
    }

    //check to see if overriding is correct...
    @Override
    public String getName() {
        return "triangle"; //returns name of shape...
    }

    @Override
    public double getArea() {
        return ((base * height) / 2); //returns area of shape...
    }
}
