import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileInputStream(P01ReadFile.input));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(P01ReadFile.output))){

            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    printWriter.println(scanner.nextInt());
                }

                scanner.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
