public class Square extends Shape2D {

    //constructor...
    public Square(double num) {
        super();
    }
    //num is not stored in code because there are no class fields in Square or shape...

    @Override
    public String getName() {
        String shapeName = "square";
        return shapeName;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
