import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //code here...
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    //review this method...
    private static boolean moreInput() {
        //determine if there is more input...
        System.out.println("Would you like to enter data?");
        System.out.print("Enter 1 to continue or 2 to quit: ");
        Scanner quitScan = new Scanner(System.in);
        int answer = quitScan.nextInt();
        //try->catch exception here...
        switch (answer)
        {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("ERROR - you need to enter 1 or 2...");
                return true;
        }
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        //loop to print out all info in bmi array...
        for (int i = 0; i < bmiData.size(); i++) {
            System.out.println("User " + (i+1) + "...");
            System.out.println("Height: " + bmiData.get(i).BMIHeight);
            System.out.println("Weight: " + bmiData.get(i).BMIWeight);
            System.out.println("BMI: " + bmiData.get(i).BMICalculated);
            System.out.println("Category: " + bmiData.get(i).BMICategory);
        }
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        //print out current individual's info here...
        System.out.println("Height: " + bmi.BMIHeight);
        System.out.println("Weight: " + bmi.BMIWeight);
        System.out.println("BMI: " + bmi.BMICalculated);
        System.out.println("Condition: " + bmi.BMICategory);
    }

    private static double getUserWeight() {
        Scanner weightScan = new Scanner(System.in);
        System.out.print("Enter your weight in pounds: ");
        double resultW = weightScan.nextDouble();
        resultW = resultW;
        //weightScan.nextLine();
        return resultW;
    }

    private static double getUserHeight() {
        Scanner heightScan = new Scanner(System.in);
        System.out.print("Enter your height in inches: ");
        double resultH = heightScan.nextDouble();
        //heightScan.nextLine();
        return resultH;
    }
}
