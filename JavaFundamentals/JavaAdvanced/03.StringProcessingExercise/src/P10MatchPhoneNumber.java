import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10MatchPhoneNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String pattern= "^\\+359([\\s-])2\\1([0-9]){3}\\1([0-9]){4}$";
        Pattern regex = Pattern.compile(pattern);


        String line = scanner.nextLine();
        while(!"end".equals(line)){
            Matcher matcher = regex.matcher(line);

            if(matcher.find()){
                System.out.println(line);
            }

            line = scanner.nextLine();
        }
    }
}
