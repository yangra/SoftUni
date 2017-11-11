package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11BitPaths {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] board = new int[8];

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] path = reader.readLine().split(",");
            int root = 3 - Integer.parseInt(path[0]);
            board[0] ^= (1 << root);
            for (int j = 1; j < path.length; j++) {
                switch (Integer.parseInt(path[j])) {
                    case 1:
                        root -= 1;
                        board[j] ^= 1 << root;
                        break;
                    case 0:
                        board[j] ^= 1 << root;
                        break;
                    case -1:
                        root += 1;
                        board[j] ^= 1 << root;
                        break;
                }
            }
        }

        int sum = 0;
        for (int row : board) {
            sum += row;
        }

        System.out.println(Integer.toBinaryString(sum));
        System.out.println(Integer.toHexString(sum).toUpperCase());
    }
}
