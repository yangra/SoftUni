package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.Executable;
import main.bg.softuni.network.AsynchDownloader;

@Alias("download")
public class DownloadFileCommand extends Command implements Executable {

    @Inject
    private AsynchDownloader downloadManager;

    public DownloadFileCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidCommandException(this.getInput());
        }

        String fileUrl = data[1];
        this.downloadManager.download(fileUrl);
    }
}
