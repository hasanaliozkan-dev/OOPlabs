public class TestCircle
{
    public static void main(String[] args) {
        Circle c = new Circle(5, new Point(6,7));
        System.out.println("Area = " + c.area());
        System.out.println("Perimeter = "+ c.perimeter());

        Circle c2 = new Circle(5, new Point(0,0));
        System.out.println(c.intersect(c2));
    }
}
