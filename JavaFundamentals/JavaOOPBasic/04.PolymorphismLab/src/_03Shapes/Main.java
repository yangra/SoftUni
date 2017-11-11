package _03Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(12.5,1.6);
        Shape circle = new Circle(12.1);

        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        circle.calculateArea();
        circle.calculatePerimeter();

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
