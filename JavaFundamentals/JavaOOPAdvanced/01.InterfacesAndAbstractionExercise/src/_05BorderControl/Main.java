package _05BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> citizens = new ArrayList<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(input[0])) {
                break;
            }
            Identifiable citizen = null;
            if (input.length == 2) {
                citizen = new Robot(input[1], input[0]);
            } else {
                citizen = new Citizen(input[2], input[0], Integer.parseInt(input[1]));
            }
            citizens.add(citizen);
        }

        String fake = reader.readLine();
        for (Identifiable citizen : citizens) {
            if (citizen.getId().endsWith(fake)) {
                System.out.println(citizen.getId());
            }
        }

    }
}
