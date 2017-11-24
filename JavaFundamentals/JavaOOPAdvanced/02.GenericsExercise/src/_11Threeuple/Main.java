package _11Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\s+");
        Threeuple<String, String, String> threeuple1 = new ThreeupleImpl<>
                (firstLine[0] + " " + firstLine[1], firstLine[2], firstLine[3]);
        String[] secLine = reader.readLine().split("\\s+");
        Threeuple<String, Integer, Boolean> threeuple2 = new ThreeupleImpl<>(secLine[0], Integer.parseInt(secLine[1]), secLine[2].equals("drunk") );
        String[] thirdLine = reader.readLine().split("\\s+");
        Threeuple<String, Double, String> threeuple3 = new ThreeupleImpl<>(thirdLine[0], Double.parseDouble(thirdLine[1]), thirdLine[2]);

        System.out.println(threeuple1);
        System.out.println(threeuple2);
        System.out.println(threeuple3);
    }
}
