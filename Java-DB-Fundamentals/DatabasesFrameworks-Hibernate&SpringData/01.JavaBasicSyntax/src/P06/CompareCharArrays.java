package P06;

import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arrayOne = scanner.nextLine().replaceAll("\\s","").toCharArray();
        char[] arrayTwo = scanner.nextLine().replaceAll("\\s", "").toCharArray();

        boolean result = compare (arrayOne, arrayTwo);

        if(result) {
            print(arrayOne);
            print(arrayTwo);
        }else {
            print(arrayTwo);
            print(arrayOne);
        }
    }

    private static boolean compare(char[] a, char[] b) {
       int minArrayLength = Math.min(a.length,b.length);

       for (int i = 0; i < minArrayLength ; i++) {
            if(a[i] < b[i]){
                return true;
            }else if(b[i]< a[i]){
                return false;
            }
        }

        return (a.length < b.length);
    }

    public static void print(char[] array) {
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
