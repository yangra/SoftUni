import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P02HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split(" ");

        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();
        for (String player : players) {
            queue.offer(player);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < n-1; i++) {
                queue.offer(queue.poll());
            }

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}
