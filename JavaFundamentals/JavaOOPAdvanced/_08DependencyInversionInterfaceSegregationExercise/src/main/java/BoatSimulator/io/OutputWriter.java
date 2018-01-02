package BoatSimulator.io;

public interface OutputWriter {

    public void writeLine(String output);

    public void writeLine(String output, Object... params);
}
