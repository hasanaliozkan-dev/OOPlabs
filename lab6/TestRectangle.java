public class TestRectangle {
    public static void main(String[] args) {
       /// Point p = new Point(3,7);
        Rectangle r = new Rectangle(5,6, new Point(3,7));
        System.out.println("Area = "+ r.area());

        Point[] corners = r.corners();
        for (int i = 0;  i < corners.length; i++){
            System.out.println("x = "+ corners[i].xCoord + " y = "+ corners[i].yCoord);

        }

        Rectangle r2 = new Rectangle(7,9, new Point(3,10));
        System.out.println("Area = "+ r2.area());


        Rectangle r3 = new Rectangle(7,9, new Point(3,10));
        System.out.println("Perimeter = "+ r3.perimeter());

        r.topLeft.xCoord= 5;
    }
}
