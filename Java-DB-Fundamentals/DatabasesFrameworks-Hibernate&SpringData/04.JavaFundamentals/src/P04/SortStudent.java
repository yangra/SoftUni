package P04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortStudent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<String> students = new ArrayList<>();
        while (!"END".equals(line)) {
            students.add(line.trim());
            line = reader.readLine();
        }

        students.stream().sorted((a,b)->{
            int result = a.substring(a.indexOf(" ")+1).compareTo(b.substring(b.indexOf(" ")+1));
            if (result==0){
               result = b.substring(0,b.indexOf(" ")-1).compareTo(a.substring(0,a.indexOf(" ")-1));
            }
            return result;
                }).forEach(System.out::println);

    }
}
