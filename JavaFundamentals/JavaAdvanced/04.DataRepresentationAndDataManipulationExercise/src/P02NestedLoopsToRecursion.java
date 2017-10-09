
import java.util.Scanner;

public class P02NestedLoopsToRecursion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] buf = new int[n];

        simulateLoops(buf, 0, 1);
    }

    private static void simulateLoops(int[] buf, int index, int start) {
        if (index == buf.length) {
            for (int elem : buf) {
                System.out.print(elem + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < buf.length; i++) {
            buf[index] = start + i;
            simulateLoops(buf, index + 1, start);
        }
    }
}
