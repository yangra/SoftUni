import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _02SortWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = Arrays.stream(reader.readLine().split(" ")).sorted().collect(Collectors.toList());

        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
