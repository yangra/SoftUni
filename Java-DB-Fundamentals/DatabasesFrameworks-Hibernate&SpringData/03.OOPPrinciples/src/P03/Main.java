package P03;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        Ferrari ferrari = new Ferrari(name);
        Driver driver = ferrari;
        Car car = ferrari;
        System.out.print(car.getModel()+"/");
        car.brakes();
        System.out.print("/");
        car.gas();
        System.out.println("/"+ driver.getName());
    }
}
