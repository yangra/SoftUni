package P14;

import java.util.Scanner;

public class CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String text = scan.nextLine();
        char[] stars = new char[email.indexOf('@')];
        for (int i = 0; i < stars.length ; i++) {
            stars[i] = '*';
        }
        String domain = email.substring(email.indexOf('@'));
        String replacement = new String(stars);

        String result = text.replaceAll(email,replacement+domain);

        System.out.println(result);
    }
}

