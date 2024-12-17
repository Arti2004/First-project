import java.util.Scanner;

public class StudentGradeCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // Input student name
    System.out.print("Enter student name: ");
    String studentName = scanner.nextLine().trim();
    if (studentName.isEmpty()) {
      System.out.println("Student name cannot be empty!");
      return;
    }

    // Input grades
    double assignmentGrade = getValidGrade(scanner, "assignment");
    double midtermGrade = getValidGrade(scanner, "midterm exam");
    double finalGrade = getValidGrade(scanner, "final exam");

    // Calculate overall grade
    double overallGrade = calculateOverallGrade(assignmentGrade, midtermGrade, finalGrade);

    // Display results
    displayResults(studentName, assignmentGrade, midtermGrade, finalGrade, overallGrade);

    // Close scanner
    scanner.close();
  }

  public static double getValidGrade(Scanner scanner, String gradeType) {
    double grade;
    while (true) {
      System.out.print("Enter " + gradeType + " grade (0 to 100): ");
      if (scanner.hasNextDouble()) {
        grade = scanner.nextDouble();
        if (grade >= 0 && grade <= 100) {
          break;
        } else {
          System.out.println("Grade must be between 0 and 100. Please try again.");
        }
      } else {
        System.out.println("Invalid input. Please enter a number.");
        scanner.next(); // Clear invalid input
      }
    }
    return grade;
  }

  public static double calculateOverallGrade(double assignmentGrade, double midtermGrade, double finalGrade) {
    return (assignmentGrade * 0.4) + (midtermGrade * 0.3) + (finalGrade * 0.3);
  }

  public static void displayResults(String studentName, double assignmentGrade, double midtermGrade, double finalGrade, double overallGrade) {
    System.out.println("\n--- Grade Report ---");
    System.out.println("Student Name: " + studentName);
    System.out.printf("Assignment Grade: %.2f%n", assignmentGrade);
    System.out.printf("Midterm Exam Grade: %.2f%n", midtermGrade);
    System.out.printf("Final Exam Grade: %.2f%n", finalGrade);
    System.out.printf("Overall Grade: %.2f%n", overallGrade);
    System.out.println("Letter Grade: " + getLetterGrade(overallGrade));
  }

  public static String getLetterGrade(double overallGrade) {
    if (overallGrade >= 90) return "A";
    else if (overallGrade >= 80) return "B";
    else if (overallGrade >= 70) return "C";
    else if (overallGrade >= 60) return "D";
    else return "F";
  }
}
