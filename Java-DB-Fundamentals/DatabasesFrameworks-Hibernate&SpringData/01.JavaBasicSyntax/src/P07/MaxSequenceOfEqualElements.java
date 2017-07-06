package P07;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(a->Integer.parseInt(a)).toArray();
        int element = arr[0];
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 0; i < arr.length-1 ; i++) {
            if(arr[i] == arr[i+1]){
                currentLength += 1;
                if (currentLength> maxLength){
                    maxLength = currentLength;
                    element = arr[i];
                }
            }else{
                currentLength = 1;
            }
        }

        for (int i = 0; i < maxLength ; i++) {
            System.out.print(element + " ");
        }
    }
}
