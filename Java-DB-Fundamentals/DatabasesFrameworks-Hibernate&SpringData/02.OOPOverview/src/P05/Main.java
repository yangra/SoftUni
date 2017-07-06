package P05;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dims1 = Arrays.stream(scan.nextLine().split("\\s")).mapToInt(a->Integer.parseInt(a)).toArray();
        int[] dims2 = Arrays.stream(scan.nextLine().split("\\s")).mapToInt(a->Integer.parseInt(a)).toArray();
        Point o1 = new Point(dims1[0],dims1[1]);
        Point o2 = new Point(dims2[0], dims2[1]);
        Circle c1 = new Circle(dims1[2],o1);
        Circle c2 = new Circle(dims2[2],o2);
        if(intersect(c1,c2)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static boolean intersect(Circle c1, Circle c2){
        int sumOfRadii = c1.getRadius()+c2.getRadius();
        double distanceBetweenCenters = Math.sqrt(Math.pow((c2.getCenter().getX()-c1.getCenter().getX()),2)+Math.pow((c2.getCenter().getY()-c1.getCenter().getY()),2));
       if (sumOfRadii < distanceBetweenCenters){
           return false;
       }
       return true;
    }
}
