package _08May2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P01Royalism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        List<String> royalists = new ArrayList<>();
        List<String> nonRoyalists = new ArrayList<>();
        for (String name : input) {
            int sum = 0;
            for (int i = 0; i < name.length(); i++) {
                sum += (int) name.charAt(i);
                while (sum > 26) {
                    sum -= 26;
                }
            }
            if (sum == 18) {
                royalists.add(name);
            } else {
                nonRoyalists.add(name);
            }
        }

        if (royalists.size() >= nonRoyalists.size()){
            System.out.printf("Royalists - %d\n", royalists.size());
            for (String royalist : royalists) {
                System.out.println(royalist);
            }
            System.out.println("All hail Royal!");
        }else{
            for (String nonRoyalist : nonRoyalists) {
                System.out.println(nonRoyalist);
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
