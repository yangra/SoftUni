import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P01Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        bubbleSort(array);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]).append(" ");
        }

        System.out.println(result.toString());

    }

    private static void bubbleSort(int[] a){
        boolean swapped = true;
        do{
            swapped = false;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i]>a[i+1]){
                    swap(a,i,i+1);
                    swapped = true;
                }
            }
        }while(swapped);
    }

    private  static void selectionSort(int[] a){

        for (int i = 0; i < a.length-1; i++) {
            int min = i;
            for (int j = min; j < a.length; j++) {
                if(a[min]>a[j]){
                    min = j;
                }
            }
            swap(a,min,i);
        }
    }

    private  static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
