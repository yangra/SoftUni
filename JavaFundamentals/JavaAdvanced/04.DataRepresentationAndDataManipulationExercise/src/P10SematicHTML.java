import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10SematicHTML {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if ("END".equals(line)) {
                break;
            }

            input.append(line).append("\r\n");
        }

        String patternOpen = "<div\\s+(.*?)\\s*(id|class)\\s*=\\s*\"(main|header|nav|article|section|aside|footer)\"\\s*(.*?)\\s*>";
        String patternClose = "</div>\\s*<!--\\s*(main|header|nav|article|section|aside|footer)\\s*-->";

        Pattern regexOpen = Pattern.compile(patternOpen);
        Pattern regexClose = Pattern.compile(patternClose);
        Matcher matcherOpen = regexOpen.matcher(input);
        Matcher matcherClose = regexClose.matcher(input);
        while (matcherOpen.find(0)) {
            int matchStart = matcherOpen.start();
            int matchEnd = matcherOpen.end();

            if ("".equals(matcherOpen.group(1)) && "".equals(matcherOpen.group(4))) {
                input.replace(matchStart, matchEnd, "<" + matcherOpen.group(3) + ">");
            } else if (!"".equals(matcherOpen.group(1)) && "".equals(matcherOpen.group(4))) {
                input.replace(matchStart, matchEnd, "<" + matcherOpen.group(3) + " " +
                        matcherOpen.group(1).replaceAll("\\s+"," ") + ">");
            } else if ("".equals(matcherOpen.group(1)) && !"".equals(matcherOpen.group(4))) {
                input.replace(matchStart, matchEnd, "<" + matcherOpen.group(3) + " " +
                        matcherOpen.group(4).replaceAll("\\s+", " ") + ">");
            } else {
                input.replace(matchStart, matchEnd, "<" + matcherOpen.group(3) + " " +
                        matcherOpen.group(1).replaceAll("\\s+", " ") + " " +
                        matcherOpen.group(4).replaceAll("\\s+", " ") + ">");
            }
        }

        while (matcherClose.find(0)) {
            int matchStart = matcherClose.start();
            int matchEnd = matcherClose.end();

            input.replace(matchStart, matchEnd, "</" + matcherClose.group(1) + ">");
        }

        System.out.println(input.toString());

    }
}
