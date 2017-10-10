import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P01MatchingBrackets {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch=='('){
                stack.push(i);
            }
            else if(ch==')'){
                String expression = input.substring(stack.pop(),i+1);
                System.out.println(expression);
            }
        }
    }
}
