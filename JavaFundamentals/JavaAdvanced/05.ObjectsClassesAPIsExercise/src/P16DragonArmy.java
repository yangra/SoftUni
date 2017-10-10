import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16DragonArmy {
    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfDragons = Integer.parseInt(reader.readLine());
        Map<String,TreeMap<String,Integer[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < numberOfDragons; i++) {
            String[] input = reader.readLine().split(" ");
            String type = input[0];
            String name = input[1];
            Integer[] stats = new Integer[3];
            stats[0] = input[2].equals("null")? DEFAULT_DAMAGE: Integer.parseInt(input[2]);
            stats[1] = input[3].equals("null")? DEFAULT_HEALTH: Integer.parseInt(input[3]);
            stats[2] = input[4].equals("null")? DEFAULT_ARMOR: Integer.parseInt(input[4]);
            if(!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<>());
            }

            dragons.get(type).put(name,stats);
        }

        for (Map.Entry<String, TreeMap<String, Integer[]>> typeEntry : dragons.entrySet()) {
            Double averageDamage = 0.0;
            Double averageHealth = 0.0;
            Double averageArmor = 0.0;

            for(Integer[] stats :typeEntry.getValue().values()){
                averageDamage += stats[0];
                averageHealth += stats[1];
                averageArmor += stats[2];
            }

            averageDamage /= typeEntry.getValue().values().size();
            averageHealth /= typeEntry.getValue().values().size();
            averageArmor /= typeEntry.getValue().values().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", typeEntry.getKey(), averageDamage, averageHealth, averageArmor);
            for (Map.Entry<String,Integer[]> dragonEntry : dragons.get(typeEntry.getKey()).entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragonEntry.getKey(),
                        dragonEntry.getValue()[0],dragonEntry.getValue()[1],dragonEntry.getValue()[2]);
            }
        }
    }
}
