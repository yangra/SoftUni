package _07FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfLines = Integer.parseInt(reader.readLine());
        Map<String, Buyer> buyers = new HashMap<>();
        for (int i = 0; i < numberOfLines; i++) {
            String[] input = reader.readLine().split("\\s+");
            Buyer buyer = null;
            switch (input.length) {
                case 4:
                    buyer = new Citizen(input[2], input[0], Integer.parseInt(input[1]), input[3]);
                    break;
                case 3:
                    buyer = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                    break;

            }

            buyers.put(input[0], buyer);
        }

        while (true) {
            String name = reader.readLine();
            if ("end".equalsIgnoreCase(name)) {
                break;
            }
            if(buyers.containsKey(name)){
                buyers.get(name).buyFood();
            }
        }

        int totalFood = 0;
        for (Buyer buyer : buyers.values()) {
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);

    }
}
