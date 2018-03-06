import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        Dictionary<Character, Integer> letters = new Dictionary<>();
        for (int i = 0; i < text.length(); i++) {
            Character letter = text.charAt(i);
            if(!letters.containsKey(letter)){
                letters.add(letter,1);
            }else {
                letters.addOrReplace(letter,letters.get(letter) + 1);
            }
        }

        for (KeyValue<Character, Integer> letter : letters.sortByKey()) {
            System.out.printf("%s: %d time/s\n", letter.getKey(),letter.getValue());
        }

    }
}
