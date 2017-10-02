import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05VowelCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String pattern = "[AEIOUYaeiouy]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        int counter = 0;
        while(matcher.find()){
            counter++;
        }

        System.out.printf("Vowels: %d", counter);
    }
}
