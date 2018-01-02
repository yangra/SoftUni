package _01Database;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DatabaseImpl implements Database<Integer> {
    private Integer[] ints;
    private int index;

    public DatabaseImpl(int capacity, Integer... params) throws OperationNotSupportedException {
        if (capacity != 16) {
            throw new OperationNotSupportedException("Database capacity must be 16.");
        }

        this.ints = new Integer[capacity];
        for (int i = 0; i < params.length; i++) {
            this.add(params[i]);
        }
    }


    @Override
    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException("You cannot add a null.");
        }

        if (this.index >= 16) {
            throw new OperationNotSupportedException("Capacity already full.");
        }

        this.ints[index++] = element;
    }

    @Override
    public Integer remove() throws OperationNotSupportedException {

        if (this.index == 0) {
            throw new OperationNotSupportedException("Database is emty, there's nothing to remove");
        }

        Integer element = this.ints[--this.index];
        this.ints[this.index] = null;
        return element;
    }

    @Override
    public Integer[] fetchAll() {
        return Arrays.copyOf(this.ints, index);
    }
}
