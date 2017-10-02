import java.util.Scanner;

public class P03ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String openTag = "<upcase>";
        String closeTag = "</upcase>";
        StringBuilder stringBuilder = new StringBuilder();
        String text = scanner.nextLine();

        while(text.contains(openTag)){
            int index = text.indexOf(openTag);
            stringBuilder.append(text.substring(0,index));
            int startIndex = text.indexOf(openTag);
            int endIndex = text.indexOf(closeTag);
            stringBuilder.append(text.substring(startIndex+openTag.length(),endIndex).toUpperCase());
            text = text.replace(text.substring(0,endIndex+closeTag.length()),"");
        }
        stringBuilder.append(text);

        System.out.println(stringBuilder.toString());
    }
}
