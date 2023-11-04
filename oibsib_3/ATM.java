import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
 class Transaction {
    private Date date;
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.date = new Date();
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date + ": " + description + " $" + amount;
    }
}

 class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
} 

class User {
    private int id;
    private int pin;
    private String name;
    private List<Transaction> transactionHistory;
    private Account account;

    public User(int id, int pin, String name) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.transactionHistory = new ArrayList<>();
        this.account = new Account();
    }

    public static User authenticate(int userId, int userPin) {
        // Perform authentication logic here, e.g., checking credentials from a database
        // For simplicity, let's hardcode a single user for this example.
        if (userId == 1234 && userPin == 5678) {
            return new User(userId, userPin, "John Doe");
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void withdraw(Scanner scanner) {
        // Implement the withdraw logic
        System.out.println("Enter the amount you want to withdraw");
        double number = scanner.nextInt();
        account.withdraw(number);
    }

    public void deposit(Scanner scanner) {
        // Implement the deposit logic
        System.out.println("Enter the amount you want to deposit");
        double number = scanner.nextInt();
        account.deposit(number);
    }

    public void transfer(Scanner scanner) {
        // Implement the transfer logic
        System.out.println("Enter the amount you want to transfer");
        double number = scanner.nextInt();
        System.out.println("Enter account name you want to transfer");
        String name = scanner.next();
        User user = new User(1245, 4578, name);
        user.account.deposit(number);
        account.withdraw(number);
    }
}



public class ATM {
    private User currentUser;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM system!");

        // Simulate user authentication
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter User PIN: ");
        int userPin = scanner.nextInt();

        // Check authentication
        currentUser = User.authenticate(userId, userPin);

        if (currentUser == null) {
            System.out.println("Invalid user ID or PIN. Exiting...");
            return;
        }

        System.out.println("Welcome, " + currentUser.getName() + "!");
        showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Select an option:");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    currentUser.viewTransactionHistory();
                    break;
                case 2:
                    currentUser.withdraw(scanner);
                    break;
                case 3:
                    currentUser.deposit(scanner);
                    break;
                case 4:
                    currentUser.transfer(scanner);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
