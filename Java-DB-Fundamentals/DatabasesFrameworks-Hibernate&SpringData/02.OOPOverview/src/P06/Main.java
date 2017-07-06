package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        String[] buyers = reader.readLine().split(";");
        for (String buyer : buyers) {
            String[] data = buyer.split("=");
            String name = data[0];
            double money = Double.parseDouble(data[1]);
            try {
                Person person = new Person(name, money);
                people.add(person);
            } catch (IllegalStateException ise) {
                return;
            }
        }
        String[] stuff = reader.readLine().split(";");
        for (String thing : stuff) {
            String[] info = thing.split("=");
            String name = info[0];
            double cost = Double.parseDouble(info[1]);
            try {
                Product product = new Product(name, cost);
                products.add(product);
            } catch (IllegalStateException ise) {
                return;
            }
        }
        String line = reader.readLine();
        while (!"END".equals(line)) {
            try {
                String[] purchase = line.split("\\s");
                String personName = purchase[0];
                String productName = purchase[1];
                Person person = people.stream().filter(a -> personName.equals(a.getName())).findAny().orElse(null);
                Product product = products.stream().filter(a -> productName.equals(a.getName())).findAny().orElse(null);
                person.addToBag(product);
                line = reader.readLine();
            } catch (Exception e) {
                break;
            }
        }

        for (Person person : people) {
            String bagOfProducts = person.getBag()
                    .stream().map(Product::getName)
                    .collect(Collectors.joining(", "));
            System.out.printf("%s - %s\n", person.getName(), bagOfProducts.isEmpty() ? "Nothing bought" : bagOfProducts);
        }

    }
}
