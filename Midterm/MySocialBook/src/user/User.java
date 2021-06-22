package user;

import posts.Posts;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class User {
    /**CLASS ATTRIBUTES**/
    private int userID; //Starts from 1 and it is unique.
    private String name; // Name of the user.
            private String userName; //username it is also unique.
            private String school;   //school of the user.
    private String password; //password of the account.
    private Date dateOfBirth,  //User's birth-date.
            lastLogin; //User's last-login date.
    private ArrayList<User> friends = new ArrayList<>(); //User's friends.
    private ArrayList<User> blockedUsers = new ArrayList<>(); //User's block-list.
    private LinkedList<Posts> posts = new LinkedList<>(); //User's posts.
    private boolean isRemoved = false;
    private boolean isBlocked = false;

    /**CONSTRUCTOR**/
    public User(int userID, String name, String userName, String school,
                String password, Date dateOfBirth) {
        this.userID = userID;
        this.name = name;
        this.userName = userName;
        this.school = school;
        this.password = password;
        this.dateOfBirth = dateOfBirth;

    }
    /** GETTERS **/
    public String getName() { return name; }

    public LinkedList<Posts> getPosts() { return posts; }

    public String getUserName() { return userName; }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public int getUserID() { return userID; }

    public String getPassword() { return password; }

    public String getSchool() { return school; }

    public Date getDateOfBirth() { return dateOfBirth; }

    public ArrayList<User> getBlockedUsers() { return blockedUsers; }

    /** SETTERS **/

    public void setPosts(LinkedList<Posts> posts) { this.posts = posts; }

    public void setBlockedUsers(ArrayList<User> blockedUsers) { this.blockedUsers = blockedUsers; }

    private void setUserID(int userID) { this.userID = userID; }

    private void setPassword(String password) { this.password = password; }


    /**
     *This method checks the account information. Allows the user to log in if they are all correct.
     * @param userName  that is unique.
     * @param password
     * @return the user to log in.
     */
    public User signIn(String userName, String password) {
        if (this.getPassword().equals(password)) {
            System.out.println("You have successfully signed in.");
            return this;
        } else {
            System.out.println("Invalid username or password! Please try again.");
            return null;
        }
    }

    /**
     * This method simply log out the current user.
     */
    public void signOut() {
        System.out.println("You have successfully signed out.");

    }

    /**
     * This method  updates current user profile.
     * @param newName name to be added.
     * @param newDate birthdate to be added.
     * @param newSchool school name to be added.
     */
    public void updateProfile(String newName, String newDate, String newSchool) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.name = newName;
        this.dateOfBirth = new Date(newDate);
        this.school = newSchool;
        System.out.println("Your user profile has been successfully updated.");
    }

    /**
     * This method first checks the user old password is true. If it is,it simply change the password.
     * @param oldPass will be changed.
     * @param newPass will be the  password.
     */
    public void changePassword(String oldPass, String newPass) {
        if (this.getPassword().equals(oldPass)) {
            this.setPassword(newPass);
        } else {
            System.out.println("Password mismatch!");
        }
    }

    /**
     * This method first check whether the friend is in current user friend list or not.
     * If it is in the list then just print message. Otherwise add friend to current user friend list.
     * @param friend to be added.
     */
    public void addFriend(User friend) {
        boolean flag = false;

        if(isMyFriend(friend.getUserName()))  System.out.println("This user is already in your friend list!");
        else {
            if (!friend.isBlocked){
            System.out.println(friend.userName + " has been successfully added to your friend list.");
            this.friends.add(friend);
            }
        }
    }

    /**
     * This method first check whether the friend is in current user friend list or not.
     * If it is not in the list then just print message. Otherwise remove friend to current user friend list.
     * @param friend to be removed.
     */
    public void removeFriend(User friend) {
        boolean flag = false;
        for (User myFriend : friends) {
            if (myFriend.userID == friend.userID) {
                this.friends.remove(friend);
                System.out.println(friend.userName + " has been successfully removed from your friend list.");
                flag = true;
                break;
            }
        }
        if (!flag) System.out.println("No such friend!");
    }

    /**
     * This method add user posts at the same time checks tagged friends is really friends of user.
     * @param post to be added.
     */
    public void addPost(Posts post) {
        int length = post.getTaggedFriends().size();

        if (length == 0){
            this.posts.add(post);
            System.out.println("The post has been successfully added.");
        }
        else {

            for (int i = 0; i <length; i++) {
                if(!isMyFriend(post.getTaggedFriends().get(i))){
                    System.out.println( post.getTaggedFriends().get(i) + " is not your friend, and will not be tagged!");
                    post.getTaggedFriends().remove(post.getTaggedFriends().get(i));
                    length--;

                }
            }
            this.posts.add(post);
            System.out.println("The post has been successfully added.");
        }


    }

    /**
     * This method checks the taggedFriend is current user friends or not.
     * @param friendName to be checked.
     * @return true if it is friend of current user.
     */
    private boolean isMyFriend(String friendName){
        for (User myFriend: friends)
            if (myFriend.userName.equals(friendName))
               return true;
        return false;
    }

    /**
     * This method simply remove the last post of the user if any exist.
     */
    public void removePost() {
        if (this.posts.isEmpty()) System.out.println("Error: You do not have any post.");
        else{
            this.posts.removeLast();
            System.out.println("Your last post has been successfully removed.");
        }

    }

    /**
     * This method block the users.
     * @param user to be blocked.
     */
    public void blockUsers(User user) {
        System.out.println(user.userName + " has been successfully blocked.");
        this.blockedUsers.add(user);
        user.isBlocked= true;

    }
    /**
     * This method unblock the users.
     * @param user to be unblocked.
     */
    public void unBlockUsers(User user) {
        boolean flag = false;
        for (User blockedUser : this.blockedUsers) {
            if (blockedUser.userID == user.userID) {
                flag = true;
                System.out.println(user.userName + " has been successfully unblocked.");
                this.blockedUsers.remove(user);
                break;
            }
        }
        if (!flag) System.out.println("No such user in your blocked-user list!");
    }

    /**
     * This methods list all of current user's friends if any exist.
     */
    public void listFriends(){
        boolean flag = false;
        if (this.friends.isEmpty()) System.out.println("You have not added any friend yet!");
        else {
            for (User friend : friends) {
                if(!friend.isRemoved && !friend.isBlocked){
                    flag = true;
                System.out.println("Name: " + friend.name);
                System.out.println("UserName: " +friend.userName);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = simpleDateFormat.format(friend.dateOfBirth);
                System.out.println("Date of Birth: " +date);
                System.out.println("School: " + friend.school);
                System.out.println("----------------------------");

                }
            }
            if(!flag) System.out.println("Your all friends are blocked or " +
                    "removed from the system so there is no friend in your friend list.");
        }

    }

    /**
     * This method list all users in the system.
     * @param userList userList to be printed.
     */
    public void listAllUsers(ArrayList<User> userList) {
        for (User user : userList) {
            if(!user.isRemoved){
            System.out.println("Name: " + user.name);
            System.out.println("UserName: " +user.userName);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String date = simpleDateFormat.format(user.dateOfBirth);
            System.out.println("Date of Birth: " +date);
            System.out.println("School: " + user.school);
            System.out.println("----------------------------");
            }
        }

    }

    /**
     * This method lists all blocked friends of current user if any exist.
     */

    public void listBlockedFriends() {
        boolean flag = false;
        for (User blockedUser: blockedUsers) {
            for (User blockedFriend: friends) {
                if (blockedFriend.userID == blockedUser.userID && !(blockedFriend.isRemoved)){
                    flag = true;
                    System.out.println("Name: " + blockedFriend.name);
                    System.out.println("UserName: " +blockedFriend.userName);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    String date = simpleDateFormat.format(blockedFriend.dateOfBirth);
                    System.out.println("Date of Birth: " +date);
                    System.out.println("School: " + blockedFriend.school);
                    System.out.println("----------------------------");
                }
            }


        }
        if(!flag) System.out.println("You haven’t blocked any friend yet!");


    }
    /**
     * This method lists all blocked users of current user if any exist.
     */

    public void listBlockedUsers() {
        if (this.blockedUsers.isEmpty()) System.out.println("You haven’t blocked any user yet!");

        for (User user: blockedUsers) {
            if(!user.isRemoved) {
                System.out.println("Name: " + user.name);
                System.out.println("UserName: " + user.userName);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = simpleDateFormat.format(user.dateOfBirth);
                System.out.println("Date of Birth: " + date);
                System.out.println("School: " + user.school);
                System.out.println("----------------------------");
            }
        }

    }


}
