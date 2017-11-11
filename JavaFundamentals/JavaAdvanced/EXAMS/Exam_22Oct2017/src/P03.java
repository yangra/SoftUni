import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P03 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> following = new HashMap<>();
        Map<String, List<String>> followers = new LinkedHashMap<>();
        while (true) {
            String[] event = reader.readLine().split("\\s+");
            if ("Statistics".equals(event[0])) {
                break;
            }

            if ("joined".equals(event[1])) {
                followers.putIfAbsent(event[0], new ArrayList<>());
                following.putIfAbsent(event[0], 0L);
            } else if ("followed".equals(event[1])) {
                if (event[0].equals(event[2])) {
                    continue;
                }
                if (followers.containsKey(event[2]) &&
                        followers.containsKey(event[0]) &&
                        !followers.get(event[2]).contains(event[0])) {
                    followers.get(event[2]).add(event[0]);
                    if (following.containsKey(event[0])) {
                        following.put(event[0], following.get(event[0]) + 1);
                    }
                }

            }
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.\n", followers.size());
        followers = followers.entrySet().stream()
                .sorted((a, b) -> {
                    Integer firstFollowers = a.getValue().size();
                    Integer secondFollowers = b.getValue().size();
                    int result = secondFollowers.compareTo(firstFollowers);
                    if (result == 0) {
                        Long firstFollowing = following.get(a.getKey());
                        Long secondFollowing = following.get(b.getKey());
                        result = firstFollowing.compareTo(secondFollowing);
                    }
                    return result;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        int counter = 1;
        for (Map.Entry<String, List<String>> entry : followers.entrySet()) {
            System.out.printf("%d. %s : %d followers, %d following\n", counter, entry.getKey(), entry.getValue().size(),
                    following.get(entry.getKey()));
            if (counter == 1) {
                List<String> sorted = entry.getValue().stream()
                        .sorted((a, b) -> a.compareTo(b))
                        .collect(Collectors.toList());
                for (String s : sorted) {
                    System.out.printf("*  %s\n", s);
                }
            }
            counter++;
        }
    }
}
