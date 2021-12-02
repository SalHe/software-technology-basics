public class PlainRect extends Rectangle {
    private final double x;
    private final double y;

    public PlainRect() {
        this(0, 0, 0, 0);
    }

    public PlainRect(double x, double y, double width, double height) {
        super(width, height);
        this.x = x;
        this.y = y;
    }

    public boolean isInside(double x, double y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }

    public static void main(String[] args) {
        PlainRect plainRect = new PlainRect(1, 1, 10, 15);
        System.out.println("面积：" + plainRect.area());
        System.out.println("周长：" + plainRect.perimeter());
        System.out.println("点(15.5，12.2)是否在矩形内？" + (plainRect.isInside(15.5, 12.2) ? "是" : "否"));
    }
}
