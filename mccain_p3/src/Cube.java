public class Cube extends Shape3D {
    //private variables of Triangle...
    private final double sidesLength;

    //constructor...
    public Cube(double sidesInput) {
        //store inputs to private variables within Triangle...
        sidesLength = sidesInput;
    }

    //Override superclass...
    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return 6 * (sidesLength * sidesLength);
    }

    @Override
    public double getVolume() {
        return (sidesLength * sidesLength * sidesLength);
    }
}