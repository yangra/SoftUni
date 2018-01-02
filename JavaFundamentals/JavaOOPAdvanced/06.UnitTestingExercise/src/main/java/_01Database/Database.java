package _01Database;

import javax.naming.OperationNotSupportedException;

public interface Database<T> {

    void add(T element) throws OperationNotSupportedException;

    T remove() throws OperationNotSupportedException;

    T[] fetchAll();
}
