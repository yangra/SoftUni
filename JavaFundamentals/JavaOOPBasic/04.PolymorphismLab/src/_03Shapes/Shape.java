package _03Shapes;

abstract class Shape {

    private  double perimeter;
    private double area;

    public double getPerimeter() {
        return this.perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    protected  abstract void calculatePerimeter();
    protected  abstract void calculateArea();
}
