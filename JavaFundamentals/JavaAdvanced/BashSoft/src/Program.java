import IO.InputReader;
import StaticData.SessionData;

public class Program {
    public static void main(String[] args) {
        String currentDirectory = SessionData.currentPath;
//        IO.IOManager.traverseDirectory(2);
//        Repository.StudentsRepository.initializeData("data.txt");
//        Repository.StudentsRepository.getStudentsByCourse("Unity");
//        Judge.Tester.compareContent(currentDirectory+"\\test1.txt",currentDirectory+"\\test2.txt");
//        IO.IOManager.createDirectoryInCurrentFolder("pesho");
        try {
            InputReader.readCommands();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
