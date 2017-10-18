import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P03FirstName {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stream<String> names = Arrays.stream(reader.readLine().split(" "));
        List<String> letters = Arrays.stream(reader.readLine().split(" "))
                .map(s->s.toLowerCase())
                .collect(Collectors.toList());

        Optional<String> name = names.filter(s->letters.contains(String.valueOf(s.charAt(0)).toLowerCase()))
                .sorted()
                .findFirst();

        if(name.isPresent()){
            System.out.println(name.get());
        }else{
            System.out.println("No match");
        }

    }
}
