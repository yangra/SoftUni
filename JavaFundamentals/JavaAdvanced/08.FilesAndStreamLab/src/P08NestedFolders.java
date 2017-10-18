import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {
    public static void main(String[] args) {

        String inPath = "C:\\Users\\Yana\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(inPath);
        Deque<File> queue = new ArrayDeque<>();

        if(root.exists()&&root.isDirectory()){
            queue.offer(root);
        }

        int count = 0;
        while(queue.size()>0){
            File currentDirectory = queue.poll();
            System.out.println(currentDirectory.getName());
            count++;

            for (File file : currentDirectory.listFiles()) {
                if(file.isDirectory()){
                    queue.offer(file);
                }
            }
        }

        System.out.printf("%d folders\n", count);
    }
}
