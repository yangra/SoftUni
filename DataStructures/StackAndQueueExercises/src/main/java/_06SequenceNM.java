import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _06SequenceNM {

    private static StringBuilder RESULT = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        Item n = new Item(Integer.parseInt(input[0]), null);
        Item m = new Item(Integer.parseInt(input[1]), null);

        Deque<Item> queue = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();
        queue.offer(n);
        StringBuilder result = new StringBuilder();
        while (queue.size() > 0) {
            Item element = queue.poll();

            if (element.value == m.value) {
                RESULT.append(n.value);
                printReverse(element);
                break;
            }

            if (element.value < m.value && !visited.contains(element.value)) {
                queue.offer(new Item(element.value + 1, element));
                queue.offer(new Item(element.value + 2, element));
                queue.offer(new Item(element.value * 2, element));

            }
            visited.add(element.value);
        }

        System.out.print(RESULT.toString());
    }

    private static void printReverse(Item element) {
        if (element.prev == null) {
            return;
        }

        printReverse(element.prev);

        RESULT.append(" -> ").append(element.value);
    }

    private static class Item {
        private int value;
        private Item prev;


        public Item(int value, Item prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
