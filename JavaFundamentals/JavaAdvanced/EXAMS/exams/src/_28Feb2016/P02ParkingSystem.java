package _28Feb2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02ParkingSystem {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] parkingLot = new boolean[size[0]][size[1]];
        StringBuilder result = new StringBuilder();
        while (true) {
            String input = reader.readLine();
            if ("stop".equals(input)) {
                break;
            }

            int[] coords = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            int Z = coords[0];
            int X = coords[1];
            int Y = coords[2];

            int counter = Math.abs(Z-X);
            boolean found = false;
            int y = 0;


            if (!parkingLot[X][Y]) {
                counter += (Y + 1);
                parkingLot[X][Y] = true;
                found = true;
            } else {
                while (Y > 0) {
                    if (!parkingLot[X][Y]) {
                        y = Y;
                        found = true;
                        break;
                    }
                    Y--;
                }
                Y = coords[2];
                boolean isClosest = false;
                if (found) {
                    while (Y < parkingLot[0].length) {
                        if (!parkingLot[X][Y] && Y - coords[2] < coords[2] - y) {
                            counter += (Y + 1);
                            parkingLot[X][Y] = true;
                            isClosest = true;
                            break;
                        }
                        Y++;
                    }
                    if(!isClosest){
                        counter += (y + 1);
                        parkingLot[X][y] = true;
                    }
                }

                if (!found) {
                    while (Y < parkingLot[0].length) {
                        if (!parkingLot[X][Y]) {
                            counter += (Y + 1);
                            parkingLot[X][Y] = true;
                            found = true;
                            break;
                        }
                        Y++;
                    }
                }
            }
            if (!found) {
                result.append(String.format("Row %d full\n", X));
            } else {
                result.append(String.format("%d\n",counter));
            }
        }

        System.out.println(result.toString());
    }
}
