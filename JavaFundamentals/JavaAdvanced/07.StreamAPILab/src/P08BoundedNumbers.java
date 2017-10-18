import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P08BoundedNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> bounds = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .filter(n -> n >= Collections.min(bounds) && n <= Collections.max(bounds))
                .forEach(n -> System.out.print(n + " "));
    }
}
