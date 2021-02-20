public class Point {
    int xCoord;
    int yCoord;



    public Point(){

    }

    public Point(int x, int y){
        xCoord = x;
        yCoord = y;
    }

    public Point(int xy){
        xCoord = xy;
        yCoord = xy;
    }


    public double distance(Point p){
        return Math.sqrt(Math.pow((xCoord - p.xCoord),2)+Math.pow((yCoord-p.yCoord),2));
    }


}
