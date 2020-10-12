public class Square extends Shape2D {

    //private variables of Square...
    private final double sideLength;

    //constructor...
    public Square(double sideInput) {
        sideLength = sideInput; //stores test case input as private variable within Square class...
    }

    //check to see if overriding is correct...
    @Override
    public String getName() {
        return "square"; //returns name of shape...
    }

    @Override
    public double getArea() {
        return (sideLength * sideLength); //returns area of shape...
    }
}
