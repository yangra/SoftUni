import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> scores = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String student = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }

            double average = sum / grades.length;

            scores.put(student, average);
        }

        for (Map.Entry entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }
    }
}
