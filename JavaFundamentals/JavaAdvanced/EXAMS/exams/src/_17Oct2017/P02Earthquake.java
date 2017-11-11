package _17Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<List<Integer>> queue = new ArrayDeque<>();
        int numberOfActivities = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfActivities; i++) {
            List<Integer> activity = new ArrayList<>();
            String[] input = reader.readLine().split(" ");
            for (String param : input) {
                activity.add(Integer.parseInt(param));
            }
            queue.offer(activity);
        }

        List<Integer> result = new ArrayList<>();

        while (queue.size() > 0) {
            List<Integer> activity = queue.poll();
            int seismicity = activity.get(0);
            for (int i = 0; i < activity.size(); i++) {
                if(seismicity<activity.get(i)){
                    queue.offer(activity.subList(i,activity.size()));
                    break;
                }
            }

            result.add(seismicity);
        }

        System.out.println(result.size());
        System.out.println(result.toString().replaceAll("[\\[\\],]",""));
    }
}