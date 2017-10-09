//import java.util.Scanner;
//
//public class P04CombinationsCount {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        int k = Integer.parseInt(scanner.nextLine());
//
//        int[] buf = new int[k];
//        int result = calculateCombinations(n, k, 0, 0, 1, buf);
//        System.out.println(result);
//    }
//
//    private static int calculateCombinations(int n, int k, int counter, int indexK, int indexN, int[] buf) {
//
//        if (n == k) {
//            return 1;
//        }
//
//        if (indexK == k) {
//            for (int i = 0; i < buf.length; i++) {
//                System.out.print(buf[i] + " ");
//            }
//            System.out.println();
//            counter++;
//
//        }
//
//
//        for (int i = indexK; i < k; i++) {
//            for (int j = indexN; j <= n; j++) {
//                if (indexN>i) {
//                    buf[indexK] = j;
//                    counter = calculateCombinations(n, k, counter, i + 1, j + 1, buf);
//                }
//            }
//        }
//
//        return counter;
//    }
//}

import java.util.Scanner;

public class P04CombinationsCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        int result = calculateCombinations(n, k, 0, 0,0);
        System.out.println(result);
    }

    private static int calculateCombinations(int n, int k, int counter, int index, int border) {

        if (n == k) {
            return 1;
        }

        if (index >= k) {
            counter++;
            return counter;
        }


        for (int i = border; i < n; i++) {
            counter = calculateCombinations(n, k, counter, index + 1, i+1);
        }

        return counter;
    }
}
