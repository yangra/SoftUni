package _02Blobs;

import _02Blobs.engine.Engine;
import _02Blobs.interfaces.Blob;
import _02Blobs.interfaces.InputReader;
import _02Blobs.interfaces.OutputWriter;
import _02Blobs.io.ConsoleInputReader;
import _02Blobs.io.ConsoleOutputWriter;
import _02Blobs.repositories.BlobRepository;
import _02Blobs.repositories.Repository;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        Repository<Blob> repository = new BlobRepository();

        Engine engine = new Engine(inputReader,outputWriter,repository);
        engine.run();
    }
}
