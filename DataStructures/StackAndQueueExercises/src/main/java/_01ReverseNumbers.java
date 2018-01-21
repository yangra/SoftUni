import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _01ReverseNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : input) {
            if (!s.equals("")) {
                stack.push(Integer.parseInt(s));
            }
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
