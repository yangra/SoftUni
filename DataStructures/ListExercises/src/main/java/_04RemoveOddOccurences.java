import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _04RemoveOddOccurences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        List<Integer> indicesRemove = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if (indicesRemove.contains(i)) {
                continue;
            }

            int num = nums.get(i);
            int count = 0;
            List<Integer> indices = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j) == num) {
                    count++;
                    indices.add(j);
                }
            }

            if (count % 2 != 0){
               indicesRemove.addAll(indices);
            }
        }

        Collections.sort(indicesRemove);

        Iterator<Integer> iterator = nums.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            iterator.next();
            if(indicesRemove.contains(counter)){
                iterator.remove();
            }
            counter++;
        }

        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
