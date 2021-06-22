package location;
public class MyLocation {
    /**CLASS ATTRIBUTES**/
    private double longitude=0,latitude=0;
    /**CONSTRUCTORS**/
    public MyLocation() {
    }

    public MyLocation(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    /**GETTERS**/
    public double getLongitude() { return longitude; }

    public double getLatitude() { return latitude; }


}
