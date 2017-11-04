package _04ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Product> products = new HashMap<>();
        Map<String, Person> customers = new LinkedHashMap<>();

        String[] people = reader.readLine().split(";");
        String[] items = reader.readLine().split(";");
        try {
            for (String human : people) {
                String[] tokens= human.split("=");
                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                customers.put(person.getName(), person);
            }

            for (String item : items) {
                String[] tokens = item.split("=");
                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                products.put(tokens[0], product);
            }

            while (true) {
                String[] command = reader.readLine().split("\\s+");
                if ("END".equalsIgnoreCase(command[0])) {
                    break;
                }

                Person customer = customers.get(command[0]);
                Product product = products.get(command[1]);
                if (customer.buyProduct(product)) {
                    System.out.printf("%s bought %s\n", customer.getName(), product.getName());
                } else {
                    System.out.printf("%s can't afford %s\n", customer.getName(), product.getName());
                }
            }

            for (Map.Entry<String, Person> entry : customers.entrySet()) {
                System.out.printf("%s - %s\n", entry.getKey(),
                        entry.getValue().getBag().size() > 0 ? entry.getValue().getBag().stream()
                                .map(Product::getName).collect(Collectors.joining(", ")) : "Nothing bought");
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
