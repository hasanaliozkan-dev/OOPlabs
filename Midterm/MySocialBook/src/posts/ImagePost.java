package posts;

import java.util.ArrayList;

public class ImagePost extends TextPost{
    /**CLASS ATTRIBUTES**/
    private  String imageFileName;
    private  String[] resolution;
    /**CONSTRUCTOR**/
    public ImagePost(String textContents, Double longitude,
                     Double latitude, ArrayList<String> taggedFriends,
                     String imageFileName,String[] resolution){
        super(textContents,longitude,latitude,taggedFriends);
        this.imageFileName = imageFileName;
        this.resolution = resolution;
    }
    /**GETTERS?**/
    public String getImageFileName() {
        return imageFileName;
    }

    public String[] getResolution() {
        return resolution;
    }
}
