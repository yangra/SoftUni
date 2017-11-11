package _28Feb2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01CollectResources {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] resources = reader.readLine().split(" ");
        boolean[] visited = new boolean[resources.length];

        int paths = Integer.parseInt(reader.readLine());

        long maxSum = 0;
        for (int i = 0; i < paths; i++) {
            int[] path = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = path[0];
            int step = path[1];
            long sum = 0;
            while(!visited[start]){
                sum += collect(resources[start]);
                visited[start] = true;
                start += step;
                while(start >= resources.length){
                    start -= resources.length;
                }
            }

            for (int j = 0; j < visited.length; j++) {
                visited[j] = false;
            }

            if(sum>maxSum){
                maxSum = sum;
            }
        }

        System.out.println(maxSum);

    }

    private static int collect(String resource) {
        String[] params = resource.split("_");
        int value = 0;
        switch (params[0]){
            case "stone":
                if(params.length>1){
                    value = Integer.parseInt(params[1]);
                }else{
                    value = 1;
                }
                break;
            case "gold":
                if(params.length>1){
                    value = Integer.parseInt(params[1]);
                }else{
                    value = 1;
                }
                break;
            case "wood":
                if(params.length>1){
                    value = Integer.parseInt(params[1]);
                }else{
                    value = 1;
                }
                break;
            case "food":
                if(params.length>1){
                    value = Integer.parseInt(params[1]);
                }else{
                    value = 1;
                }
                break;
                default:
                    break;
        }
        return value;
    }
}
