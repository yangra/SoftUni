package _10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\s+");
        Tuple<String,String> tuple1 = new TupleImpl<>(firstLine[0]+" "+firstLine[1], firstLine[2]);
        String[] secLine = reader.readLine().split("\\s+");
        Tuple<String, Integer> tuple2 = new TupleImpl<>(secLine[0], Integer.parseInt(secLine[1]));
        String[] thirdLine = reader.readLine().split("\\s+");
        Tuple< Integer, Double> tuple3 = new TupleImpl<>(Integer.parseInt(thirdLine[0]), Double.parseDouble(thirdLine[1]));

        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}
