package _05RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList ral= new RandomArrayList();
        ral.add("a");
        ral.add(1);
        ral.add(2.2);
        ral.add("b");
        ral.add(3);
        ral.add(1.1);
        System.out.println(ral.getRandomElement());
        System.out.println(ral);
    }
}
