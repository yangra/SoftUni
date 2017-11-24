package _06GenericCountMethodDoubles;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{
    private T element;

    public Box(T element) {
        this.element = element;
    }


    @Override
    public int compareTo(Box<T> other) {
        return Integer.compare(this.element.compareTo(other.element), 0);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().toString().substring(6),
                this.element);
    }


}
