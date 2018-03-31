import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01Fibonacci {

   private static int[] numbers;
   private  static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        numbers = new int[number+1];

        int result = fibonacci(number);
        System.out.println(result);
    }

    private static int fibonacci(int number) {
        System.out.println(count++);

        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 1;
        }

        if(numbers[number]!=0){
            return numbers[number];
        }

        numbers[number] =  fibonacci(number - 1) + fibonacci(number - 2);
        return numbers[number];
    }
}
