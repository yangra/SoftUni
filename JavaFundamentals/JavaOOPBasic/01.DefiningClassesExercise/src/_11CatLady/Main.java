package _11CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, BaseCat> cats = new HashMap<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("End".equalsIgnoreCase(input[0])) {
                break;
            }
            BaseCat cat = null;
            switch (input[0]) {
                case "Siamese":
                    cat = new Siamese(input[1], Double.parseDouble(input[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(input[1], Double.parseDouble(input[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(input[1], Double.parseDouble(input[2]));
                    break;
            }
            cats.put(input[1],cat);
        }

        String query = reader.readLine();
        System.out.println(cats.get(query));

    }
}
