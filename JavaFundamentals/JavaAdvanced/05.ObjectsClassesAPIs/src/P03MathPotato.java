import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P03MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();
        for (String player : players) {
            queue.offer(player);
        }

        int turn = 1;
        while (queue.size() > 1) {
            for (int i = 0; i < n-1 ; i++) {
                queue.offer(queue.poll());
            }

            if(isPrime(turn)){
                System.out.println("Prime "+ queue.peek());
            }else{
                System.out.println("Removed " + queue.poll());
            }
            turn++;
        }

        System.out.println("Last is "+ queue.poll());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
