package app.models;

import java.util.*;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }


    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    public void activateCluster() {
        this.clusters.get(0).activate();
        Cluster cluster = this.clusters.get(0);
        this.clusters.remove(0);
        this.clusters.add(cluster);
    }

}
