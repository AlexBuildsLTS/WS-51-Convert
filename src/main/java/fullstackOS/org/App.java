package fullstackOS.org;
import fullstackOS.org.CurrencyConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    performConversion(scanner, "SEK", "USD");
                    break;
                case "2":
                    performConversion(scanner, "USD", "SEK");
                    break;
                case "3":
                    performConversion(scanner, "SEK", "EUR");
                    break;
                case "4": performConversion(scanner, "EUR", "SEK");
                    break;
                case "0":
                    exit = true;
                    System.out.println("Shutting down...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nCurrency Converter Menu:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK ");
        System.out.println("3. Convert SEK to EUR");
        System.out.println("4. Convert Eur to SEK");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);

        System.out.println("Converted Amount: " + convertedAmount + " " + toCurrency);
    }
}