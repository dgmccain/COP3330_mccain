import java.util.ArrayList;
import java.util.Arrays;  //not currently used in App...
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

    //determine if there is more input...
    private static boolean moreInput() {
        System.out.println("Would you like to enter data?");
        System.out.print("Enter Y to continue or N to quit: ");
        Scanner quitScan = new Scanner(System.in);
        String answer = quitScan.nextLine();
        switch (answer)
        {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("ERROR - you need to enter Y or N...");
                return true;
        }
    }

    //loop to print out all info in bmi array...
    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double sum = 0;
        double average = 0;
        for (int i = 0; i < bmiData.size(); i++) {
            sum += bmiData.get(i).BMICalculated;

            //removed because only the BMI info is needed to average all users' data...
            /*
            System.out.println("User " + (i+1) + "...");
            System.out.println("Height: " + bmiData.get(i).BMIHeight);
            System.out.println("Weight: " + bmiData.get(i).BMIWeight);
            System.out.println("BMI: " + bmiData.get(i).BMICalculated);
            System.out.println("Category: " + bmiData.get(i).BMICategory);
             */
        }
        average = sum / bmiData.size();
        average = Math.round(average * 100); //round average to 2 decimal places...
        average = average / 100;
        System.out.println("Average BMI of all users: " + average);
    }

    //print out current individual's info here...
    private static void displayBmiInfo(BodyMassIndex bmi) {
        //System.out.println("Height: " + bmi.BMIHeight);
        //System.out.println("Weight: " + bmi.BMIWeight);
        System.out.println("BMI: " + bmi.BMICalculated);
        System.out.println("Condition: " + bmi.BMICategory);
    }

    private static double getUserWeight() {
        Scanner weightScan = new Scanner(System.in);
        double resultW;
        do {
            System.out.print("Enter your weight in pounds: ");
            resultW = weightScan.nextDouble();
            weightScan.nextLine();
            if (resultW < 0) {
                System.out.println("You have to enter a positive number...");
            }
        } while (resultW < 0);
        return resultW;
    }

    private static double getUserHeight() {
        Scanner heightScan = new Scanner(System.in);
        double resultH;
        do {
            System.out.print("Enter your height in inches: ");
            resultH = heightScan.nextDouble();
            heightScan.nextLine();
            if (resultH < 0) {
                System.out.println("You have to enter a positive number...");
            }
        } while (resultH < 0);
        return resultH;
    }
}
