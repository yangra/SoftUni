package _04GenericSwapMethodInteger;

public class Box<T> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().toString().substring(6),
                this.element);
    }
}
