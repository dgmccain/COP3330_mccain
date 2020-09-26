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
        //if statement goes here...
        return false;
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        //print array here...
        System.out.println(bmiData);
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        //print info here...
        System.out.println(bmi);
    }

    private static double getUserWeight() {
        Scanner weightScan = new Scanner(System.in);
        double resultW = weightScan.nextDouble();
        //weightScan.nextLine();
        return resultW;
    }

    private static double getUserHeight() {
        Scanner heightScan = new Scanner(System.in);
        double resultH = heightScan.nextDouble();
        //heightScan.nextLine();
        return resultH;
    }
}
