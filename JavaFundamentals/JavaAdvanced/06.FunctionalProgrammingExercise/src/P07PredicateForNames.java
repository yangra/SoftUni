import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P07PredicateForNames {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        Predicate<String> checkLength = string -> string.length() <= number;

        String[] input = reader.readLine().split(" ");

        Consumer<String> print = string -> System.out.println(string);

        for (String word : input) {
            if (checkLength.test(word)) {
                print.accept(word);
            }
        }
    }
}
