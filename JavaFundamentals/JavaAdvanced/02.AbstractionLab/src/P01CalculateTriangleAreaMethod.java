import java.util.Scanner;

public class P01CalculateTriangleAreaMethod {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] sides = scanner.nextLine().split(" ");
        double sideA = Double.parseDouble(sides[0]);
        double sideB = Double.parseDouble(sides[1]);

        double area = calculateArea(sideA, sideB);

        System.out.printf("Area = %.2f", area);
    }

    private static double calculateArea(double sideA, double sideB) {
        return (sideA * sideB) / 2;
    }
}
