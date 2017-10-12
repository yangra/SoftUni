import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class P03CountUppercaseWords {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("\\s+");

        Predicate<String> checkForUpperLetter = x-> Character.isUpperCase(x.charAt(0));
        ArrayList<String> result = new ArrayList<>();
        for (String word : text) {
            if(checkForUpperLetter.test(word)){
                result.add(word);
            }
        }

        System.out.println(result.size());
        for (String word : result) {
            System.out.println(word);
        }
    }
}
