import java.io.*;

public class P01ReadFile {
    static String input = "C:\\Users\\Yana\\Downloads\\input.txt";
    static String output = "C:\\Users\\Yana\\Downloads\\output.txt";

    public static void main(String[] args) {

        try (InputStream inputStreamReader = new FileInputStream(input)){
            int oneByte = inputStreamReader.read();
            while(oneByte>=0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = inputStreamReader.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
