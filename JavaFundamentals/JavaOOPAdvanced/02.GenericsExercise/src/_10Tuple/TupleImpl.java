package _10Tuple;

public class TupleImpl<A, B> implements Tuple<A,B> {
    private A item1;
    private B item2;

    public TupleImpl(A item1, B item2) {
        this.setItem1(item1);
        this.setItem2(item2);
    }

    public A getItem1() {
        return this.item1;
    }

    private void setItem1(A item1) {
        this.item1 = item1;
    }

    public B getItem2() {
        return this.item2;
    }

    private void setItem2(B item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.item1, this.item2);
    }
}
