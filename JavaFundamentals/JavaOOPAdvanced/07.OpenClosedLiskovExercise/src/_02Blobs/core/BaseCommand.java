package _02Blobs.core;

import _02Blobs.annontations.Inject;
import _02Blobs.interfaces.Blob;
import _02Blobs.interfaces.Executable;
import _02Blobs.repositories.Repository;

public abstract class BaseCommand implements Executable {

    @Inject
    private String[] params;
    @Inject
    private Repository<Blob> repository;

    protected BaseCommand() {
    }

    public String[] getParams() {
        return this.params;
    }

    public Repository<Blob> getRepository() {
        return this.repository;
    }
}
