package _13June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] galaxy = new int[rows][cols];

        int iterator = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = iterator;
                iterator++;
            }
        }

        long collectedStars = 0;
        while (true) {
            String[] ivo = reader.readLine().split("\\s+");
            if ("Let".equalsIgnoreCase(ivo[0])) {
                break;
            }

            int x = Integer.parseInt(ivo[0]);
            int y = Integer.parseInt(ivo[1]);

            String[] evil = reader.readLine().split("\\s+");

            int evilX = Integer.parseInt(evil[0]);
            int evilY = Integer.parseInt(evil[1]);

            while (evilX >= rows || evilY >= cols) {
                evilX--;
                evilY--;
            }
            while (evilX >= 0 && evilY >= 0) {
                galaxy[evilX][evilY] = 0;
                evilX--;
                evilY--;
            }

            while (y < 0 || x >= rows) {
                x--;
                y++;
            }
            while (x >= 0 && y < cols) {
                collectedStars += galaxy[x][y];
                x--;
                y++;
            }
        }

        System.out.println(collectedStars);
    }
}