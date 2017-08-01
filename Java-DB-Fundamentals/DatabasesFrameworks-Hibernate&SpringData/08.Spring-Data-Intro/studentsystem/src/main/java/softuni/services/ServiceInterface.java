package softuni.services;


import java.util.List;

public interface ServiceInterface<E,K> {

    List<E> findAll();

    E findById(K id);

    void save(E object);
}
