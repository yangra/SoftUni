package _10July2016.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader {
    private BufferedReader reader;

    public ConsoleInputReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
       return this.reader.readLine();
    }
}
