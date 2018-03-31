import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01FibonacciIterative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        int step = 2;
        int result = 0;
        int prevNum = 1;
        int prevPrevNum = 1;
        while (step <= number) {
            if (step == 2 ) {
                result += 1;
                step++;
                continue;
            } else {
                result = prevNum + prevPrevNum;
            }

            step++;
            prevPrevNum = prevNum;
            prevNum = result;

        }

        System.out.println(result);
    }

}
