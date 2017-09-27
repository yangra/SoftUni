import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }

            input.add(line);
        }

        char[][] field = new char[input.size()][];
        boolean[][] delete = new boolean[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            field[i] = input.get(i).toCharArray();
            delete[i] = new boolean[field[i].length];
        }

        for (int row = 1; row < field.length; row++) {
            for (int col = 1; col < field[row].length; col++) {
                if (row + 1 < field.length && col + 1 < field[row].length &&
                        col < field[row - 1].length && col < field[row + 1].length &&
                        Character.toLowerCase(field[row][col]) == Character.toLowerCase(field[row - 1][col]) &&
                        Character.toLowerCase(field[row][col]) == Character.toLowerCase(field[row][col - 1]) &&
                        Character.toLowerCase(field[row][col]) == Character.toLowerCase(field[row + 1][col]) &&
                        Character.toLowerCase(field[row][col]) == Character.toLowerCase(field[row][col + 1])) {

                    delete[row][col] = true;
                    delete[row - 1][col] = true;
                    delete[row][col - 1] = true;
                    delete[row + 1][col] = true;
                    delete[row][col + 1] = true;
                }
            }
        }

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (delete[row][col]) {
                    field[row][col] = ' ';
                }
            }
        }

        for (int row = 0; row < field.length; row++) {
            String line = String.valueOf(field[row]);
            String result = line.replace(" ", "");
            System.out.println(result);
        }
    }

}
