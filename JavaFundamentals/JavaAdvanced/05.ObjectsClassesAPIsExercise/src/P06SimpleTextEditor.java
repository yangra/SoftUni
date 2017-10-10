import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P06SimpleTextEditor {

    private static StringBuilder text = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String[]> stack = new ArrayDeque<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "1":
                    text.append(command[1]);
                    stack.push(command);
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    String erased = text.substring(text.length() - count, text.length());
                    command[1] = erased;
                    stack.push(command);
                    eraseLast(count);
                    break;
                case "3":
                    int position = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(position - 1));
                    break;
                case "4":
                    String[] revert = stack.pop();
                    switch (revert[0]) {
                        case "1":
                            int length = revert[1].length();
                            eraseLast(length);
                            break;
                        case "2":
                            text.append(revert[1]);
                            break;
                    }
                    break;
            }
        }

    }

    private static void eraseLast(int count) {
        text = text.replace(text.length() - count, text.length(), "");
    }
}
