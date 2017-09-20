import java.math.BigDecimal;
import java.util.Scanner;

public class P03EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double quantity = scanner.nextDouble();

        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceBGN = new BigDecimal(1.20*quantity);

        BigDecimal priceDM = exchangeRate.multiply(priceBGN);
        System.out.printf("%.2f marks", priceDM);
    }
}
