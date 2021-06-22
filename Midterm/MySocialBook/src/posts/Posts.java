package posts;

import location.MyLocation;

import java.util.ArrayList;
import java.util.Date;

public abstract class Posts {
    /**CLASS ATTRIBUTES**/
    private MyLocation location = new MyLocation();
    private  ArrayList<String> taggedFriends = new ArrayList<>();
    private Date postDate;
    private String textContents;

    public Posts(String textContents,Double longitude,Double latitude, ArrayList<String> taggedFriends ) {
        this.location = new MyLocation(longitude,latitude);
        this.taggedFriends = taggedFriends;
        this.postDate = new Date();
        this.textContents = textContents;
    }

    public MyLocation getLocation() {
        return location;
    }

    public ArrayList<String> getTaggedFriends() {
        return taggedFriends;
    }

    public Date getPostDate() {
        return postDate;
    }

    public String getTextContents() {
        return textContents;
    }
}
