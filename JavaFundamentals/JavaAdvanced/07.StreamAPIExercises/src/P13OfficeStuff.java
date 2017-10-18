import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P13OfficeStuff {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> products = new TreeMap<>();

        int numberOfLines = Integer.valueOf(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            String[] line = Arrays.stream(reader.readLine().split("[ |-]"))
                    .filter(s->s.length()>0).toArray(String[]::new);

            String company = line[0];
            Integer amount = Integer.parseInt(line[1]);
            String product = line[2];

            products.putIfAbsent(company, new LinkedHashMap<>());
            if(products.get(company).containsKey(product)){
                products.get(company).put(product, products.get(company).get(product) + amount);
            }else{
                products.get(company).put(product,amount);
            }

        }

        products.entrySet().stream()
                .forEach(me-> System.out.printf("%s: %s\n",me.getKey(),
                        me.getValue().entrySet().stream()
                                .map(kv-> String.format("%s-%s", kv.getKey(), kv.getValue()))
                                .collect(Collectors.joining(", "))));
    }
}
