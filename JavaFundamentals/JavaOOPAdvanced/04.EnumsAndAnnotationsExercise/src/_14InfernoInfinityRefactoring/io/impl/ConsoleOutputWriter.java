package _14InfernoInfinityRefactoring.io.impl;

import _14InfernoInfinityRefactoring.io.contracts.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String output){
        System.out.println(output);
    }
}
