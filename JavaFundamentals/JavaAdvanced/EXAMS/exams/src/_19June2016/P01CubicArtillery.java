package _19June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01CubicArtillery {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer bunkerCapacity = Integer.parseInt(reader.readLine());

        Deque<String> bunkers = new ArrayDeque<>();
        Deque<Integer> weapons = new ArrayDeque<>();
        Integer sum = 0;

        Pattern regex = Pattern.compile("[a-zA-Z]");

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("Bunker".equalsIgnoreCase(input[0])) {
                break;
            }

            for (int i = 0; i < input.length; i++) {
                Matcher matcher = regex.matcher(input[i]);
                if (matcher.find()) {
                    bunkers.add(input[i]);

                } else {
                    Integer weapon = Integer.parseInt(input[i]);

                    if (bunkers.size() > 1) {
                        if (weapon + sum <= bunkerCapacity) {
                            sum += weapon;
                            weapons.add(weapon);
                        } else if (weapon + sum > bunkerCapacity) {
                            printBunker(bunkers.poll(), weapons);
                            weapons.clear();
                            sum = 0;
                            i--;
                        }

                    } else {
                        if (weapon + sum <= bunkerCapacity) {
                            sum += weapon;
                            weapons.add(weapon);
                        } else if (weapon + sum > bunkerCapacity && weapon <= bunkerCapacity) {

                            while (weapon + sum > bunkerCapacity) {
                                sum -= weapons.poll();
                            }

                            sum += weapon;
                            weapons.add(weapon);
                        }
                    }
                }
            }
        }

        System.out.println(result.toString());
    }

    private static void printBunker(String bunker, Deque<Integer> weapons) {
        result.append(String.format("%s -> %s\n", bunker, weapons.size() > 0 ? weapons
                .toString().replaceAll("[\\[\\]]", "") : "Empty"));
    }
}
