import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) {
        Path inPath = Paths.get(P01ReadFile.input);
        Path outPath = Paths.get(P01ReadFile.output);

        try {
            List<String> allLines = Files.readAllLines(inPath);
            Collections.sort(allLines);
            Files.write(outPath,allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
