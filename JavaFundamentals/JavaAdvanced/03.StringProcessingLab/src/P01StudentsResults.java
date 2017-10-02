import java.util.Scanner;

public class P01StudentsResults {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] result = scanner.nextLine().split("-");
        String name = result[0].trim();
        String[] grades = result[1].trim().split(", ");

        double grade1 = Double.parseDouble(grades[0]);
        double grade2 = Double.parseDouble(grades[1]);
        double grade3 = Double.parseDouble(grades[2]);
        double average = (grade1 + grade2 + grade3) / 3;

        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|\n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|\n", name, grade1, grade2, grade3, average);
    }
}
