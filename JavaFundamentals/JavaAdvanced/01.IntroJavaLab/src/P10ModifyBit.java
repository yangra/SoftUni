import java.util.Scanner;

public class P10ModifyBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int position = scanner.nextInt();
        int value = scanner.nextInt();

        int result = 0;
        if(value == 0){
            int mask = ~(1<<position);
            result = number&mask;
        }else{
            int mask = 1<<position;
            result = number|mask;
        }

        System.out.println(result);

    }
}
