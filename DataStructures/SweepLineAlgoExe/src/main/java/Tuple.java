public class Tuple<T extends Comparable,K> {
    private T firstValue;
    private K secondValue;

    public Tuple(T firstValue, K secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(T firstValue) {
        this.firstValue = firstValue;
    }

    public K getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(K secondValue) {
        this.secondValue = secondValue;
    }
}
