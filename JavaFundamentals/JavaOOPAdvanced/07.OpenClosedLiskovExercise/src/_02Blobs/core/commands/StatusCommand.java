package _02Blobs.core.commands;

import _02Blobs.core.BaseCommand;
import _02Blobs.interfaces.Blob;

import java.util.Map;

public class StatusCommand extends BaseCommand {
    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Blob> blobEntry : super.getRepository().findAll().entrySet()) {
            sb.append(blobEntry.getValue().toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
