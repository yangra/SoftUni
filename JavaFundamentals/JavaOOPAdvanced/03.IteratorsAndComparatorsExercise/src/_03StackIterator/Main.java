package _03StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyStack<Integer> stack = new MyStackImpl<>();

        while (true) {
            String[] command = reader.readLine().split("[,\\s]+");
            if ("END".equalsIgnoreCase(command[0])) {
                for (int i = 0; i < 2; i++) {
                    for (Integer num : stack) {
                        System.out.println(num);
                    }
                }
                break;
            }

            switch (command[0]) {
                case "Push":
                    stack.push(Arrays.stream(command).skip(1).map(Integer::valueOf).toArray(Integer[]::new));
                    break;
                case "Pop":
                    try{
                    stack.pop();}
                    catch(IllegalStateException ise){
                        System.out.println(ise.getMessage());
                    }
                    break;

            }
        }
    }
}
