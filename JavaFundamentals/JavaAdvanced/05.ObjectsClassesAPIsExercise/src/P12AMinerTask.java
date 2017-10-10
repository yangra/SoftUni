import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P12AMinerTask {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> resources = new HashMap<>();

        while (true) {
            String resource = reader.readLine();
            if ("stop".equalsIgnoreCase(resource)) {
                break;
            }
            Integer quantity = Integer.parseInt(reader.readLine());


            if (resources.containsKey(resource)) {
                Integer previousQuantity = resources.get(resource);
                resources.put(resource, previousQuantity + quantity);
            }else{
                resources.put(resource,quantity);
            }
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d\n",entry.getKey(), entry.getValue());
        }
    }
}
