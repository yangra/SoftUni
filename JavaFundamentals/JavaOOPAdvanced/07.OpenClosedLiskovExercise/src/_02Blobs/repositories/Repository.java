package _02Blobs.repositories;

import _02Blobs.interfaces.Blob;

import java.util.Map;

public interface Repository<T> {

    void add(T element);

    Blob findByName(String name);

    Map<String, T> findAll();
}
