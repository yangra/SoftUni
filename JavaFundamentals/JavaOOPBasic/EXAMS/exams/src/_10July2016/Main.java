package _10July2016;


import _10July2016.core.Engine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        try {
            engine.run();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
