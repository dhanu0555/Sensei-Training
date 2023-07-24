import java.util.Scanner;

 class ATM {
    private static String password = "1234";
    private static double balance = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        // Password authentication
        boolean authenticated = false;
        for (int attempts = 3; attempts > 0; attempts--) {
            System.out.print("Enter your password: ");
            String passwordInput = scanner.nextLine();

            if (passwordInput.equals(password)) {
                authenticated = true;
                break;
            } else {
                System.out.println("Incorrect password. Attempts left: " + (attempts - 1));
            }
        }

        if (!authenticated) {
            System.out.println("Too many failed attempts. Exiting.");
            System.exit(0);
        }

        // Main menu
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Change Password");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    changePassword(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. Current balance: $" + balance);
        }
    }

    private static void changePassword(Scanner scanner) {
        System.out.print("Enter the current password: ");
        String currentPassword = scanner.nextLine();

        if (!currentPassword.equals(password)) {
            System.out.println("Incorrect password. Cannot change password.");
            return;
        }

        System.out.print("Enter the new password: ");
        String newPassword = scanner.nextLine();
        System.out.print("Confirm the new password: ");
        String confirmNewPassword = scanner.nextLine();

        if (!newPassword.equals(confirmNewPassword)) {
            System.out.println("Password confirmation does not match. Password not changed.");
            return;
        }

        password = newPassword;
        System.out.println("Password changed successfully.");
    }

}