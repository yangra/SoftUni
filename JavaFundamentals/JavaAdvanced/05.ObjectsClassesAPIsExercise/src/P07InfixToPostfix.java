import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);

        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();
        Pattern number = Pattern.compile("([0-9])+(\\.[0-9]*)?");
        Pattern var = Pattern.compile("[a-z]");

        String[] expression = scanner.nextLine().split(" ");

        for (int i = 0; i < expression.length; i++) {
            String token = expression[i];
            Matcher numMatcher = number.matcher(token);
            Matcher varMatcher = var.matcher(token);
            if (numMatcher.find()||varMatcher.find()) {
                outputQueue.add(expression[i]);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && priorities.get(token) <= priorities.get(operatorStack.peek())) {
                    outputQueue.add(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }
    }
}
