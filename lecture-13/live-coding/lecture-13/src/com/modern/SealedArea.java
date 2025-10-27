package modern;

sealed interface Shape permits Circle, Rect {}
record Circle(double r) implements Shape {

}
record Rect(double l, double w) implements Shape {

}
public class SealedArea {
    public static double area(Shape shape) {
        if(shape instanceof Circle c) {
            // Pi * r^2
            return Math.PI * c.r() * c.r();
        }
        if(shape instanceof Rect r) {
            return r.l() * r.w();
        }
        throw new IllegalArgumentException("Unknown type");
    }

    public static void main(String[] args) {
        System.out.println(area(new Circle(2)));
        System.out.println(area(new Rect(2, 5)));
    }
}
