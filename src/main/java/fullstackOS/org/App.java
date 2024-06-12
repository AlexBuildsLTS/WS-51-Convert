package fullstackOS.org;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            // Start with doing Display Menu
            displayMenu();

            // users gets choice
            int choice = getChoice(scanner);

            // Operations
            switch (choice) {
                case 1:
                    performConversion(scanner, "SEK", "USD");
                    break;
                case 2:
                    performConversion(scanner, "USD", "SEK");
                    break;
                case 3:
                    performConversion(scanner, "SEK", "EUR");
                    break;
                case 4:
                    performConversion(scanner, "EUR", "SEK");
                    break;
                case 0:
                    exit = true; // Set the exit flag to true to break the loop
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (!exit);

        scanner.close();
    }

    // Display menu for users
    private static void displayMenu() {
        System.out.println("\nCurrency Converter Menu:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to EUR");
        System.out.println("4. Convert EUR to SEK");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }


    private static int getChoice(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number between 0 and 4.");
        }
        return choice;
    }


    private static void performConversion(Scanner scanner, String fromCurrency, String toCurrency) {
        System.out.print("Enter amount in " + fromCurrency + ": ");
        String amountStr = scanner.nextLine();


        if (!InputValidator.isValidAmount(amountStr)) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }

        double amount = Double.parseDouble(amountStr);
        double convertedAmount = CurrencyConverter.convert(fromCurrency, toCurrency, amount);

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Display the conversion result
        System.out.printf("%.2f %s = %.2f %s (Conversion Date: %s)%n", amount, fromCurrency, convertedAmount, toCurrency, formattedDateTime);
    }
}
