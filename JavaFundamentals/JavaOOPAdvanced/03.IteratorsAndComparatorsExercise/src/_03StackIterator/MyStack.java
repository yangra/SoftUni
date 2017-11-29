package _03StackIterator;

public interface MyStack<T> extends Iterable<T> {
   void push(T... elements);
   T pop();
}
