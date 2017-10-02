import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P11ReplaceATag {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //String pattern = "<a(\\s+href\\s*=\\s*.+?\\s*)>(\\s*.*?\\s*)</a>";
        String pattern = "<a(.+?)>(.*?)</a>";

        StringBuilder code = new StringBuilder();

        while (true) {
            String line = scanner.nextLine();
            if ("END".equals(line)) {
                break;
            }

            code.append(line).append("\n");
        }

        Pattern regex = Pattern.compile(pattern,Pattern.DOTALL);
        Matcher matcher = regex.matcher(code);

        while (matcher.find(0)) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            String replacement = "[URL" + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
            code.replace(startIndex, endIndex, replacement);
        }

//        String replacement = "[URL$1]$2[/URL]";
//        String result = matcher.replaceAll(replacement);

        System.out.println(code.toString());
    }
}
