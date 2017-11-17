package _10MooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" \\| ");
        GameObject gameObject = null;
        switch (input[1]){
            case "Demon":
                gameObject = new Demon(input[0],Integer.parseInt(input[3]), Double.parseDouble(input[2]));
                break;
            case "Archangel":
                gameObject = new Archangel(input[0],Integer.parseInt(input[3]), Integer.parseInt(input[2]));
                break;
        }

        System.out.println(gameObject);
    }
}
