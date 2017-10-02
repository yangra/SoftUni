import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P06MagicExchangeableWords {

    private static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        if (isChangeable(words[0], words[1])) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean isChangeable(String wordOne, String wordTwo) {

        if (wordTwo.length() > wordOne.length()) {
            return isChangeable(wordTwo, wordOne);

        } else {
            for (int i = 0; i < wordTwo.length(); i++) {
                if (!map.containsKey(wordTwo.charAt(i)) && !map.values().contains(wordOne.charAt(i))) {
                    map.put(wordTwo.charAt(i), wordOne.charAt(i));
                } else if (map.containsKey(wordTwo.charAt(i)) && !(map.get(wordTwo.charAt(i)) == wordOne.charAt(i))) {
                    return false;
                } else if (!map.containsKey(wordTwo.charAt(i)) && map.values().contains(wordOne.charAt(i))) {
                    return false;
                }
            }

            for (int i = wordTwo.length(); i < wordOne.length(); i++) {
                if (!map.values().contains(wordOne.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}