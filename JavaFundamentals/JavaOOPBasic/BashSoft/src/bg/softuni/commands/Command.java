package bg.softuni.commands;

import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public abstract class Command {
    private String input;
    private String[] data;

    private StudentsRepository repository;
    private Tester tester;
    private IOManager ioManager;
    private DownloadManager downloadManager;

    protected Command(String input,
                      String[] data,
                      StudentsRepository repository,
                      Tester tester,
                      IOManager ioManager,
                      DownloadManager downloadManager) {
        this.setInput(input);
        this.setData(data);
        this.repository = repository;
        this.tester = tester;
        this.ioManager = ioManager;
        this.downloadManager = downloadManager;
    }

    protected String getInput() {
        return this.input;
    }

    private void setInput(String input) {
        this.input = input;
    }

    protected String[] getData() {
        return this.data;
    }

    private void setData(String[] data) {
        this.data = data;
    }

    protected StudentsRepository getRepository() {
        return this.repository;
    }

    protected Tester getTester() {
        return this.tester;
    }

    protected IOManager getIOManager() {
        return this.ioManager;
    }

    protected DownloadManager getDownloadManager() {
        return this.downloadManager;
    }

    public abstract void execute() throws Exception;
}

