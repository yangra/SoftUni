import java.util.Scanner;

public class P02AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = scanner.nextDouble();
        double secondNumber = scanner.nextDouble();
        double thirdNumber = scanner.nextDouble();

        double result = (firstNumber + secondNumber + thirdNumber)/3;

        System.out.printf("%.2f", result);
    }
}
