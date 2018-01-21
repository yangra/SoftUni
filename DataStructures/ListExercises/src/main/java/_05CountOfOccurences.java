import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class _05CountOfOccurences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(s->Integer.parseInt(s))
                .toArray();
        Map<Integer, Integer> numCount = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(numCount.containsKey(nums[i])){
                continue;
            }
            int number = nums[i];
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] == number){
                    count++;
                }
            }

            numCount.put(number,count);
        }

        numCount = numCount.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(a, b)->a, LinkedHashMap::new));
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue()+" times");
        }
    }
}
