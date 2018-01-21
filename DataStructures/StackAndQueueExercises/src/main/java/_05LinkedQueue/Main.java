package _05LinkedQueue;

public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        for (int i = 0; i < 12; i++) {
            queue.enqueue(i+1);
        }

        System.out.println(queue.toArray());
        System.out.println(queue.size());

        System.out.println(queue.dequeue());

        System.out.println(queue.size());
    }
}
