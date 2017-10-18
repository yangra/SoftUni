import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P01TakeTwo {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<Integer> comparison = x -> x >= 10 && x <= 20;

        Consumer<Integer> print = x -> System.out.print(x + " ");

        Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .filter(comparison)
                .distinct()
                .limit(2)
                .forEach(print);

    }
}
