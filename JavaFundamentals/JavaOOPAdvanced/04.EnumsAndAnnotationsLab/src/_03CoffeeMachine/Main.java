package _03CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while(true){
            String[] input = reader.readLine().split("\\s+");
            if("END".equalsIgnoreCase(input[0])){
                break;
            }
            if(input.length== 2){
                coffeeMachine.buyCoffee(input[0], input[1]);
            }else{
                coffeeMachine.insertCoin(input[0]);
            }
        }
    }
}
