package _19Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02Earthquake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<List<Integer>> queue = new ArrayDeque<>();
        int numberOfWaves = Integer.parseInt(reader.readLine());

        List<Integer> seismicities = new ArrayList<>();
        for (int i = 0; i < numberOfWaves; i++) {

            List<Integer> wave = new ArrayList<>();
            int[] input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int integer : input) {
                wave.add(integer);
            }

            rollSeismicity(queue, seismicities, wave);
        }


        while (queue.size() > 0) {
            List<Integer> wave = queue.poll();
            rollSeismicity(queue, seismicities, wave);
        }

        System.out.println(seismicities.size());
        System.out.println(seismicities.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void rollSeismicity(Deque<List<Integer>> queue, List<Integer> seismicities, List<Integer> wave) {
        if (wave.size() == 1) {
            seismicities.add(wave.get(0));
            return;
        }

        int seismicity = wave.get(0);
        seismicities.add(seismicity);
        for (int i = 1; i < wave.size(); i++) {
            if (seismicity >= wave.get(i)) {
                wave.remove(i);
                i--;
            } else {
                wave.remove(0);
                queue.offer(wave);
                break;
            }
        }
    }
}
