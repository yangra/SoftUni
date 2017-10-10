import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P03BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();

        int[] params = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int toEnqueue = params[0];
        int toDequeue = params[1];
        int toCheck = params[2];

        int[] values = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (values.length >= toEnqueue) {
            for (int i = 0; i < toEnqueue; i++) {
                queue.offer(values[i]);
            }

            for (int i = 0; i < toDequeue; i++) {
                queue.poll();
            }

            if (queue.contains(toCheck)) {
                System.out.println(true);
            } else {

                int min = Integer.MAX_VALUE;
                for (int elem : queue) {
                    if (elem < min) {
                        min = elem;
                    }
                }

                System.out.println(queue.size() > 0 ? min : 0);
            }

        } else {
            System.out.println("Invalid input");
        }
    }
}
