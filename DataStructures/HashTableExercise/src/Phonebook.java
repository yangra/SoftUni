import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dictionary<String,String> phonebook = new Dictionary<>();
        String input = reader.readLine();
        while (true){
            if(input.equals("search")){
                break;
            }
            String[] params = input.split("-");
            phonebook.addOrReplace(params[0], params[1]);
            input = reader.readLine();
        }
        input = reader.readLine();
        while (true){
            if(input.equals("end")){
                break;
            }
           if(phonebook.containsKey(input)){
               KeyValue<String,String> kvp = phonebook.find(input);
               System.out.printf("%s -> %s\n", kvp.getKey(), kvp.getValue());
           }else{
               System.out.printf("Contact %s does not exist.\n", input);
           }
           input = reader.readLine();
        }
    }
}
