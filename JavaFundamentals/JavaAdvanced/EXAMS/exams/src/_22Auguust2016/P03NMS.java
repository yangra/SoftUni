package _22Auguust2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P03NMS {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        while (true) {
            String input = reader.readLine();
            if ("---NMS SEND---".equalsIgnoreCase(input)) {
                words.add(word.toString());
                break;
            }

            String copy = input.toLowerCase();

            if (word.length() > 0 && Character.toLowerCase(word.charAt(word.length() - 1)) > copy.charAt(0)) {
                words.add(word.toString());
                word = new StringBuilder();
            }

            for (int i = 0; i < input.length(); i++) {
                if (i == input.length() - 1) {
                    word.append(input.charAt(i));
                    continue;
                }

                if (copy.charAt(i) <= copy.charAt(i + 1)) {
                    word.append(input.charAt(i));
                } else {
                    word.append(input.charAt(i));
                    words.add(word.toString());
                    word = new StringBuilder();
                }


            }
        }

        String separator = reader.readLine();

        for (int i = 0; i < words.size(); i++) {
            if (i == words.size() - 1) {
                System.out.print(words.get(i));
                continue;
            }
            System.out.print(words.get(i) + separator);
        }
    }
}
