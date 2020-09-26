public class BodyMassIndex {
    public double BMIHeight;
    public double BMIWeight;
    public double BMICalculated;
    public String BMICategory;
    public BodyMassIndex(double height, double weight) {
        //rounding
        height = Math.round(height * 100); //round height to 2 decimal places - part 1...
        height = height / 100;             //round height to 2 decimal places - part 2...

        weight = Math.round(weight * 100); //round weight same as height...
        weight = weight / 100;

        double bmi = (703 * weight) / (height * height); //703 * pounds for bmi calculation...
        bmi = Math.round(bmi * 100); //round bmi too...
        bmi = bmi / 100;

        //assigning values
        this.BMIHeight = height;
        this.BMIWeight = weight;
        this.BMICalculated = bmi;

        //category conditions
        if (bmi < 18.5) {
            this.BMICategory = "Underweight";
        }
        else if (bmi >= 18.5 && bmi <= 24.9) {
            this.BMICategory = "Normal weight";
        }
        else if (bmi >= 25 && bmi <= 29.9) {
            this.BMICategory = "Overweight";
        }
        else {
            this.BMICategory = "Obese";
        }
    }
}
