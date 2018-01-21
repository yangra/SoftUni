package _04LinkedStack;

public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (int i = 0; i < 12; i++) {
            stack.push(i+1);
        }

        System.out.println(stack.toArray());
        System.out.println(stack.size());

        System.out.println(stack.pop());

        System.out.println(stack.size());

    }
}
