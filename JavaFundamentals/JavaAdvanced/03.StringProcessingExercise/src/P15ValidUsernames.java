import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P15ValidUsernames {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String patternUsername = "(?<=([ \\\\/()]|^))[a-zA-Z]\\w{2,24}(?=([ \\\\/()]|$))";
        Pattern usernamePattern = Pattern.compile(patternUsername);
        Matcher matchUsername = usernamePattern.matcher(input);
        List<String> usernames = new ArrayList<>();

        while(matchUsername.find()){
            usernames.add(matchUsername.group());
        }

        int bestSum = 0;
        int firstIndex = 0;
        for (int i = 0; i < usernames.size()-1; i++) {
            int sum = usernames.get(i).length() + usernames.get(i+1).length();
            if(sum>bestSum){
                bestSum = sum;
                firstIndex = i;
            }
        }

        System.out.println(usernames.get(firstIndex));
        System.out.println(usernames.get(firstIndex+1));
    }
}
