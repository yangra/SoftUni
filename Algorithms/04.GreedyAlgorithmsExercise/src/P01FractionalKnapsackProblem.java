import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P01FractionalKnapsackProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine().substring(10));
        int numberOfItems = Integer.parseInt(reader.readLine().substring(7));
        List<double[]> items = new ArrayList<>();

        for (int i = 0; i < numberOfItems; i++) {
            String[] input = reader.readLine().split(" ");
            double price = Double.parseDouble(input[0]);
            double weight = Double.parseDouble(input[2]);
            double[] item = new double[]{price, weight};
            items.add(item);
        }

        items.sort((a, b) -> {
            double coefA = a[0] / a[1];
            double coefB = b[0] / b[1];
            return Double.compare(coefB, coefA);
        });

        double totalPrice = 0;
        while (capacity > 0 && items.size() > 0) {
            double[] itemTaken = items.get(0);
            if (capacity - itemTaken[1] >= 0) {
                System.out.printf("Take 100%% of item with price %.2f and weight %.2f\n", itemTaken[0], itemTaken[1]);
                totalPrice += itemTaken[0];
                capacity -= itemTaken[1];
            } else {
                double partial = capacity / itemTaken[1];
                System.out.printf("Take %.2f%% of item with price %.2f and weight %.2f\n", partial * 100, itemTaken[0], itemTaken[1]);
                totalPrice += partial * itemTaken[0];
                capacity = 0;
            }

            items.remove(0);
        }

        System.out.printf("Total price: %.2f\n", totalPrice);
    }
}
