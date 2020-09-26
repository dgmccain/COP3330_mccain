public class BodyMassIndex {
    private double BMIHeight;
    private double BMIWeight;
    private double BMICalculated;
    public BodyMassIndex(double height, double weight) {
        double bmi = weight / (height * height);
        this.BMIHeight = height;
        this.BMIWeight = weight;
        this.BMICalculated = bmi;
    }
}
