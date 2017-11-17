package _06BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> birthables = new ArrayList<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(input[0])) {
                break;
            }
            Birthable birthable = null;
            switch (input[0].toLowerCase()) {
                case "citizen":
                    birthable = new Citizen(input[3], input[1], Integer.parseInt(input[2]), input[4]);
                    break;
                case "pet":
                    birthable = new Pet(input[1], input[2]);
                    break;

            }
            if (birthable != null) {
                birthables.add(birthable);
            }
        }

        String year = reader.readLine();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthdate().endsWith(year)) {
                System.out.println(birthable.getBirthdate());
            }
        }

    }
}
