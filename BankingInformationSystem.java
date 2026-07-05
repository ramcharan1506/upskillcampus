import java.util.Scanner;

public class BankingInformationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("      BANKING INFORMATION SYSTEM");
        System.out.println("======================================");

        System.out.print("Enter Account Holder Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number : ");
        String accNo = sc.next();

        System.out.print("Enter Initial Balance : Rs. ");
        double balance = sc.nextDouble();

        System.out.print("Create 4-digit PIN : ");
        int pin = sc.nextInt();

        BankAccount account = new BankAccount(name, accNo, balance);

        System.out.println("\nAccount Created Successfully!");

        // Login

        System.out.println("\n=========== LOGIN ===========");

        boolean authenticated = false;
        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter PIN : ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {

                authenticated = true;
                System.out.println("\nLogin Successful!");
                break;

            } else {

                attempts--;

                if (attempts > 0)
                    System.out.println("Incorrect PIN! Attempts Left : " + attempts);

            }

        }

        if (!authenticated) {

            System.out.println("\nAccount Locked!");
            sc.close();
            return;

        }

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("             MENU");
            System.out.println("==================================");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Deposit Amount : Rs. ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:

                    System.out.print("Enter Withdrawal Amount : Rs. ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:

                    account.checkBalance();
                    break;

                case 4:

                    account.displayDetails();
                    break;

                case 5:

                    account.showTransactionHistory();
                    break;

                case 6:

                    System.out.println("\nThank You For Using Banking Information System!");
                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

        sc.close();

    }
}