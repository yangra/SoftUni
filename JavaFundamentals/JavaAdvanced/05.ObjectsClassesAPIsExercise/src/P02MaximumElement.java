import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();

        int numberOfCommands = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = reader.readLine().split(" ");

            switch(command[0]){
                case"1":
                    pushToStack(stack, command[1]);
                    break;
                case"2":
                    popFromStack(stack);
                    break;
                case"3":
                    printStackMaxElement(stack);
                    break;
            }
        }
    }

    private static void printStackMaxElement(Deque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (int elem : stack) {
            if (elem > max) {
                max = elem;
            }
        }

        System.out.println(stack.size() > 0 ? max : 0);
    }

    private static void popFromStack(Deque<Integer> stack) {
        if (stack.size() > 0) {
            stack.pop();
        } else {
            System.out.println("Invalid command");
        }
    }

    private static void pushToStack(Deque<Integer> stack, String element) {
        int value = Integer.parseInt(element);
        stack.push(value);
    }
}
