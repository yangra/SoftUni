package P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        while (!"End".equals(data)) {
            try {
                int[] beers = Arrays.stream(data.split("\\s")).mapToInt(a -> Integer.parseInt(a)).toArray();
                BeerCounter.buyBeer(beers[0]);
                BeerCounter.drinkBeer(beers[1]);
                data = reader.readLine();
            } catch (Exception e) {
                break;
            }

        }
        System.out.printf("%d %d\n", BeerCounter.beerInStock, BeerCounter.beersDrankCount);
    }
}
