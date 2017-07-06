package P03;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Number num = new Number(scan.nextInt());
        System.out.println(num.getEnglishName());

    }
}
