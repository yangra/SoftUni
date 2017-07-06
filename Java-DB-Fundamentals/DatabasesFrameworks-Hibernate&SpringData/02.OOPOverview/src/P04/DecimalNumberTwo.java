package P04;


public class DecimalNumberTwo {
    private Double number;

    public DecimalNumberTwo(double number){
        this.number = number;
    }

    public void reverse(){
        String num = this.number.toString();
        if(num.contains(".")&&num.length()-1==num.indexOf(".")+1&&num.substring(num.indexOf(".")+1).equals("0")){
            num = num.substring(0,num.indexOf("."));
        }
        if (num.length()== num.length())
        for (int i = num.length()-1; i >=0; i--) {
            System.out.print(num.substring(i,i+1));
        }
    }
}
