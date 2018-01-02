package _02DatabaseExtended;

import javax.naming.OperationNotSupportedException;

public interface Database<T> {

    void add(T element) throws OperationNotSupportedException;

    T remove() throws OperationNotSupportedException;

    T findByUsername(String username) throws OperationNotSupportedException;

    T findById(long id) throws OperationNotSupportedException;

    T[] fetchAll();
}
