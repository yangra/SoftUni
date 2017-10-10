import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13HandsOfCards {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> result = new LinkedHashMap<>();

        while (true) {
            String line = reader.readLine();
            if ("joker".equalsIgnoreCase(line)) {
                break;
            }

            String[] params = line.split(":");
            String name = params[0];
            String[] cards = params[1].trim().split(", ");
            if (!result.containsKey(name)) {
                Set<String> cardSet = new HashSet<>();
                cardSet.addAll(Arrays.asList(cards));

                result.put(name, cardSet);
            } else {
                for (String card : cards) {
                    result.get(name).add(card);
                }
            }
        }

        for (Map.Entry<String, Set<String>> entry : result.entrySet()) {
            int score = 0;
            for (String card : entry.getValue()) {
                int power = getCardPower(card);
                int type = getCardType(card);
                if (power != 0 && type != 0) {
                    score += power * type;
                }else{
                    System.out.println("Invalid input!");
                    return;
                }
            }

            System.out.printf("%s: %d\n", entry.getKey(), score);
        }
    }

    private static int getCardType(String card) {
        switch (card.charAt(card.length() - 1)) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
        }

        return 0;
    }

    private static int getCardPower(String card) {
        if (Character.isDigit(card.charAt(0))) {
            if (card.charAt(0) == '1') {
                return 10;
            } else {
                return Integer.valueOf(card.charAt(0) + "");
            }
        } else {
            switch (card.charAt(0)) {
                case 'J':
                    return 11;
                case 'Q':
                    return 12;
                case 'K':
                    return 13;
                case 'A':
                    return 14;
            }
        }

        return 0;
    }
}