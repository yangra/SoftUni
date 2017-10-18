import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P04SortStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();
        while(true){
            String fullName = reader.readLine();
            if("END".equalsIgnoreCase(fullName)){
                break;
            }

            names.add(fullName);
        }

        names.stream().sorted((n1,n2)->{
           int result =  n1.split("\\s+")[1].compareTo(n2.split("\\s+")[1]);
           if(result == 0) {
               result =  n2.split("\\s+")[0].compareTo(n1.split("\\s+")[0]);
           }
           return result;
        }).forEach(System.out::println);

    }
}
