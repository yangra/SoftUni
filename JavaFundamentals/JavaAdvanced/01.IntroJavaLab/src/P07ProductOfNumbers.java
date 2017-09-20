import java.math.BigDecimal;
import java.util.Scanner;

public class P07ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerLimit = scanner.nextInt();
        int upperLimit = scanner.nextInt();

        BigDecimal result = BigDecimal.ONE;
        int  i  = lowerLimit;
        do{
           result = result.multiply(BigDecimal.valueOf(i));
           i++;
        }while(i<=upperLimit);

        System.out.printf("product[%d..%d] = %s",lowerLimit,upperLimit,result);
    }
}
