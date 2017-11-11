package _03Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter( 2 * this.height + 2 * this.width);
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.height*this.width);
    }
}
