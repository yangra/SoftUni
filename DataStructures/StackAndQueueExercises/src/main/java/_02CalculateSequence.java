import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _02CalculateSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int next = start;
        queue.offer(start);
        while (result.size() < 50) {
            queue.offer(next + 1);
            queue.offer(2 * next + 1);
            queue.offer(next + 2);
            result.add(queue.poll());
            next = queue.peek();
        }

        int count = 0;
        for (Integer integer : result) {
            System.out.print(integer);
            if (count != 49) {
                System.out.print(", ");
            }
            count++;
        }
    }
}
