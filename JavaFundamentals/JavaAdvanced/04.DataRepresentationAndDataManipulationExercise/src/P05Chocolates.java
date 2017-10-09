import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P05Chocolates {

    private static List<int[]> combinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] packs = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int students = Integer.parseInt(scanner.nextLine());
        int[] combination = new int[students];
        extractCombinations(packs, combination, 0, 0);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <combinations.size(); i++) {
                int minCount = min(combinations.get(i), 0);
                int maxCount = max(combinations.get(i), 0);
                int diff = maxCount - minCount;
                if (diff < minDiff) {
                    minDiff = diff;
                }
        }

        System.out.printf("Min Difference is %d.", minDiff);
    }

    private static void extractCombinations(int[] nums, int[] combination, int index, int border) {
        if (index >= combination.length) {
            int[] comb = Arrays.copyOf(combination, combination.length);
            combinations.add(comb);
            return;
        }
        for (int i = border; i < nums.length; i++) {
            combination[index] = nums[i];
            extractCombinations(nums, combination, index + 1, i + 1);
        }
    }

    private static int max(int[] array, int index) {
        if (index >= array.length) {
            return Math.max(array[index - 1], array[index - 2]);
        }
        return Math.max(array[index], max(array, index + 1));
    }

    private static int min(int[] array, int index) {
        if (index == array.length) {
            return Math.min(array[index - 1], array[index - 2]);
        }
        return Math.min(array[index], min(array, index + 1));
    }
}
