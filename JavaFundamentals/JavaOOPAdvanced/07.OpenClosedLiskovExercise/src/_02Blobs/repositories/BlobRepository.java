package _02Blobs.repositories;

import _02Blobs.interfaces.Blob;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepository implements Repository<Blob> {

    private Map<String,Blob> blobs;

    public BlobRepository() {
        this.blobs = new LinkedHashMap<>();
    }

    @Override
    public void add(Blob element) {
        this.blobs.putIfAbsent(element.getName(),element);
    }

    @Override
    public Blob findByName(String name) {
        return this.blobs.get(name);
    }

    @Override
    public Map<String, Blob> findAll() {
        return Collections.unmodifiableMap(this.blobs);
    }
}

