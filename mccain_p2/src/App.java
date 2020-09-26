import java.util.ArrayList;
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
        //print array here...
        System.out.println(bmiData);
        //loop to print out info in array...
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        //print info here...
        System.out.println(bmi);
        //loop to print out info in array...
    }

    private static double getUserWeight() {
        Scanner weightScan = new Scanner(System.in);
        System.out.print("Enter your weight in pounds: ");
        double resultW = weightScan.nextDouble();
        resultW = resultW * 703; //703 is multiplied with pounds for bmi calculation...
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
