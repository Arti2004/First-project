import java.util.Scanner;

public class BinaryConverter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Binary Converter Menu:");
      System.out.println("1. Decimal to Binary");
      System.out.println("2. Binary to Decimal");
      System.out.println("3. Exit");
      System.out.print("Choose option: ");

      // Validate menu input
      if (!scanner.hasNextInt()) {
        System.out.println("Invalid input. Please enter a number from the menu.");
        scanner.next(); // Consume the invalid input
        continue;
      }
      int option = scanner.nextInt();

      switch (option) {
        case 1:
          decimalToBinary(scanner);
          break;
        case 2:
          binaryToDecimal(scanner);
          break;
        case 3:
          System.out.println("Exiting...");
          scanner.close(); // Close scanner before exiting
          return;
        default:
          System.out.println("Invalid option. Please choose again.");
      }
    }
  }

  public static void decimalToBinary(Scanner scanner) {
    System.out.print("Enter decimal number: ");
    while (!scanner.hasNextInt()) {
      System.out.println("Invalid input. Please enter a valid decimal number.");
      scanner.next();
    }
    int decimal = scanner.nextInt();
    String binary = Integer.toBinaryString(decimal);
    System.out.println(decimal + " in binary is " + binary);
  }

  public static void binaryToDecimal(Scanner scanner) {
    System.out.print("Enter binary number: ");
    String binary = scanner.next();
    try {
      int decimal = Integer.parseInt(binary, 2);
      System.out.println(binary + " in decimal is " + decimal);
    } catch (NumberFormatException e) {
      System.out.println("Invalid binary number. Please enter only 0s and 1s.");
    }
  }
}
