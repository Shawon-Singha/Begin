package Module3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double currentBalance = 500.00;

        while (true) {

            System.out.println("\n------- Welcome to the Simple Console ATM -------");
            System.out.println("Please select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Your current balance is: " + currentBalance + " taka");
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();

                    if (deposit <= 0) {
                        System.out.println("Invalid amount. Deposit must be positive.");
                    }
                    else {
                        currentBalance += deposit;
                        System.out.println("Deposit successful.");
                        System.out.println("Your current balance is: " + currentBalance + " taka");

                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= 0) {
                        System.out.println("Invalid amount. Withdrawal must be positive.");
                    }
                    else if (withdraw > 100) {
                        System.out.println("You can withdraw a maximum of 100 taka per transaction.");
                    }
                    else if (withdraw > currentBalance) {
                        System.out.println("Insufficient balance.");
                    }
                    else {
                        currentBalance -= withdraw;
                        System.out.println("Withdrawal successful.");
                        System.out.println("Your current balance is: " + currentBalance + " taka");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM! Goodbye");
                    sc.close();
                    return;   // exits program and loop

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
