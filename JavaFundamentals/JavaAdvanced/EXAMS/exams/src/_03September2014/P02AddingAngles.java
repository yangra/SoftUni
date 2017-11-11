package _03September2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02AddingAngles {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((numbers[i] + numbers[j] + numbers[k] )% 360 == 0) {
                        found = true;
                        System.out.printf("%d + %d + %d = %d degrees\n",
                                numbers[i], numbers[j], numbers[k], numbers[i] + numbers[j] + numbers[k]);
                    }
                }
            }
        }

        if(!found){
            System.out.println("No");
        }
    }
}
