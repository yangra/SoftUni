import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Optional;

public class P06FindAndSumIntegers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Optional<Integer> result = Arrays.stream(reader.readLine().split(" "))
                .filter(s -> s != null && s.length() > 0)
                .filter(s -> isNumber(s))
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y);

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String str) {
        return str.matches("[-]?[0-9]+");
    }
}
