import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

public class P03CustomMinFunction {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        Function<String[],Integer[]> parse = strings-> Stream.of(strings)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Integer[] numbers = parse.apply(input);

        Function<Integer[],Integer> min = integers -> Stream.of(integers)
                .min(Comparator.comparing(i->i)).get();

        System.out.println(min.apply(numbers));

    }
}
