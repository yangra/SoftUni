package _12March2017.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader {
    private BufferedReader reader;

    public ConsoleInputReader() {
       this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
        String result = null;

        try{
            result = this.reader.readLine();
        }catch (IOException ioe){
            throw new IOException(ioe.getMessage());
        }

        return result;
    }
}
