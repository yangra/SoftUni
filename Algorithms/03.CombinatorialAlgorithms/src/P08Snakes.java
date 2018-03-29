import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P08Snakes {

    private static char[] currentSnake;
    private static Set<String> visited = new HashSet<>();
    private static List<String> result = new ArrayList<>();
    private static Set<String> allPossible = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        //long start = System.nanoTime();
        currentSnake = new char[n];
        generateSnake(0, 0, 0, 'S');

        System.out.println(result.toString().replace(", ", "\n").replaceAll("[]\\[]",""));
        System.out.printf("Snakes count = %d\n", result.size());
        //long timeDiff = System.nanoTime() - start;
        //System.out.println(timeDiff);
    }

    private static void generateSnake(int index, int row, int col, char direction) {
        if (index >= currentSnake.length) {
            String normalSnake = new String(currentSnake);
            if (!allPossible.contains(normalSnake)) {
                result.add(normalSnake);
                allPossible.add(normalSnake);

                char[] normal = normalSnake.toCharArray();

                char[] flipped = flipH(normal);
                char[] reversed = reverse(normal);
                char[] flippedReversed = flipH(reversed);

                for (int i = 0; i < 3; i++) {
                    rotate(normal);
                    rotate(flipped);
                    rotate(reversed);
                    rotate(flippedReversed);
                }
            }
        } else {
            String point = String.format("%d %d", row, col);

            if (!visited.contains(point)) {

                visited.add(point);
                currentSnake[index] = direction;
                if(direction=='S'){
                    generateSnake(index + 1, row, col + 1, 'R');
                    visited.remove(point);
                    return;
                }

                generateSnake(index + 1, row, col + 1, 'R');
                generateSnake(index + 1, row + 1, col, 'D');
                generateSnake(index + 1, row, col - 1, 'L');
                generateSnake(index + 1, row - 1, col, 'U');

                visited.remove(point);

            }
        }
    }

    private static char[] reverse(char[] snake) {
        char[] newSnake = new char[snake.length];
        newSnake[0] = 'S';
        for (int i = 1; i < snake.length; i++) {
            newSnake[snake.length - i] = snake[i];
        }

        allPossible.add(new String(newSnake));
        return newSnake;
    }

    private static void rotate(char[] snake) {
        for (int i = 0; i < snake.length; i++) {
            switch (snake[i]) {
                case 'U':
                    snake[i] = 'R';
                    break;
                case 'R':
                    snake[i] = 'D';
                    break;
                case 'D':
                    snake[i] = 'L';
                    break;
                case 'L':
                    snake[i] = 'U';
                    break;
                default:
                    break;
            }
        }

        allPossible.add(new String(snake));
    }

    private static char[] flipH(char[] snake) {
        char[] newSnake = new char[snake.length];
        for (int i = 0; i < snake.length; i++) {
            switch (snake[i]) {
                case 'R':
                    newSnake[i] = 'L';
                    break;
                case 'L':
                    newSnake[i] = 'R';
                    break;
                default:
                    newSnake[i] = snake[i];
                    break;
            }
        }

        allPossible.add(new String(newSnake));
        return newSnake;
    }
}
