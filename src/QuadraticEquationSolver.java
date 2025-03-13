import java.io.*;
import java.nio.file.*;
import java.util.*;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        if (args.length == 0) {
            interactiveMode();
        } else {
            System.out.println("Error. Invalid number of arguments.");
        }
    }

    private static void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        double a = getValidCoefficient(scanner, "a");
        double b = getValidCoefficient(scanner, "b");
        double c = getValidCoefficient(scanner, "c");
        solveAndPrintEquation(a, b, c);
    }

    private static double getValidCoefficient(Scanner scanner, String coeffName) {
        while (true) {
            System.out.print(coeffName + " = ");
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error. Expected a valid real number.");
            }
        }
    }

    private static void solveAndPrintEquation(double a, double b, double c) {
        System.out.printf("Equation is: (%.1f) x^2 + (%.1f) x + (%.1f) = 0%n", a, b, c);
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("There are 2 roots");
            System.out.printf("x1 = %.1f%n", root1);
            System.out.printf("x2 = %.1f%n", root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("There are 1 roots");
            System.out.printf("x1 = %.1f%n", root);
        } else {
            System.out.println("There are 0 roots");
        }
    }
}
