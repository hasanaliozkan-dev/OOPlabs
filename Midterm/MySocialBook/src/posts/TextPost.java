package posts;

import java.util.ArrayList;
public class TextPost extends Posts{
    /**CONSTRUCTOR**/
    public TextPost(String textContents, Double longitude, Double latitude, ArrayList<String> taggedFriends) {
        super(textContents,longitude,latitude,taggedFriends);
    }
}
