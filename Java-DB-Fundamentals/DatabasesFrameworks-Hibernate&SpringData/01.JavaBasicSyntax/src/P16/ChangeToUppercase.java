package P16;

import java.util.Scanner;

public class ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        while(text.contains("<upcase>")){
            int startIndex = text.indexOf("<upcase>");
            String replacement = text.substring(text.indexOf("<upcase>"), text.indexOf("</upcase>"));
            replacement = replacement.substring(8).toUpperCase();
            text = text.replace(text.substring(text.indexOf("<upcase>"), text.indexOf("</upcase>")+9),replacement);
        }

        System.out.println(text);
    }
}
