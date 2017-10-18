import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02WriteToAFile {
    public static void main(String[] args) {
        List<Character> punctuatuion = new ArrayList<>();
        Collections.addAll(punctuatuion,',','.','!','?');

        try (InputStream inputStream = new FileInputStream(P01ReadFile.input);
             OutputStream outputStream = new FileOutputStream(P01ReadFile.output)){
            int oneByte = 0;
            while((oneByte=inputStream.read())>=0){
                if(!punctuatuion.contains((char)oneByte)){
                    outputStream.write(oneByte);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
