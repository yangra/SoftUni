import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {

        String input = "C:\\Users\\Yana\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File in = new File(input);

        if (in.exists()) {
            if (in.isDirectory()) {
                File[] files = in.listFiles();
                for (File file : files) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: %s\n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
