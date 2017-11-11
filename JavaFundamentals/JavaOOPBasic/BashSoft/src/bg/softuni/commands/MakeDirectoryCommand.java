package bg.softuni.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class MakeDirectoryCommand extends Command {
    public MakeDirectoryCommand(String input,
                                String[] data,
                                StudentsRepository repository,
                                Tester tester,
                                IOManager inputOutputManager,
                                DownloadManager downloadManager) {
        super(input,data,repository,tester,inputOutputManager,downloadManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidCommandException(this.getInput());
        }

        String folderName = data[1];
        this.getIOManager().createDirectoryInCurrentFolder(folderName);
    }
}
