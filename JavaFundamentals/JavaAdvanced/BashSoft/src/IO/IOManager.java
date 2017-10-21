package IO;

import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;
import java.util.LinkedList;

public class IOManager {

    public static void traverseDirectory(int depth) {
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\" + File.separator).length;

        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\" + File.separator).length - initialIndentation;

            if (depth - currentIndentation < 0) {
                break;
            }

            try {
                if (currentFolder.listFiles() != null) {
                    for (File file : currentFolder.listFiles()) {
                        if (file.isDirectory()) {
                            subFolders.add(file);
                        } else {
                            int indexOfLastSeparator = file.toString().lastIndexOf(File.separator);
                            for (int i = 0; i < indexOfLastSeparator; i++) {
                                OutputWriter.writeMessage("-");
                            }

                            OutputWriter.writeMessageOnNewLine(file.getName());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                OutputWriter.displayException(ExceptionMessages.ACCESS_DENIED_MESSAGE);
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());
        }
    }

    public static void createDirectoryInCurrentFolder(String name) {
        String path = getCurrentDirectoryPath() + File.separator + name;
        File file = new File(path);
        file.mkdir();
    }

    private static String getCurrentDirectoryPath() {
        String currentPath = SessionData.currentPath;
        return currentPath;
    }

    public static void changeCurrentDirRelativePath(String relativePath) {
        if (relativePath.equals("..")) {
            //go one directory up
            String currentPath = SessionData.currentPath;
            int indexOfLastSeparator = currentPath.lastIndexOf(File.separator);
            String newPath = currentPath.substring(0, indexOfLastSeparator);
            SessionData.currentPath = newPath;
        } else {
            //go to given directory
            String currentPath = SessionData.currentPath;
            currentPath += File.separator + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath) {
        File file = new File(absolutePath);
        if (!file.exists()) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }
}
