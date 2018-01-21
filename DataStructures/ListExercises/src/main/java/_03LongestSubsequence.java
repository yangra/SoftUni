import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _03LongestSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        int maxLength = 1;
        int currlength = 1;
        int repeatedNum = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i).equals(nums.get(i + 1))) {
                currlength++;
            } else {
                currlength = 1;
            }
            if (currlength > maxLength) {
                maxLength = currlength;
                repeatedNum = nums.get(i);
            }
        }

        if (nums.size() == 1||maxLength==1) {
            repeatedNum = nums.get(0);
        }

        for (int i = 0; i < maxLength; i++) {
            System.out.print(repeatedNum + " ");
        }


    }
}
