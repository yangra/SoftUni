package app.core;

import app.models.Cell;
import app.models.Cluster;
import app.models.Organism;
import app.models.bloodCells.RedBloodCell;
import app.models.bloodCells.WhiteBloodCell;
import app.models.microbes.Bacteria;
import app.models.microbes.Fungi;
import app.models.microbes.Virus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HealthManager {

    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new HashMap<>();
    }

    public String checkCondition(String organismName) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s\n", organismName));
        sb.append(String.format("--Clusters: %d\n", organisms.get(organismName).getClusters().size()));
        sb.append(String.format("--Cells: %d", organisms.get(organismName).getClusters().stream().mapToInt(c -> c.getCells().size()).sum()));


        int countClusters = 0;
        for (Cluster cluster : organisms.get(organismName).getClusters()) {
            if(countClusters==0){
                sb.append("\n");
            }
            sb.append(String.format("----Cluster %s\n", cluster.getId()));

           List<Cell> orderedCells =  cluster.getCells().stream().sorted((c1,c2)->{
              int value1 = c1.getPositionRow();
              int value2 = c2.getPositionRow();
              if(value1 == value2){
                  value1 = c1.getPositionCol();
                  value2 = c2.getPositionCol();
                  return Integer.compare(value1, value2);
              }else {
                  return Integer.compare(value1,value2);
              }
           }).collect(Collectors.toList());

            int counter = 0;
            for (Cell cell : orderedCells) {
                sb.append(cell.toString());
                if (counter == orderedCells.size() - 1 && countClusters == organisms.get(organismName).getClusters().size() - 1) {
                } else {
                    sb.append("\n");
                }
                counter++;
            }
            countClusters++;
        }
        return sb.toString();
    }

    public String createOrganism(String name) {
        if (!organisms.containsKey(name)) {
            Organism organism = new Organism(name);
            this.organisms.put(name, organism);
            return String.format("Created organism %s", name);
        }
        return String.format("Organism %s already exists", name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (organisms.containsKey(organismName) && organisms.get(organismName).getClusters().stream().filter(c -> c.getId().equals(id)).count() == 0) {
            Cluster cluster = new Cluster(id, rows, cols);
            this.organisms.get(organismName).addCluster(cluster);
            return String.format("Organism %s: Created cluster %s", organismName, cluster.getId());
        }
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (organisms.containsKey(organismName) &&
                organisms.get(organismName).getClusters().stream().filter(c -> c.getId().equals(clusterId)).count() > 0 &&
                positionRow < organisms.get(organismName).getClusters()
                        .stream().filter(c -> c.getId().equals(clusterId)).findFirst().get().getRows() &&
                positionCol < organisms.get(organismName).getClusters()
                        .stream().filter(c -> c.getId().equals(clusterId)).findFirst().get().getCols()) {
            Cell cell = createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
            organisms.get(organismName).getClusters()
                    .stream().filter(c -> c.getId().equals(clusterId)).findFirst().get().addCell(cell);
            return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
        }
        return null;
    }

    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            Organism organism = this.organisms.get(organismName);
            organism.activateCluster();
            return String.format("Organism %s: Activated cluster %s. Cells left: %d",
                    organismName, organism.getClusters().get(organism.getClusters().size() - 1).getId(),
                    organism.getClusters().get(organism.getClusters().size() - 1).getCells().size());
        }
        return null;
    }

    private Cell createCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        Cell cell = null;
        switch (cellType) {
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }
        return cell;
    }


}
