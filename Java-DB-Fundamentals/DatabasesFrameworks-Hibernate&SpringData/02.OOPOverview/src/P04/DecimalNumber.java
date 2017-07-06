package P04;

public class DecimalNumber {
    private double number;

    public DecimalNumber(double number){
        this.number = number;
    }

    public void reverse(){

        double decimalPart = this.number%1;
        int numOfDigits = 0;
        while(decimalPart>0.000001){
            decimalPart *=10;
            decimalPart = decimalPart%1;
            numOfDigits++;
        }
        int multiplier = 1;
        for (int i = 0; i < numOfDigits; i++) {
            multiplier*=10;
        }
        long number = (long)(this.number*multiplier);
        int digit = 0;
        for (int i = 0; i <numOfDigits ; i++) {
            digit = (int)(number%10);
            System.out.print(digit);
            number = number/10;
        }
        if (multiplier>1){
            System.out.print(".");
        }
        while(number!=0){
            digit = (int)(number%10);
            System.out.print(digit);
            number = number/10;
        }

    }

}
