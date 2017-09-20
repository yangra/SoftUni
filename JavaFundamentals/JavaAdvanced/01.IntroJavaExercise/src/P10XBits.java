import java.util.Scanner;

public class P10XBits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] bits = new int[8];

        for (int i = 0; i < 8; i++) {
            int binary = Integer.parseInt(scanner.nextLine());
            bits[i] = binary;
        }

        int counter = 0;
        for (int i = 0; i < bits.length - 2; i++) {
            for (int j = 0; j < 32 - 2; j++) {
                if (check(j, bits[i], 5) == 0) {
                    if (check(j, bits[i + 1], 2) == 0) {
                        if (check(j, bits[i + 2], 5) == 0) {
                            counter++;
                        }
                    }
                }
            }
        }

        System.out.println(counter);
    }

    private static int check(int position, int number, int checkNum) {
        int mask = 7 << position;
        int chopped = number & mask;
        int check = checkNum << position;
        return chopped ^ check;
    }
}
