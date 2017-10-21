package Judge;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void compareContent(String actualOutput, String expectedOutput) {
        OutputWriter.writeMessageOnNewLine("Reading files...");
        String mismatchPath = getMismatchPath(expectedOutput);

        List<String> actualOutputString = readTextFile(actualOutput);
        List<String> expectedOutputString = readTextFile(expectedOutput);

        boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchPath);

        if (mismatch) {
            List<String> mismatchString = readTextFile(mismatchPath);
            mismatchString.forEach(OutputWriter::writeMessageOnNewLine);
        } else {
            OutputWriter.writeMessageOnNewLine("Files are identical. There are no mismatches.");
        }
    }

    private static boolean compareStrings(List<String> actualOutputString,
                                          List<String> expectedOutputString,
                                          String mismatchPath) {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
//        String output = "";
        boolean isMismatch = false;


        try (FileWriter fileWriter = new FileWriter(mismatchPath);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            if (actualOutputString.size() == expectedOutputString.size()) {
                isMismatch = compareLines(actualOutputString, expectedOutputString, isMismatch, writer);
            } else if (actualOutputString.size() > expectedOutputString.size()) {
                isMismatch = compareLines(actualOutputString, expectedOutputString, isMismatch, writer);
                for (int i = expectedOutputString.size(); i < actualOutputString.size(); i++) {
                    isMismatch = true;
                    String output = String.format("mismatch -> expected(-empty-), actual{%s}\n", actualOutputString.get(i));
                    writer.write(output);
                }
            } else {
                isMismatch = compareLines(expectedOutputString, actualOutputString, isMismatch, writer);
                for (int i = actualOutputString.size(); i < expectedOutputString.size(); i++) {
                    isMismatch = true;
                    String output = String.format("mismatch -> expected(%s), actual{-empty-}\n", expectedOutputString.get(i));
                    writer.write(output);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
            OutputWriter.displayException(ExceptionMessages.PROBLEM_OPENING_FILE + "\n");
        }

        return isMismatch;
    }

    private static boolean compareLines(List<String> actualOutputString, List<String> expectedOutputString, boolean isMismatch, BufferedWriter writer) throws IOException {
        String output = "";
        for (int i = 0; i < expectedOutputString.size(); i++) {
            String actualLine = actualOutputString.get(i);
            String expectedLine = expectedOutputString.get(i);

            if (!actualLine.equals(expectedLine)) {
                output = String.format("mismatch -> expected(%s), actual{%s}\n", expectedLine, actualLine);
                isMismatch = true;
            } else {
                output = String.format("line match -> %s\n", actualLine);
            }
            writer.write(output);
        }
        return isMismatch;
    }

    private static List<String> readTextFile(String filePath) {
        List<String> text = new ArrayList<>();

        File file = new File(filePath);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line = reader.readLine();
            while (line != null) {
                text.add(line);
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_FILE + " " + filePath + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            OutputWriter.displayException(ExceptionMessages.PROBLEM_OPENING_FILE + " " + filePath + "\n");
        }

        return text;
    }

    private static String getMismatchPath(String expectedOutput) {
        int index = expectedOutput.lastIndexOf('\\');
        String directoryPath = expectedOutput.substring(0, index);
        return directoryPath + "\\mismatch.txt";
    }
}
