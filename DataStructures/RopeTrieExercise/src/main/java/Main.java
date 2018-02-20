import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TextEditor editor = new TextEditorImpl();
        Map<String, Boolean> users = new LinkedHashMap<>();


        Pattern regex = Pattern.compile("\"(.*)\"");
        String line = reader.readLine();
        while (true) {
            if (line.equals("end")) {
                break;
            }
            Matcher match = regex.matcher(line);
            String[] commandArgs = line.split(" ");
            commandArgs = Arrays.stream(commandArgs).filter(s -> s.length() > 0).toArray(String[]::new);
            try {
                switch (commandArgs[0]) {
                    case "login":
                        users.put(commandArgs[1], true);
                        editor.login(commandArgs[1]);
                        break;
                    case "logout":
                        users.put(commandArgs[1], false);
                        editor.logout(commandArgs[1]);
                        break;
                    case "users":
                        if (commandArgs.length == 2) {
                            Iterable<String> result = editor.users(commandArgs[1]);
                            for (String username : users.keySet()) {
                                for (String user : result) {
                                    if (username.equals(user) && users.get(user)) {
                                        System.out.println(user);
                                    }
                                }
                            }
                            break;
                        }
                        users.keySet().stream().filter(users::get).forEach(System.out::println);
                        break;
                }

                String username = commandArgs[0];
                if (!(users.containsKey(username) && users.get(username))) {
                    line = reader.readLine();
                    continue;
                }

                String str = "";
                if (match.find()) {
                    str = match.group(1);
                }

                switch (commandArgs[1]) {
                    case "insert":
                        editor.insert(username, Integer.parseInt(commandArgs[2]), str);
                        break;
                    case "prepend":
                        editor.prepend(username, str);
                        break;
                    case "substring":
                        editor.substring(username,
                                Integer.parseInt(commandArgs[2]),
                                Integer.parseInt(commandArgs[3]));
                        break;
                    case "delete":
                        editor.delete(username,
                                Integer.parseInt(commandArgs[2]),
                                Integer.parseInt(commandArgs[3]));
                        break;
                    case "clear":
                        editor.clear(username);
                        break;
                    case "length":
                        System.out.println(editor.length(username));
                        break;
                    case "print":
                        System.out.println(editor.print(username));
                        break;
                    case "undo":
                        editor.undo(username);
                        break;
                }
            } catch (Exception ex) {
            }
            line = reader.readLine();
        }

    }

}


