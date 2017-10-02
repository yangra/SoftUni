import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> palindromes = new TreeSet<>();
        String text = scanner.nextLine();
        String pattern = "\\w+";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        while (matcher.find()){
            String word = matcher.group();
            StringBuilder reversed = new StringBuilder(word).reverse();
            if(word.equals(reversed.toString())){
                palindromes.add(word);
            }
        }

        System.out.println(palindromes);
    }
}
