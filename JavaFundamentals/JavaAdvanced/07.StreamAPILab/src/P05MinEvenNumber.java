import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class P05MinEvenNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Comparator<Double> check = (n1,n2)->n1.compareTo(n2);

        Optional<Double> result = Arrays.stream(reader.readLine().split(" "))
                .filter(s -> s!=null&&s.length()>0)
                .map(Double::parseDouble)
                .filter(n -> n % 2 == 0)
                .min(check);

        if(result.isPresent()){
            System.out.printf("%.2f",result.get());
        }else{
            System.out.println("No match");
        }
    }
}
