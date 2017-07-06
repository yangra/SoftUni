package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Yana on 6/27/2017.
 */
public class ComapreCharArraysTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = reader.readLine().split("\\s");
        String firstWord = String.join("", Arrays.asList(arr1));
    }

}
