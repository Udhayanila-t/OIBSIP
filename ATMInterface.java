import java.util.*;

public class ATMInterface {

    static Scanner sc = new Scanner(System.in);

    static double balance = 1000.0;

    static String userID = "user123";
    static String userPin = "1234";

    static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("===== ATM INTERFACE =====");

        if (!login()) {
            System.out.println("Login Failed. Exiting...");
            sc.close();
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    showTransactionHistory();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using ATM!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 5);

        sc.close();
    }

    static boolean login() {

        System.out.print("Enter User ID: ");
        String enteredID = sc.next();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.next();

        if (enteredID.equals(userID)
                && enteredPin.equals(userPin)) {

            System.out.println("Login Successful!");
            return true;

        } else {

            System.out.println(
                "Invalid credentials. Access Denied."
            );
            return false;
        }
    }

    static void checkBalance() {

        System.out.println(
            "Available Balance: Rs. " + balance
        );
    }

    static void deposit() {

        System.out.print("Enter deposit amount: Rs. ");
        double amount = sc.nextDouble();

        if (amount > 0) {

            balance += amount;

            transactionHistory.add(
                "Deposited: Rs. " + amount
            );

            System.out.println(
                "Amount deposited successfully!"
            );

            System.out.println(
                "Updated Balance: Rs. " + balance
            );

        } else {

            System.out.println(
                "Please enter a valid amount."
            );
        }
    }

    static void withdraw() {

        System.out.print("Enter withdrawal amount: Rs. ");
        double amount = sc.nextDouble();

        if (amount <= 0) {

            System.out.println(
                "Please enter a valid amount."
            );

        } else if (amount > balance) {

            System.out.println(
                "Insufficient balance!"
            );

        } else {

            balance -= amount;

            transactionHistory.add(
                "Withdrawn: Rs. " + amount
            );

            System.out.println(
                "Please collect your cash."
            );

            System.out.println(
                "Remaining Balance: Rs. " + balance
            );
        }
    }

    static void showTransactionHistory() {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (transactionHistory.isEmpty()) {

            System.out.println(
                "No transactions found."
            );

        } else {

            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }
}