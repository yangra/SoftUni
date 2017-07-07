package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Birthable> alive = new ArrayList<>();
        String info = reader.readLine();
        while (!"End".equals(info)) {
            String[] being = info.split("\\s");
            switch (being[0]) {
                case "Citizen": {
                    String name = being[1];
                    int age = Integer.parseInt(being[2]);
                    String id = being[3];
                    String birthDate = being[4];
                    Birthable birthable = new HumanImpl(name, age, id, birthDate);
                    alive.add(birthable);
                    break;
                }
                case "Pet": {
                    String name = being[1];
                    String birthDate = being[2];
                    Birthable birthable = new PetImpl(name, birthDate);
                    alive.add(birthable);
                    break;
                }
                case "RobotImpl":
                    break;
            }
            info = reader.readLine();
        }
        String year = reader.readLine();
        alive.stream().filter(a -> a.getBirthDate().endsWith(year)).forEach(a -> System.out.println(a.getBirthDate()));
    }
}
