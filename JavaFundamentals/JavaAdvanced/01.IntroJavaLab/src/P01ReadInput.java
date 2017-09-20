import java.util.Scanner;

public class P01ReadInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord = scan.next("\\w+");
        String secondWord = scan.next("\\w+");
        int firstInt = scan.nextInt();
        int secondInt = scan.nextInt();
        int thirdInt = scan.nextInt();
        scan.nextLine();
        String lastWord = scan.nextLine();

        int sum = firstInt + secondInt + thirdInt;

        System.out.printf("%s %s %s %d", firstWord, secondWord, lastWord, sum);
    }
}
