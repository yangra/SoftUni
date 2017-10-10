import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P04TruckTour {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<int[]> queue = new ArrayDeque<>();

        int numberOfPumps = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPumps; i++) {
            int[] params = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            queue.add(params);
        }

        for (int i = 0; i < numberOfPumps; i++) {
            long tank = 0;
            for (int[] pump : queue) {
                if (tank < 0) {
                   break;
                }

                tank += pump[0] - pump[1];
            }

            if (tank >= 0) {
                System.out.println(i);
                break;
            }

            queue.add(queue.poll());
        }
    }
}
