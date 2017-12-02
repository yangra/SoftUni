package _14InfernoInfinityRefactoring.io.impl;

import _14InfernoInfinityRefactoring.io.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {
    private BufferedReader reader;

    public ConsoleInputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        String result = null;

        try{
            result = this.reader.readLine();
        }catch (IOException ioe){
            throw new IOException(ioe.getMessage(),ioe);
        }

        return result;
    }
}
