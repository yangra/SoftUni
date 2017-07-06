package P09;

import java.util.Arrays;
import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(a->Integer.parseInt(a)).toArray();
        int element = array[0];
        int currentFreq = 0;
        int maxFreq = 1;
        int maxElem = array[0];
        for (int i = 0; i < array.length; i++) {
            element = array[i];
            currentFreq = 1;
            for (int j = 0; j < array.length ; j++) {
                if (array[j] == element){
                    currentFreq++;
                }
                if (currentFreq > maxFreq){
                    maxFreq = currentFreq;
                    maxElem = element;
                }
            }
        }

        System.out.println(maxElem);
    }
}
