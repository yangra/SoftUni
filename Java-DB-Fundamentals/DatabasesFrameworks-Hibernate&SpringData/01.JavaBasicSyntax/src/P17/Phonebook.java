package P17;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,String>  phonebook = new HashMap<>();
        String line = scan.nextLine();
        while(!"END".equals(line)){
            String[] commandLine = line.split("\\s");
            if ("A".equals(commandLine[0])){
                phonebook.put(commandLine[1], commandLine[2]);
            }else{
                if(!phonebook.containsKey(commandLine[1])){
                    System.out.printf("Contact %s does not exist.\n", commandLine[1]);
                }else{
                    System.out.printf("%s -> %s\n",commandLine[1], phonebook.get(commandLine[1]));
                }
            }
            line = scan.nextLine();
        }
    }
}
