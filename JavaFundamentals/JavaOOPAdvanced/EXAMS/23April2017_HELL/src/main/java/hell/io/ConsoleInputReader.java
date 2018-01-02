package hell.io;



import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {
    private BufferedReader reader;

    public ConsoleInputReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String readLine() {
        try {
            return this.reader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }
}
