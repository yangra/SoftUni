import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class P01SortEvenNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        String[] input = reader.readLine().split("\\s*,\\s+");
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        numbers.removeIf(x->x%2!=0);

        printResult(numbers);

        numbers.sort((a,b)->a.compareTo(b));

        printResult(numbers);

    }

    private static void printResult(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if(i!=numbers.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
