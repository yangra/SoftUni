package _03DependencyInversion;

import _03DependencyInversion.operations.OperationAdd;
import _03DependencyInversion.operations.OperationDivide;
import _03DependencyInversion.operations.OperationMultiply;
import _03DependencyInversion.operations.OperationSubtract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Context context = new Context();
        while (true) {
            String[] command = reader.readLine().split("\\s+");
            if ("End".equals(command[0])) {
                break;
            }

            if ("mode".equals(command[0])) {
                switch (command[1]) {
                    case "+":
                        context.changeStrategy(new OperationAdd());
                        break;
                    case "/":
                        context.changeStrategy(new OperationDivide());
                        break;
                    case "*":
                        context.changeStrategy(new OperationMultiply());
                        break;
                    case "-":
                        context.changeStrategy(new OperationSubtract());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid command!");
                }
            } else {
                System.out.println(context.executeStrategy(Integer.parseInt(command[0]), Integer.parseInt(command[1])));
            }

        }
    }
}
