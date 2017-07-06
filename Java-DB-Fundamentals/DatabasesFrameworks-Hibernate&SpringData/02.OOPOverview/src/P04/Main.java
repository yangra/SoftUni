package P04;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalNumberTwo dn = new DecimalNumberTwo(scan.nextDouble());
        dn.reverse();
    }
}
