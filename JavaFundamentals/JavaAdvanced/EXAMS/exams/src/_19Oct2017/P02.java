package _19Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Double sum = 0.0;
        ArrayDeque<Integer> signs = new ArrayDeque<>();
        Pattern regex = Pattern.compile("([-]*\\d+\\.?\\d*)([^.\\d]+?)(?=([-]*\\d+\\.?\\d*))");
        Pattern lastNumber = Pattern.compile("([-]*\\d+\\.?\\d*)");
        Matcher matcher = regex.matcher(input);
        while(matcher.find()){
           Double num = Double.parseDouble(matcher.group(1));
           String sign = matcher.group(2);
           if(signs.size()>0){
               if(signs.peek()==1){
                   sum+=num;
               }else{
                   sum-=num;
               }
               signs.poll();
               if(sign.length()%2==0){
                   signs.offer(1);
               }else{
                   signs.offer(0);
               }
           }else{
               sum+=num;
               if(sign.length()%2==0){
                   signs.offer(1);
               }else{
                   signs.offer(0);
               }
           }
        }

        Matcher lastMatcher = lastNumber.matcher(input);
        Double last = 0.0;
        while(lastMatcher.find()){
            last = Double.parseDouble(lastMatcher.group());
        }

        if(signs.peek()==1){
            sum+=last;
        }else{
            sum-=last;
        }

        DecimalFormat df = new DecimalFormat("0.#######");
        System.out.printf("%s",df.format(sum));
    }
}