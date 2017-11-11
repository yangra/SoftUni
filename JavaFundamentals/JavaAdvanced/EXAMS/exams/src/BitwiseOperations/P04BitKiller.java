package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04BitKiller {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int step = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(reader.readLine());
            String row = Integer.toBinaryString(line);
            while (row.length() < 8) {
                row = "0" + row;
            }
            builder.append(row);
        }

        for (int i = 1; i < builder.length(); i += step) {
            builder.replace(i, i + 1, " ");
        }

        String result = builder.toString().replaceAll(" ", "");
        while ((result.length() % 8) != 0) {
            result = result + "0";
        }
        int var = result.length()/8;
        for (int i = 0; i < var; i++) {
            if (i != n - 1) {
                System.out.println(Integer.parseInt(result.substring(0, 8), 2));
                result = result.substring(8);
            } else {
                System.out.println(Integer.parseInt(result, 2));
            }
        }


    }
}
