package _22Auguust2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P01SecondNature {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> flowers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> buckets = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        List<Integer> everBlooms = new ArrayList<>();
        int indexFlowers = 0;
        int indexBuckets = buckets.size() - 1;
        while (flowers.size() > 0 && buckets.size() > 0) {
            Integer bucket = buckets.get(indexBuckets);
            Integer flower = flowers.get(indexFlowers);

            if (bucket > flower) {
                bucket -= flower;
                flowers.remove(indexFlowers);
                indexFlowers--;
                if (indexBuckets > 0) {
                    Integer newValue = buckets.get(indexBuckets - 1) + bucket;
                    buckets.set(indexBuckets - 1, newValue);
                    buckets.remove(indexBuckets);
                }else{
                    buckets.set(indexBuckets, bucket);
                    indexBuckets++;
                }
            } else if (bucket < flower) {
                flower -= bucket;
                flowers.set(indexFlowers, flower);
                buckets.remove(indexBuckets);
                indexFlowers--;
            } else {
                everBlooms.add(flower);
                buckets.remove(indexBuckets);
                flowers.remove(indexFlowers);
                indexFlowers--;
            }

            indexBuckets--;
            indexFlowers++;
        }

        if (flowers.size() > 0) {
            System.out.println(flowers.toString().replaceAll("[\\[\\],]", ""));
        }
        if (buckets.size() > 0) {
            for (int i = buckets.size() - 1; i >= 0; i--) {
                System.out.print(buckets.get(i) + " ");
            }
            System.out.println();
        }
        if (everBlooms.size() > 0) {
            System.out.println(everBlooms.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println("None");
        }
    }
}
