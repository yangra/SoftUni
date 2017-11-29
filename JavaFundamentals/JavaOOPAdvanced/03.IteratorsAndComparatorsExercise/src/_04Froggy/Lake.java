package _04Froggy;

import java.util.Iterator;

public class Lake<T> implements Iterable<T> {
    private T[] lake;

    public Lake(T[] lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {
        private int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if (this.index % 2 != 0 && this.index > lake.length - 1) {
                return false;
            }
            if (this.index != 0 && this.index % 2 == 0 && lake.length == 1) {
                return false;
            }
            return true;
        }
        @Override
        public T next() {
            if (this.index % 2 == 0 && this.index > lake.length - 1 && lake.length >= 2) {
                this.index = 1;
                T leaf = lake[this.index];
                this.index += 2;
                return leaf;
            }

            if (this.index < lake.length) {
                T leaf = lake[this.index];
                this.index += 2;

                return leaf;
            }
            return null;
        }
    }



}
