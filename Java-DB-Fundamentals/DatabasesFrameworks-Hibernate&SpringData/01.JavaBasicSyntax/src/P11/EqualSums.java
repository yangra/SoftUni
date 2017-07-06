package P11;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s")).mapToInt(a->Integer.parseInt(a)).toArray();
        int leftSum = 0;
        int rightSum = 0;
        boolean exists = false;
        for (int i = 0; i <arr.length ; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j <i ; j++) {
                leftSum +=arr[j];
            }
            for (int j = i+1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum){
                System.out.println(i);
                exists = true;
                break;
            }
        }
        if (!exists){
            System.out.println("no");
        }
    }
}

