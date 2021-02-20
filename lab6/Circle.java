public class Circle {
    int radius;
    Point center;

    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double area(){

        return Math.PI * radius* radius;

    }

    public double perimeter(){

        return  2*Math.PI * radius;

    }

    public boolean intersect (Circle c){
         return (radius + c.radius > center.distance(c.center));

    }
}
