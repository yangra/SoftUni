package _19June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P02CubicsRube {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int side = Integer.parseInt(reader.readLine());
        int changedCells = 0;
        long sumChanges = 0;
        List<String> hitCells = new ArrayList<>();
        while (true) {
            String[] particle = reader.readLine().split("\\s+");
            if ("Analyze".equalsIgnoreCase(particle[0])) {
                break;
            }

            int x = Integer.parseInt(particle[0]);
            int y = Integer.parseInt(particle[1]);
            int z = Integer.parseInt(particle[2]);


            if (x >= 0 && x < side && y >= 0 && y < side && z >= 0 && z < side) {

                String coordinates = particle[0] + " " + particle[1] + " " + particle[2];
                if (hitCells.contains(coordinates)) {
                    continue;
                }

                hitCells.add(coordinates);

                int change = Integer.parseInt(particle[3]);
                if (change != 0) {
                    changedCells++;
                }
                sumChanges += change;
            }
        }

        int numberOfUnchangedCells = (side * side * side) - changedCells;
        System.out.println(sumChanges);
        System.out.println(numberOfUnchangedCells);
    }
}
