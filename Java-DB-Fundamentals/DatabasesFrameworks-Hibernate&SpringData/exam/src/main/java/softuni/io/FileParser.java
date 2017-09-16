package softuni.io;


import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileParser {
    public String readFile(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream is = this.getClass().getResourceAsStream(path);
             BufferedReader bfr = new BufferedReader(new InputStreamReader(is))) {

            String line = bfr.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = bfr.readLine();
            }
        }

        return stringBuilder.toString();
    }

    public void writeFile(String path, String content) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + path);
        if (!file.exists()) {

                file.createNewFile();

        }
        try (OutputStream os = new FileOutputStream(System.getProperty("user.dir")+ File.separator + path);
             BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os))) {

            bfw.write(content);
        }
    }
}
