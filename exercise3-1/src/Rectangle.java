public class Rectangle {

    protected final double width;
    protected final double height;

    public Rectangle() {
        this(10, 10);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

}
