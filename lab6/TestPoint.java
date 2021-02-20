public class TestPoint {

    public static void main(String[] args) {

        Point p1 = new Point(3,2);
        String str = new String("hello");
        System.out.println("x = "+ p1.xCoord +" y = "+ p1.yCoord);

        Point p2 = new Point(6);
        System.out.println("xy = "+ p2.xCoord );

        Point p3 = new Point();
        System.out.println("x = "+ p3.xCoord +" y = "+ p3.yCoord);

        System.out.println("distance p1 and p2 = " + p1.distance(p2));


    }
}
