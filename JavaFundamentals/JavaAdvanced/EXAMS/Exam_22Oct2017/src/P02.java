import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P02 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stoneQueue = new ArrayDeque<>();
        Deque<Integer> goldStack = new ArrayDeque<>();
        int[] stones = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < stones.length; i++) {
            stoneQueue.offer(stones[i]);
        }

        while (true) {
            String[] command = reader.readLine().split(" ");
            if ("Revision".equals(command[0])) {
                break;
            }

            switch (command[0]) {
                case "Apply":
                    int quantity = Integer.parseInt(command[2]);
                    int counter = 0;
                    while (stoneQueue.size() > 0 && counter < quantity) {
                        int stone = stoneQueue.poll();
                        stone--;
                        if (stone == 0) {
                            goldStack.push(stone);
                        } else {
                            stoneQueue.offer(stone);
                        }
                        counter++;
                    }

                    break;
                case "Air":
                    int leak = Integer.parseInt(command[2]);
                    if (goldStack.size() > 0) {
                        int stone = goldStack.pop();
                        stone += leak;
                        stoneQueue.offer(stone);
                    }
                    break;
            }
        }

        System.out.println(stoneQueue.toString().

                replaceAll("[\\[\\],]", ""));
        System.out.println(goldStack.size());
    }

}