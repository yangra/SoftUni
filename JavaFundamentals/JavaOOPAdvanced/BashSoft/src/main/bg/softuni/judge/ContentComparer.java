package main.bg.softuni.judge;

import java.io.IOException;

public interface ContentComparer {
    void compareContent(String actualOutput, String expectedOutput) throws IOException;
}
