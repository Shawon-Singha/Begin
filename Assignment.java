package Shawon;
import java.util.Scanner;

public class Assignment {

    static double inputValue(String name, Scanner sc) {
        double value;
        do {
            System.out.print("Enter " + name + ": ");
            value = sc.nextDouble();
            if (value < 0) {
                System.out.println("Value cannot be negative. Please re-enter.");
            }
        } while (value < 0);
        return value;
    }

    static double calculate(double l, double w, int choice) {
        if (choice == 1)
            return l * w;
        else
            return 2 * (l + w);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double length = inputValue("length", sc);
        double width  = inputValue("width", sc);

        double area = calculate(length, width, 1);
        double perimeter = calculate(length, width, 2);

        System.out.println("\n--- Result ---");
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);

        sc.close();
    }
}
