package app.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }


    public void activate() {
        if (this.cells.size() < 2) {
            return;
        }

        Cell movingCell = null;
        Cell nextCell = null;
        Cell winner = null;
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                for (Cell cell : this.cells) {
                    if (movingCell == null && cell.getPositionRow() == row && cell.getPositionCol() == col) {
                        movingCell = cell;
                        continue;
                    }
                    if (cell.getPositionRow() == row && cell.getPositionCol() == col && movingCell != null ) {
                        nextCell = cell;
                    }
                    if (movingCell != null && nextCell != null) {
                        winner = movingCell.attack(nextCell);
                        break;
                    }

                }
                if (movingCell != null && winner != null && winner.equals(movingCell)) {
                    movingCell.setPositionRow(row);
                    movingCell.setPositionCol(col);
                    this.cells.remove(nextCell);
                    nextCell = null;
                    winner = null;
                } else if (movingCell != null && winner != null && winner.equals(nextCell)) {
                    this.cells.remove(movingCell);
                    movingCell = winner;
                    movingCell.setPositionRow(row);
                    movingCell.setPositionCol(col);
                    nextCell = null;
                    winner = null;
                }
                if (this.cells.size() == 1) {
                    break;
                }
            }
            if (this.cells.size() == 1) {
                break;
            }
        }

    }

}
