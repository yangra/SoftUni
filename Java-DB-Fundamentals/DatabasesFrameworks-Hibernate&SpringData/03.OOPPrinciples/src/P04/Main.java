package P04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] phones = scan.nextLine().split("\\s");
        String[] sites = scan.nextLine().split("\\s");

        SmartPhone smartPhone = new SmartPhone();
        for (int i = 0; i < phones.length ; i++) {
            smartPhone.call(phones[i]);
        }
        for (int i = 0; i < sites.length ; i++) {
            smartPhone.browse(sites[i]);
        }
    }
}
