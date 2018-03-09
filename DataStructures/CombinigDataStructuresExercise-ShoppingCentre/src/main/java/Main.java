//import com.google.common.collect.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        Multiset<Product> multiset = TreeMultiset.create();
//        Multimap<String, Product> byName = MultimapBuilder.treeKeys().treeSetValues().build();
//        Multimap<Double, Product> byPrice = MultimapBuilder.treeKeys().treeSetValues().build();
//        Multimap<String, Product> byProducer = MultimapBuilder.treeKeys().treeSetValues().build();

        ShoppingCentre shoppingCentre = new ShoppingCentre();
        StringBuilder builder = new StringBuilder();
        int numberOfCommands = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String commandParams = reader.readLine();
            String command = commandParams.substring(0, commandParams.indexOf(" "));
            String paramsString = commandParams.substring(commandParams.indexOf(" ") + 1);
            String[] params = paramsString.split(";");

            switch (command) {
                case "AddProduct": {
                    String name = params[0];
                    double price = Double.parseDouble(params[1]);
                    String producer = params[2];
                    builder.append(shoppingCentre.addProduct(name, price, producer));
                    break;
                }
                case "DeleteProducts": {
                    if (params.length > 1) {
                        String name = params[0];
                        String producer = params[1];
                        builder.append(shoppingCentre.delete(name, producer));
                    } else {
                        String producer = params[0];
                        builder.append(shoppingCentre.delete(producer));
                    }
                    break;
                }
                case "FindProductsByName": {
                    String name = params[0];
                    builder.append(shoppingCentre.findProductsByName(name));
                    break;
                }
                case "FindProductsByProducer": {
                    String producer = params[0];
                    builder.append(shoppingCentre.findProductsByProducer(producer));
                    break;
                }
                case "FindProductsByPriceRange": {
                    double priceFrom = Double.parseDouble(params[0]);
                    double priceTo = Double.parseDouble(params[1]);
                    builder.append(shoppingCentre.findProductsByPriceRange(priceFrom, priceTo));
                    break;
                }
                default:
                    break;
            }
        }

        System.out.println(builder.toString());
    }
}
