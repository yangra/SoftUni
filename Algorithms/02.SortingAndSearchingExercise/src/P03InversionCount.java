import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P03InversionCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = Arrays.stream(reader.readLine().split(" ")).reduce((a,b)->a+b).get();

        int[] result = new int[1];
        mergeSort(input, result );
        System.out.println(result[0]);
    }

    private static String mergeSort(String input, int[] result) {
        if (input.length() == 1) {
            return input;
        }

        int middle = input.length() / 2;
        String a = input.substring(0, middle);
        String b = input.substring(middle);

        a = mergeSort(a, result);
        b = mergeSort(b, result);

        return merge(a, b, result);
    }

    private static String merge(String a, String b, int[] result) {
        StringBuilder merge = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            for (int j = 0; j < b.length(); j++) {
                if (a.length() == 0) {
                    break;
                }
                if (Integer.parseInt(a.charAt(i) + "") > Integer.parseInt(b.charAt(j) + "")) {
                    merge.append(b.charAt(j));
                    for (int k = 0; k < a.length(); k++) {
                        result[0]++;
                    }

                    b = b.substring(0, j) + b.substring(j + 1);
                    j--;
                } else {
                    merge.append(a.charAt(i));
                    a = a.substring(0, i) + a.substring(i + 1);
                    count++;
                    j = -1;
                }
            }
            i -= count;
        }
        if (a.length() > 0) {
            merge.append(a);
        }
        if (b.length() > 0) {
            merge.append(b);
        }

        return merge.toString();
    }
}
