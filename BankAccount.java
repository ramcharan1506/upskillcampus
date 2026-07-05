public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;
    private String transactionHistory = "";

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount!");
            return;
        }

        balance += amount;
        transactionHistory += "Deposited Rs. " + amount + "\n";

        System.out.println("Deposit Successful!");
        System.out.println("Current Balance : Rs. " + balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
            return;
        }

        balance -= amount;
        transactionHistory += "Withdrawn Rs. " + amount + "\n";

        System.out.println("Withdrawal Successful!");
        System.out.println("Current Balance : Rs. " + balance);
    }

    public void checkBalance() {
        System.out.println("Available Balance : Rs. " + balance);
    }

    public void displayDetails() {

        System.out.println("\n========== ACCOUNT DETAILS ==========");

        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: Rs. " + balance);
    }

    public void showTransactionHistory() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        if (transactionHistory.isEmpty()) {
            System.out.println("No Transactions Yet.");
        } else {
            System.out.println(transactionHistory);
        }
    }
}