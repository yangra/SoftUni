import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P05AppliedArithmetic {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder result = new StringBuilder();
        while (true) {
            String command = reader.readLine();
            if (command.equalsIgnoreCase("end")) {
                break;
            }

            switch (command) {
                case "add":
                    executeCommand(numbers, x -> x + 1);
                    break;
                case "multiply":
                    executeCommand(numbers,x -> x * 2);
                    break;
                case "subtract":
                    executeCommand(numbers, x -> x - 1);
                    break;
                case "print":
                    for (int i = 0; i < numbers.length; i++) {
                        result.append(numbers[i] + " ");
                    }
                    result.append("\r\n");
                    break;
            }
        }

        System.out.println(result.toString());
    }

    private static void executeCommand(int[] numbers, Function<Integer, Integer> func) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = func.apply(numbers[i]);
        }
    }
}
