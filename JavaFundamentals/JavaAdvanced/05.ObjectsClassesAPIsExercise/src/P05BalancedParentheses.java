import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Character> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        boolean unbalanced = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                stack.push(input.charAt(i));
            } else {
                if (stack.size() > 0 &&
                        (input.charAt(i) == ')' && stack.peek() == '(' ||
                                input.charAt(i) == '}' && stack.peek() == '{' ||
                                input.charAt(i) == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    System.out.println("NO");
                    unbalanced = true;
                    break;
                }
            }
        }
        if (!unbalanced && stack.size() == 0) {
            System.out.println("YES");
        }
    }
}
