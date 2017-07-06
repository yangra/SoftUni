package P04;

import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vowels = "aeuioyAEUUIOY";
        String digits = "0123456789";
        String input = scanner.next();
        if(vowels.contains(input)){
            System.out.println("vowel");
        }else if(digits.contains(input)){
            System.out.println("digit");
        }else{
            System.out.println("other");
        }
    }
}
