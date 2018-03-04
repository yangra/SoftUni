public class Area {
    private Point2D upLeftCorner;
    private double width;
    private double height;

    public Area(Point2D upLeftCorner, double width, double height) {
        this.upLeftCorner = upLeftCorner;
        this.width = width;
        this.height = height;
    }

    public Point2D getUpLeftCorner() {
        return upLeftCorner;
    }

    public void setUpLeftCorner(Point2D upLeftCorner) {
        this.upLeftCorner = upLeftCorner;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean hasInside(Point2D point) {
        if (point.getX() >= this.upLeftCorner.getX() &&
                point.getX() <= (this.upLeftCorner.getX() + this.width) &&
                point.getY() >= this.upLeftCorner.getY() &&
                point.getY() <= (this.upLeftCorner.getY() + this.height)) {
            return true;
        }

        return false;
    }

    public boolean intersects(Area other) {
        if (this.upLeftCorner.getX() <= (other.upLeftCorner.getX() + other.width) &&
                (this.upLeftCorner.getX() + this.width) >= other.upLeftCorner.getX() &&
                this.upLeftCorner.getY() <= (other.upLeftCorner.getY() + other.height) &&
                (this.upLeftCorner.getY() + this.height) >= other.upLeftCorner.getY()) {
            return true;
        }

        return false;
    }
}
