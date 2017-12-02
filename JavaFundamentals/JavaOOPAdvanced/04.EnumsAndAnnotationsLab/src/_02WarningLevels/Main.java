package _02WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String defaultImportance = reader.readLine();

        Logger logger = new Logger(defaultImportance);

        while(true){
            String[] input = reader.readLine().split(":\\s+");
            if("END".equals(input[0])){
                break;
            }

            Message message = new Message(input[0], input[1]);
            logger.receiveMessage(message);
        }

        logger.getMessages().forEach(System.out::println);
    }
}
