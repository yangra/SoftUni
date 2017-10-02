import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractTags {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pattern = "<.+?>";
        while(true){
            String line = scanner.nextLine();
            if(line.equals("END")){
                break;
            }
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(line);

            while(matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
