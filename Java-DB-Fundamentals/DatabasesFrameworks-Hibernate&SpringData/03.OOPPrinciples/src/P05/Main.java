package P05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> citizens = new ArrayList<>();
        String info = reader.readLine();
        while(!"End".equals(info)) {
            String[] citizen = info.split("\\s");

            if (citizen.length > 2){
                String name = citizen[0];
                int age = Integer.parseInt(citizen[1]);
                String id = citizen[2];
                Identifiable identifiable = new HumanImpl(name, age, id);
                citizens.add(identifiable);
            }else{
                String model = citizen[0];
                String id = citizen[1];
                Identifiable  identifiable = new RobotImpl(model, id);
                citizens.add(identifiable);
            }

            info = reader.readLine();
        }
        String endNumbers = reader.readLine();
        citizens.stream().filter(a->a.getId().endsWith(endNumbers)).forEach(a-> System.out.println(a.getId()));
    }
}
