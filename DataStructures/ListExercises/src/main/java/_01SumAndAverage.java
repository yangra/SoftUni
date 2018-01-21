
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _01SumAndAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums;
        try {
            nums = Arrays.stream(reader.readLine().split(" "))
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        }catch (NumberFormatException nfe){
            nums = new ArrayList<>();
        }

        Integer sum = nums.size() > 0 ? nums.stream().reduce((a, b) -> a + b).get() : 0;
        double average = nums.size() > 0 ? nums.stream().reduce((a, b) -> a + b).get() / (double) nums.size() : 0;

        System.out.printf("Sum=%d; Average=%.2f\n", sum, average);
    }
}
