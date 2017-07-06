package P13;

import java.util.Scanner;

public class FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] text = scan.nextLine().toCharArray();
        char[] fitted = new char[20];
        if (text.length > 20) {
            for (int i = 0; i < 20; i++) {

                fitted[i] = text[i];
            }
        }else{
            for (int i = 0; i < text.length ; i++) {
                fitted[i] = text[i];
            }
            for (int i = text.length; i < 20 ; i++) {
                fitted[i] = '*';
            }
        }
        String result = new String(fitted);
        System.out.println(result);
    }
}
