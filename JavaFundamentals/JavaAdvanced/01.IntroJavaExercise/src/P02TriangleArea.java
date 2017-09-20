import java.util.Scanner;

public class P02TriangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int point1X = scanner.nextInt();
        int point1Y = scanner.nextInt();
        int point2X = scanner.nextInt();
        int point2Y = scanner.nextInt();
        int point3X = scanner.nextInt();
        int point3Y = scanner.nextInt();

        double area = Math.abs((point1X * (point2Y - point3Y) + point2X * (point3Y - point1Y) + point3X * (point1Y - point2Y)) / 2);

        System.out.printf("%.0f", area);
    }
}
