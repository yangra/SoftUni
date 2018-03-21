import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class P04TowerOfHanoi {

    private static int stepCounter = 1;
    private static Deque<Integer> source = new ArrayDeque<>();
    private static Deque<Integer> destination = new ArrayDeque<>();
    private static Deque<Integer> spare = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        for (int i = num; i > 0; i--) {
            source.push(i);
        }

        String initialSource = reverseContents(source);

        System.out.printf("Source: %s\n" +
                "Destination: \n" +
                "Spare: \n", initialSource);

        moveDiscs(num, source, destination, spare);

    }

    private static void moveDiscs(int num, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (num > 0) {

            moveDiscs(num - 1, source, spare, destination);

            destination.push(source.pop());

            printStep();

            moveDiscs(num - 1, spare, destination, source);

        }
    }


    private static void printStep() {
        String sourceResult = reverseContents(source);
        String destinationResult = reverseContents(destination);
        String spareResult = reverseContents(spare);
        System.out.printf("\nStep #%d: Moved disk\nSource: %s\nDestination: %s\nSpare: %s\n",
                stepCounter++, sourceResult, destinationResult, spareResult);
    }

    private static String reverseContents(Deque<Integer> source) {
        String result = "";
        Iterator iterator = source.descendingIterator();
        while (iterator.hasNext()) {
            result += iterator.next() + ", ";
        }
        if (result.length() > 0) {
            result = result.trim().substring(0, result.length() - 2);
        }
        return result;
    }
}


