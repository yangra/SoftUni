package _04Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = reader.readLine().split("[,\\s]+");
        Integer[] waterLilies = Arrays.stream(params).map(Integer::valueOf).toArray(Integer[]::new);
        Lake<Integer> lake = new Lake(waterLilies);
        String end = reader.readLine();


//        StringBuilder sb = new StringBuilder();
//        lake.forEach(l -> sb.append(l).append(", "));
//        System.out.println(sb.toString().trim().substring(0, sb.lastIndexOf(",")));

        List<String> result = new ArrayList<>();
        for (Integer integer : lake) {
            result.add(String.valueOf(integer));
        }
        System.out.println(String.join(", ", result));
    }
}
