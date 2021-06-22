package posts;

import java.util.ArrayList;
public class VideoPost extends TextPost {
    /**CLASS ATTRIBUTES**/
    private  final static int MAX_LENGTH = 10;
    private  String videoFileName;
    private  double duration;
    /**CONSTRUCTOR**/
    public VideoPost(String textContents, Double longitude, Double latitude, ArrayList<String> taggedFriends,String videoFileName, int duration) {
        super(textContents,longitude,latitude,taggedFriends);
        this.videoFileName = videoFileName;
        this.duration = duration;
    }
    /**GETTERS**/
    public static int getMaxLength() { return MAX_LENGTH; }

    public String getVideoFileName() {
        return videoFileName;
    }

    public double getDuration() {
        return duration;
    }
}
