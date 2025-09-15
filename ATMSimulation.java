import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMSimulation {

private double balance;

public ATMSimulation(double initialBalance) {
    this.balance = initialBalance;
}

// Check balance
public void checkBalance() {
    System.out.printf("Your current balance is: $%.2f%n", balance);
}

// Deposit money
public void deposit(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Deposit amount must be positive.");
    }
    balance += amount;
    System.out.printf("$%.2f deposited successfully.%n", amount);
}

// Withdraw money
public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Withdrawal amount must be positive.");
    }
    if (amount > balance) {
        throw new ArithmeticException("Insufficient funds for withdrawal.");
    }
    balance -= amount;
    System.out.printf("$%.2f withdrawn successfully.%n", amount);
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
ATMSimulation atm = new ATMSimulation(1000.00); // Starting with $1000

    System.out.println("Welcome to the ATM Machine!");

    while (true) {
        System.out.println("\nSelect an option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number between 1 and 4.");
            scanner.nextLine();  // Clear invalid input
            continue;
        }

        try {
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please select option between 1 and 4.");
            }
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction completed.\n");
        }
    }
}
}


