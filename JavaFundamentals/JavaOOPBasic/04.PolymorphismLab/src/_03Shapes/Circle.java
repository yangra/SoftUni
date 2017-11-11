package _03Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    public final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2*Math.PI*this.radius);
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI*Math.pow(this.radius,2));
    }
}
