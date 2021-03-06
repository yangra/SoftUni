package app.waste_disposal.io;


import app.waste_disposal.contracts.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    public void writeLine(String output, Object... params) {
        System.out.println(String.format(output, params));
    }
}
