import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class P03KnightsTour {
    private static List<int[]> moves = new ArrayList<>();
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        result = new int[size][size];
        moves.add(new int[]{1, 2});
        moves.add(new int[]{-1, 2});
        moves.add(new int[]{1, -2});
        moves.add(new int[]{-1, -2});
        moves.add(new int[]{2, -1});
        moves.add(new int[]{2, 1});
        moves.add(new int[]{-2, 1});
        moves.add(new int[]{-2, -1});

        int step = 1;
        result[0][0] = step++;
        int x = 0;
        int y = 0;
        int[] coords = findNextMove(x, y);
        result[coords[0]][coords[1]] = step++;
        while (step <= size * size) {
            coords = findNextMove(coords[0], coords[1]);
            result[coords[0]][coords[1]] = step++;
        }

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result.length; col++) {
                System.out.print(String.format("%4d",result[row][col] ));
            }
            System.out.println();
        }
    }

    private static int[] findNextMove(int x, int y) {
        List<int[]> possibleMoves = findPossibleMoves(x, y);
        if(possibleMoves.size() == 0){
            throw new IllegalArgumentException();
        }
        if (possibleMoves.size() == 1) {
            return possibleMoves.get(0);
        }


        int[] onwardMoves = getOnwardMoves(possibleMoves);
        int index = getLeastIndex(onwardMoves);
        return possibleMoves.get(index);
    }

    private static int getLeastIndex(int[] numbers) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                index = i;
            }
        }

        return index;
    }

    private static int[] getOnwardMoves(List<int[]> possibleMoves) {
        int[] onwardMoves = new int[possibleMoves.size()];
        for (int i = 0; i < possibleMoves.size(); i++) {
            onwardMoves[i] = findPossibleMoves(possibleMoves.get(i)[0], possibleMoves.get(i)[1]).size();
        }
        return onwardMoves;
    }

    private static List<int[]> findPossibleMoves(int x, int y) {
        List<int[]> possibleMoves = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++) {
            int newX = x + moves.get(i)[0];
            int newY = y + moves.get(i)[1];
            if (isInBounds(newX, newY) && result[newX][newY] == 0) {
                possibleMoves.add(new int[]{newX, newY});
            }
        }

        return possibleMoves;

    }

    private static boolean isInBounds(int x, int y) {
        if (x < 0 || x >= result.length || y < 0 || y >= result.length) {
            return false;
        }
        return true;
    }
}
