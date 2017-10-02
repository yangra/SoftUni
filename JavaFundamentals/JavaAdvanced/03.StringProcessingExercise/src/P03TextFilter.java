import java.util.Scanner;

public class P03TextFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] banList = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < banList.length; i++) {
            if(text.contains(banList[i])){
                String replacement = new String(new char[banList[i].length()]).replace("\0","*");
                text = text.replaceAll(banList[i],replacement);
            }
        }

        System.out.println(text);
    }
}
