package _11Threeuple;

public class ThreeupleImpl<A,B,C> extends TupleImpl<A,B> implements Threeuple<A,B,C> {
    private C item3;

    public ThreeupleImpl(A item1, B item2, C item3) {
        super(item1, item2);
        this.setItem3(item3);
    }

    public C getItem3() {
        return this.item3;
    }

    private void setItem3(C item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" -> %s", this.item3);
    }
}
