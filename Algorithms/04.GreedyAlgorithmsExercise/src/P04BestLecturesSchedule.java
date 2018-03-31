import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P04BestLecturesSchedule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfLectures = Integer.parseInt(reader.readLine().substring(10));
        Map<String, int[]> lectures = new HashMap<>();

        for (int i = 0; i < numberOfLectures; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0].substring(0,input[0].length()-1);
            int start = Integer.parseInt(input[1]);
            int finish = Integer.parseInt(input[3]);
            int[] times = new int[]{start, finish};
            lectures.putIfAbsent(name,times);
        }

        List<Map.Entry<String,int[]>> sorted = lectures.entrySet().stream()
                .sorted((a,b)->Integer.compare(a.getValue()[1], b.getValue()[1]))
                .collect(Collectors.toList());

        List<Map.Entry<String,int[]>> result = new ArrayList<>();
        int finish = -1;
        while(sorted.size()>0){
            Map.Entry<String,int[]> taken = sorted.get(0);
            result.add(taken);
            finish = taken.getValue()[1];
            while(sorted.size()>0&&sorted.get(0).getValue()[0] < finish){
                sorted.remove(0);
            }
        }

        System.out.printf("Lectures (%d):\n", result.size());
        for (Map.Entry<String, int[]> entry : result) {
            System.out.printf("%d-%d -> %s\n", entry.getValue()[0], entry.getValue()[1], entry.getKey());
        }
    }
}
