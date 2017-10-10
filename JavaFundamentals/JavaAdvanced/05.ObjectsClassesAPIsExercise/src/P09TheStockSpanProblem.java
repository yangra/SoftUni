import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P09TheStockSpanProblem {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfDays = Integer.parseInt(reader.readLine());

        int[] span = new int[numberOfDays];
        double[] prices = new double[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            double price = Double.parseDouble(reader.readLine());
            prices[i] = price;
        }

        calculateSpan(prices,numberOfDays,span);

        StringBuilder result = new StringBuilder();
        for (int i : span) {
            result.append(i).append("\r\n");
        }

        System.out.println(result.toString());
    }

    static void calculateSpan(double[] prices, int n, int[] span)
    {
        // Create a stack and push index of first element to it
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        span[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++)
        {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than prices[i]
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
                stack.pop();

            // If stack becomes empty, then prices[i] is greater than all elements
            // on left of it, i.e., prices[0], prices[1],..prices[i-1]. Else prices[i]
            // is greater than elements after top of stack
            span[i] = (stack.isEmpty())? (i + 1) : (i - stack.peek());

            // Push this element to stack
            stack.push(i);
        }
    }

}
