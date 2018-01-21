package _06ReversedList;

public class Main {
    public static void main(String[] args) {
        ReversedList<Integer> list = new ReversedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.removeAt(2);

        printList(list);

        System.out.println(list.get(2));

        list.set(0, 12);
        printList(list);

        System.out.println(list.count());

        System.out.println(list.capacity());
    }

    private static void printList(ReversedList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


}
