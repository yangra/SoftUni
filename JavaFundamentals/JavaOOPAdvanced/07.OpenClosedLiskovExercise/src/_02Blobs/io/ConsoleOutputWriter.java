package _02Blobs.io;

import _02Blobs.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String output, Object... params) {
        System.out.println(String.format(output, params));
    }
}
