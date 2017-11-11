package _06Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Animal animal = null;
        while (true) {
            String line = reader.readLine();
            if (line.equals("Beast!")) {
                break;
            }
            String[] params = reader.readLine().split("\\s+");
            if (params.length == 3) {
                try {
                    switch (line) {
                        case "Cat":
                            animal = new Cat(params[0], params[1], params[2]);
                            break;
                        case "Dog":
                            animal = new Dog(params[0], params[1], params[2]);
                            break;
                        case "Frog":
                            animal = new Frog(params[0], params[1], params[2]);
                            break;
                        case "Kitten":
                            animal = new Kitten(params[0], params[1], params[2]);
                            break;
                        case "Tomcat":
                            animal = new Tomcat(params[0], params[1], params[2]);
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    if (animal != null) {
                        System.out.println(animal);
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            } else {
                System.out.println("Invalid input!");

            }
        }
    }
}