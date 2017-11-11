package _19Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01ShockWave {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] room = new int[rows][cols];

        while (true){
            String[] wave = reader.readLine().split(" ");
            if("Here".equalsIgnoreCase(wave[0])){
                break;
            }

            int X1 = Integer.parseInt(wave[0]);
            int Y1 = Integer.parseInt(wave[1]);
            int X2 = Integer.parseInt(wave[2]);
            int Y2 = Integer.parseInt(wave[3]);

            for (int i = X1; i <=X2 ; i++) {
                for (int j = Y1; j <=Y2 ; j++) {
                    room[i][j]++;
                }
            }
        }

        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[0].length; col++) {
                System.out.printf("%d ",room[row][col]);
            }
            System.out.println();
        }

    }
}
