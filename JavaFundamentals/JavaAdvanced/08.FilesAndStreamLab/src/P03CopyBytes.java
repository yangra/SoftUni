import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream(P01ReadFile.input);
             OutputStream outputStream = new FileOutputStream(P01ReadFile.output)) {
            int oneByte = 0;
            while ((oneByte = inputStream.read()) >= 0) {
                if (oneByte == 32 || oneByte == 10) {
                    outputStream.write(oneByte);
                }else{
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length() ; i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
