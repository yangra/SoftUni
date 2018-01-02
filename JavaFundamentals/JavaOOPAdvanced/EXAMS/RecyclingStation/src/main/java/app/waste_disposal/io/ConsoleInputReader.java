package app.waste_disposal.io;





import app.waste_disposal.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;

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
