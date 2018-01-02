package BoatSimulator.database;

import BoatSimulator.contracts.Repository;
import BoatSimulator.utility.Constants;
import BoatSimulator.contracts.Modelable;
import BoatSimulator.exceptions.DuplicateModelException;
import BoatSimulator.exceptions.NonExistingModelException;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CrudRepository<T extends Modelable> implements Repository<T> {

    private HashMap<String, T> items;

    public CrudRepository() {
        this.items = new HashMap<>();
    }

    @Override
    public void add(T item) throws DuplicateModelException {
        if (this.items.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.items.put(item.getModel(), item);

    }

    @Override
    public T getByModel(String model) throws NonExistingModelException {
        if (!this.items.containsKey(model)) {
            throw new NonExistingModelException(Constants.NON_EXISTING_MODEL_MESSAGE);
        }

        return this.items.get(model);
    }

}
