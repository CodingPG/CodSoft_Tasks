import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}

// Class to represent the ATM
class ATM {
    private final BankAccount account;
    private final Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> {
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: %.2f%n", account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.printf("Successfully deposited %.2f. Your new balance is: %.2f%n", amount, account.getBalance());
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdrew %.2f. Your new balance is: %.2f%n", amount, account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        // Create a BankAccount object with an initial balance
        BankAccount account = new BankAccount(500); // Example: Initial balance of 500

        // Create an ATM object and pass the BankAccount to it
        ATM atm = new ATM(account);

        // Run the ATM interface
        atm.run();
    }
}