package _22Auguust2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02NaturesProphet {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        int[][] garden = new int [Integer.valueOf(dimensions[0])][Integer.valueOf(dimensions[1])];

        while(true){
            String[] coordinates = reader.readLine().split(" ");
            if("bloom".equalsIgnoreCase(coordinates[0])){
                break;
            }

            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);

            for (int row = 0; row < garden[0].length; row++) {
                garden[row][y]++;
            }

            for (int col = 0; col < garden.length; col++) {
                if(col != y) {
                    garden[x][col]++;
                }
            }
        }

        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[0].length; col++) {
                System.out.print(garden[row][col]+ " ");
            }
            System.out.println();
        }
    }
}
