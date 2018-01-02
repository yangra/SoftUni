package BoatSimulator.contracts;

import BoatSimulator.exceptions.DuplicateModelException;
import BoatSimulator.exceptions.NonExistingModelException;

public interface Repository<T extends Modelable> {

    void add(T item) throws DuplicateModelException;

    T getByModel(String model) throws NonExistingModelException;
}
