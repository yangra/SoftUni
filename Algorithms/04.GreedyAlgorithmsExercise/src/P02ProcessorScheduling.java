import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P02ProcessorScheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTasks = Integer.parseInt(reader.readLine().substring(7));
        List<int[]> tasks = new ArrayList<>();
        int maxDeadline = 0;
        for (int i = 0; i < numberOfTasks; i++) {
            String[] input = reader.readLine().split(" ");
            int value = Integer.parseInt(input[0]);
            int deadline = Integer.parseInt(input[2]);
            int[] task = new int[]{i + 1, value, deadline};
            if (deadline > maxDeadline) {
                maxDeadline = deadline;
            }
            tasks.add(task);
        }

        tasks.sort((a, b) -> Integer.compare(b[1], a[1]));

        List<int[]> result = tasks.subList(0,maxDeadline);

        result.sort((a, b) -> Integer.compare(a[2], b[2]));

        int totalValue = 0;
        System.out.print("Optimal schedule: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)[0]);
            if (i != result.size() - 1) {
                System.out.print(" -> ");
            }
            totalValue += result.get(i)[1];
        }
        System.out.println();
        System.out.printf("Total value: %d\n", totalValue);
    }
}
