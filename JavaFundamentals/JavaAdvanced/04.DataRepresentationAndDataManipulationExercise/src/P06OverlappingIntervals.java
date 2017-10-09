import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class P06OverlappingIntervals {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPairs = Integer.parseInt(reader.readLine());

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < numberOfPairs; i++) {
            int[] interval = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            intervals.add(interval);
        }

        intervals = selectionSort(intervals);

        System.out.println((isOverlapping(intervals)));

    }

    private static boolean isOverlapping(List<int[]> intervals) {
        for (int i = 1; i < intervals.size() ; i++) {
            if(intervals.get(i)[0]<=intervals.get(i-1)[1]){
                return true;
            }
        }
        return false;
    }

    private static List<int[]> selectionSort(List<int[]> unsorted ){
        List<int[]> sorted = new ArrayList<>();

        while(unsorted.size()>0){
            int index =  findTheLeast(unsorted);
            sorted.add(unsorted.get(index));
            unsorted.remove(index);
        }

        return sorted;
    }

    private static int findTheLeast(List<int[]> unsorted) {
        int index = 0;
        for (int i = 0; i < unsorted.size(); i++) {
            if(unsorted.get(index)[0]>unsorted.get(i)[0]){
                index = i;
            }
        }
        return index;
    }
}