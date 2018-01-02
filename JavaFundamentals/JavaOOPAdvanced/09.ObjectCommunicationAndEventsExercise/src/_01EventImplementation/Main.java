package _01EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        while(true){
            String nameChange = reader.readLine();
            if("End".equals(nameChange)){
                break;
            }

            dispatcher.setName(nameChange);
        }

    }
}
