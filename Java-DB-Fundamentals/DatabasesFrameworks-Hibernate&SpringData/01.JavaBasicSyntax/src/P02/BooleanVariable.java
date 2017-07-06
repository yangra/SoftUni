package P02;

import java.util.Scanner;

public class BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextBoolean()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
