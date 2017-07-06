package P05;

/**
 * Created by Yana on 6/30/2017.
 */
public class Circle {
    private int radius;
    private Point center;

    public Circle(int radius, Point center){
        this.radius = radius;
        this.center = center;
    }

    public int getRadius() {
        return this.radius;
    }

    public Point getCenter() {
        return this.center;
    }
}
