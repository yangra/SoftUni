package P09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String animal = scan.nextLine();
        while (!"Beast!".equals(animal)) {
            String[] info = scan.nextLine().split("\\s");
            if (info.length == 3) {
                switch (animal.toLowerCase()) {
                    case "frog": {
                        try {
                            SoundProducible frog = new Frog(info[0], Integer.parseInt(info[1]), info[2]);
                            System.out.println(frog);
                            frog.produceSound();
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Invalid input!");
                        }
                        break;
                    }
                    case "dog": {
                        try {
                            SoundProducible dog = new Dog(info[0], Integer.parseInt(info[1]), info[2]);
                            System.out.println(dog);
                            dog.produceSound();
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Invalid input!");
                        }
                        break;
                    }
                    case "cat": {
                        try {
                            SoundProducible cat = new Cat(info[0], Integer.parseInt(info[1]), info[2]);
                            System.out.println(cat);
                            cat.produceSound();
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Invalid input!");
                        }
                        break;
                    }
                    case "kitten": {
                        try {
                            SoundProducible kitten = new Kitten(info[0], Integer.parseInt(info[1]), info[2]);
                            System.out.println(kitten);
                            kitten.produceSound();
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Invalid input!");
                        }
                        break;
                    }
                    case "tomcat": {
                        try {
                            SoundProducible tomcat = new Tomcat(info[0], Integer.parseInt(info[1]), info[2]);
                            System.out.println(tomcat);
                            tomcat.produceSound();
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Invalid input!");
                        }
                        break;
                    }
                    default:
                        System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            animal = scan.nextLine();
        }
    }
}
