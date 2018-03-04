public class Cluster {
    private String name;
    private Point2D coords;

    public Cluster(String name, Point2D coords) {
        this.name = name;
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point2D getCoords() {
        return coords;
    }

    public void setCoords(Point2D coords) {
        this.coords = coords;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f, %.2f", name, coords.getX(), coords.getY());
    }
}
