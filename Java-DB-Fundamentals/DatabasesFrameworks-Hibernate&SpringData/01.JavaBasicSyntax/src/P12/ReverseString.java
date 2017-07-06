package P12;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String reversed = new StringBuilder(scan.nextLine()).reverse().toString();
        System.out.println(reversed);
    }
}
