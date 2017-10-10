import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ops = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int toPush = ops[0];
        int toPop = ops[1];
        int toCheck = ops[2];
        int[] values = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> stack = new ArrayDeque<>();
        if (values.length >= toPush) {
            for (int i = 0; i < toPush; i++) {

                stack.push(values[i]);
            }

            for (int i = 0; i < toPop; i++) {

                stack.pop();
            }

            if (stack.contains(toCheck)) {

                System.out.println(true);

            } else {

                int min = Integer.MAX_VALUE;
                for (int elem : stack) {
                    if (elem < min) {
                        min = elem;
                    }
                }

                System.out.println(stack.size()>0 ? min : 0);
            }

        } else {
            System.out.println("Invalid input");
        }
    }
}
