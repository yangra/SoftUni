import java.math.BigDecimal;
import java.util.Scanner;

public class P05TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextDouble();
        scanner.nextLine();
        String timeOfTheDay = scanner.nextLine();

        double initialTax = 0.7;
        double dayTaxiTax = 0.79;
        double nightTaxiTax = 0.9;
        double busTax = 0.09;
        double trainTax = 0.06;
        int minTrainDistance = 100;
        int minBusDistance = 20;

        BigDecimal tax = BigDecimal.ZERO;
        if(distance<minBusDistance){
            tax = tax.add(BigDecimal.valueOf(initialTax));
            if(timeOfTheDay.equals("day")){
                tax = tax.add(BigDecimal.valueOf(distance*dayTaxiTax));
            }else if(timeOfTheDay.equals("night")){
                tax = tax.add(BigDecimal.valueOf(distance*nightTaxiTax));
            }
        }else if(distance>=minBusDistance&& distance<minTrainDistance){
            tax = BigDecimal.valueOf(distance*busTax);
        }else if(distance>=minTrainDistance){
            tax = BigDecimal.valueOf(distance*trainTax);
        }

        System.out.printf("%.2f",tax);
    }
}
