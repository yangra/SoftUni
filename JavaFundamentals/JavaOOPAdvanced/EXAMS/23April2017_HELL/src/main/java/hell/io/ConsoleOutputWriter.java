package hell.io;


import hell.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    public void writeLine(String output, Object... params) {
        System.out.println(String.format(output, params));
    }
}
