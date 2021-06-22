package main;

//Import packages

import posts.ImagePost;
import posts.Posts;
import posts.TextPost;
import posts.VideoPost;
import user.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class MySocialBook {
    /**
     * CLASS ATTRIBUTES
     **/
    public static ArrayList<User> userList = new ArrayList<>();
    public static User currentUser = null;
    public static int id = 1;
    public static String userFileName;
    public static String commandFileName;

    public static void main(String[] args) throws Exception {
        if (args.length == 2) {
            userFileName = args[0];
            commandFileName = args[1];
            loadUsers();
            readCommandsFromFile();
        } else if (args.length == 1) {
            userFileName = args[0];
            loadUsers();
            readCommandsFromInput();
        } else System.out.println("Please give me at least one file that includes the users.");

    }


    /**
     * This function first checks is there any user have logged in. If it is, it adds current user's video-posts. It creates a VideoPost object that inherit from Posts abstract class.
     * Then function calls current-user's addPost function with newly created VideoPost object.
     *
     * @param line whole command line that includes details of video-post.
     */
    private static void addVideoPost(String[] line) {
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 7) System.out.println("Error: Please enter valid number of information");
        else {
            int videoDuration = Integer.parseInt(line[6]);
            if (videoDuration <= VideoPost.getMaxLength()) {
                String textContents = line[1];
                Double longitude = Double.parseDouble(line[2]);
                Double latitude = Double.parseDouble(line[3]);
                ArrayList<String> taggedFriends = new ArrayList<>(Arrays.asList(line[4].split(":")));
                String videoFileName = line[5];
                Posts videoPost = new VideoPost(textContents, longitude, latitude, taggedFriends, videoFileName, videoDuration);
                currentUser.addPost(videoPost);
            } else System.out.println("Error: Your video exceeds maximum allowed duration of "
                    + VideoPost.getMaxLength() + " minutes.");
        }
    }

    /**
     * This function first checks is there any user have logged in. If it is, it adds current user's image-posts. It creates a ImagePost object that inherit from Posts abstract class.
     * Then function calls current-user's addPost function with newly created ImagePost object.
     *
     * @param line whole command line that includes details of image-post.
     */
    private static void addImagePost(String[] line) {
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 7) System.out.println("Error: Please enter valid number of information");
        else {
            String textContents = line[1];
            Double longitude = Double.parseDouble(line[2]);
            Double latitude = Double.parseDouble(line[3]);
            ArrayList<String> taggedFriends = new ArrayList<>(Arrays.asList(line[4].split(":")));
            String imageFileName = line[5];
            String[] resolution = line[6].split("x");

            Posts imagePost = new ImagePost(textContents, longitude, latitude, taggedFriends, imageFileName, resolution);


            currentUser.addPost(imagePost);
        }
    }

    /**
     * This function first checks is there any user have logged in. If it is, it adds current user's text-posts. It creates a TextPost object that inherit from Posts abstract class.
     * Then function calls current-user's addPost function with newly created TextPost object.
     *
     * @param line whole command line that includes details of text-post.
     */
    private static void addTextPost(String[] line) {
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 5) System.out.println("Error: Please enter valid number of argument");
        else {
            String textContents = line[1];
            Double longitude = Double.parseDouble(line[2]);
            Double latitude = Double.parseDouble(line[3]);
            ArrayList<String> taggedFriends = new ArrayList<>(Arrays.asList(line[4].split(":")));
            Posts textPost = new TextPost(textContents, longitude, latitude, taggedFriends);
            currentUser.addPost(textPost);
        }


    }

    /**
     * This function check is there any user have logged in.
     * If it is, it calls current-user's listAllUsers method.
     */
    private static void listUsers() {
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else currentUser.listAllUsers(userList);
    }

    /**
     * This function check is there any user have logged in.
     * If it is, it calls current-user's listFriends method.
     */
    private static void listFriends() {
        if (currentUser == null) System.out.println("Please sign in and try again.");
        else currentUser.listFriends();
    }

    /**
     * This function check is there any user have logged in.
     * If it is, it calls current-user's listBlockedFriends method.
     */
    private static void showBlockedFriends() {
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else currentUser.listBlockedFriends();

    }

    /**
     * This function check is there any user have logged in.
     * If it is, it calls current-user's listBlockedUsers method.
     */
    private static void showBlockedUsers() {
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else currentUser.listBlockedUsers();

    }

    /**
     * This function first checks is there any user have logged in. If it is, it checks
     * is there any user in userList to unblock if it is also okey then call current-user
     * unBlockUsers method.
     *
     * @param line whole command line containing the username of the user to be unblocked.
     */
    private static void unBlockUser(String[] line) {
        boolean flag = false;
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 2) System.out.println("Error: Please give me a name to unblock");
        else {
            String unblockedUser = line[1];

            for (User user : userList) {
                if (user.getUserName().equals(unblockedUser)) {
                    flag = true;
                    currentUser.unBlockUsers(user);
                    break;
                }

            }
        }
        if (!flag) System.out.println("No such user!");


    }

    /**
     * This function first checks is there any user have logged in. If it is, it checks
     * is there any user in userList to block if it is also okey then call current-user
     * blockUsers method.
     *
     * @param line whole command line containing the username of the user to be blocked.
     */
    private static void blockUser(String[] line) {
        boolean flag = false;

        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 2) System.out.println("Error: Please give me a name to block");
        else {
            String blockedUser = line[1];
            for (User user : userList) {
                if (user.getUserName().equals(blockedUser)) {
                    currentUser.blockUsers(user);
                    flag = true;
                    break;
                }

            }
        }
        if (!flag) System.out.println("No such user!");

    }

    /**
     * This function first checks is there any user have logged in. If it is, it checks
     * is there any user in userList to remove if it is also okey then call current-user
     * removeFriend method.
     *
     * @param line whole command line containing the username of the friend to be removed.
     */

    private static void removeFriend(String[] line) {

        boolean flag = false;
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 2) System.out.println("Error: Please give me a  name to remove");
        else {
            String friendName = line[1];
            for (User user : userList) {
                if (user.getUserName().equals(friendName)) {
                    flag = true;
                    currentUser.removeFriend(user);
                    break;
                }
            }
        }

        if (!flag) System.out.println("No such user!");
    }

    /**
     * This function first checks is there any user have logged in. If it is, it checks
     * is there any user in userList to add if it is also okey then it calls current-user
     * addFriend method.
     *
     * @param line whole command line containing the username of the friend to be added.
     */

    private static void addFriend(String[] line) {
        boolean flag = false;
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 2) System.out.println("Error: Please give me a name to add");
        else {
            String userName = line[1];
            for (User user : userList) {
                if (user.getUserName().equals(userName)) {
                    flag = true;
                    currentUser.addFriend(user);
                    break;
                }
            }

        }
        if (!flag) System.out.println("No such user!");

    }

    /**
     * This function first checks is there any user have logged in. If it is, it calls current-user
     * changePassword method.
     *
     * @param line whole command line containing the oldPassword and newPassword.
     */

    private static void changePassword(String[] line) {

        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 3) System.out.println("Error: Please enter valid number of argument.");
        else {
            String oldPass = line[1];
            String newPass = line[2];
            currentUser.changePassword(oldPass, newPass);
        }

    }

    /**
     * This function first checks is there any user have logged in. If it is, it calls current-user
     * updateProfile method.
     *
     * @param line whole command line containing the new details of account.
     */

    private static void updateProfile(String[] line) {

        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else if (line.length != 4) System.out.println("Error: Please enter valid number of argument.");
        else {
            String newName = line[1];
            String newDate = line[2];
            String newSchool = line[3];
            currentUser.updateProfile(newName, newDate, newSchool);
        }
    }

    /**
     * This function show all posts of current-user if it is exist. Otherwise it prints error messages.
     *
     * @param line whole command line containing the userName to be showed the posts.
     */

    private static void showPosts(String[] line) {
        boolean flag = false;
        String userName = line[1];
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                flag = true;
                if (!(user.getPosts().isEmpty())) {
                    System.out.println("**************");
                    System.out.println(user.getName() + "'s Posts");
                    System.out.println("**************");

                    for (Posts post : user.getPosts()) {
                        System.out.println(post.getTextContents());
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                        String date = simpleDateFormat.format(post.getPostDate());
                        System.out.println("Date: " + date);
                        System.out.println("Location: " + post.getLocation().getLongitude() + " " + post.getLocation().getLatitude());

                        if (post.getTaggedFriends().size() != 0)
                            System.out.println("Tagged Friends: " + Arrays.toString(post.getTaggedFriends().toArray()).
                                    replace("[", "").replace("]", ""));
                        if(post instanceof ImagePost){
                            System.out.println("Image: " +((ImagePost) post).getImageFileName());
                            System.out.println("Resolution: " + ((ImagePost) post).getResolution()[0]+"x"+((ImagePost) post).getResolution()[1] +" px.");
                        }
                        else if (post instanceof VideoPost){
                            System.out.println("Video: " + ((VideoPost) post).getVideoFileName());
                            System.out.println("Duration: " + ((VideoPost) post).getDuration() + " minutes.");
                        }
                        System.out.println("----------------------------");
                    }
                } else {
                    System.out.println(userName + " does not have any posts yet.");
                }
            }
        }
        if (!flag) System.out.println("No such user!");
    }

    /**
     * This function checks is there any user to signIn in the userList. If it is, it calls user's signIn methods.
     * And sets to current-user this user.
     *
     * @param line whole command-line containing user-name and password of user.
     */
    private static void signIn(String[] line) {
        boolean flag = false;
        if (line.length != 3) System.out.println("Error: Please enter valid number of argument");
        else {


            String userName = line[1];
            String password = line[2];
            for (User user : userList) {
                if (user.getUserName().equals(userName)) {
                    flag = true;
                    currentUser = user.signIn(userName, password);
                    break;
                }
            }
            if (!flag) System.out.println("No such user!");
        }

    }

    /**
     * This function checks is there any user to remove. If it is, it removes the user from the system.
     * If all users removed it prints error message.
     *
     * @param line
     */
    private static void removeUser(String[] line) {
        if (line.length != 2) System.out.println("Error: Please enter valid number of argument");
        else {
            int userId = Integer.parseInt(line[1]);
            boolean flag = false;

            if (!(userList.isEmpty())) {
                for (User user : userList) {
                    if (user.getUserID() == userId) {
                        userList.remove(user);
                        user.setRemoved(true);
                        flag = true;
                        break;
                    }
                }
                if(currentUser!=null  && currentUser.isRemoved()){
                    currentUser = null;
                    System.out.println("Current user was removed from the system!");
                }
                System.out.println(flag ? "User has been successfully removed." : "No such user!");

            }else {

                System.out.println("There is no user in the system");
            }
        }

    }

    /**
     * This function checks is there any user logged in
     * then calls the removePost method of the current-user.
     */
    private static void removePost() {
        if (currentUser == null) System.out.println("Error: Please sign in and try again.");
        else currentUser.removePost();
    }

    /**
     * This function adds new user to the system.
     *
     * @param line whole command-line that includes all account's info of new user.
     */
    private static void addUser(String[] line) {
       boolean flag =true;
        if(line.length !=6) System.out.println("Error: Please enter valid number of argument");
        else {
            int userID = id++;
            String name = line[1];
            String userName = line[2];
            String password = line[3];

            Date dateOfBirth = new Date(line[4]);
            String school = line[5];
            User newUser = new User(userID, name, userName, school, password, dateOfBirth);
            for (User user : userList) {
                if (user.getUserName().equals(userName)) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                userList.add(newUser);
                System.out.println(line[1] + " has been successfully added.");
            }else {
                System.out.println("Error: This userName taking before please try another.");
                id--;
            }
        }
    }

    /**
     * This function loads all users in the users.txt file.
     */
    public static void loadUsers() {
        File file = new File(userFileName);
        Scanner fileReader = null;
        //Check is there any file.
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("There is no file!!!\nPlease give me a file.");
        }
        //If file exists read and load users.
        if (fileReader != null) {
            boolean flag = true;
            while (fileReader.hasNextLine()) {
                String[] line = fileReader.nextLine().split("\t");
                int userID = id++;
                String name = line[0];
                String userName = line[1];
                String password = line[2];
                Date dateOfBirth = new Date(line[3]);
                String school = line[4];
                User newUser = new User(userID, name, userName, school, password, dateOfBirth);
                for (User user : userList) {
                    if (user.getUserName().equals(userName)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) userList.add(newUser);
                else {
                    System.out.println("Error while load users: This userName taking before please try another.");
                    id--;
                        }
            }
            }
            fileReader.close();
        }


    public static void readCommandsFromFile() {
        File file = new File(commandFileName);
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("There is no file!!!\nPlease give me a file.");
        }

        if (fileReader != null) {
            while (fileReader.hasNextLine()) {
                String[] line = fileReader.nextLine().trim().split("\t");

                String command = line[0].toUpperCase();
                System.out.println("------------------------");
                //Print the whole command-line as output.
                System.out.println("COMMAND: " +
                        Arrays.toString(line).replace("[", "")
                                .replace("]", "").replace(",", "\t"));
                //Evaluate the command.
                switch (command) {
                    case "ADDUSER":
                        addUser(line);
                        break;
                    case "REMOVEUSER":
                        removeUser(line);
                        break;
                    case "SHOWPOSTS":
                        showPosts(line);
                        break;
                    case "SIGNIN":
                        signIn(line);
                        break;
                    case "SIGNOUT":
                        if (currentUser == null){
                            System.out.println("Error: There is no user to signed out.");
                        }else {
                            currentUser.signOut();
                            currentUser = null;
                        }
                        break;
                    case "UPDATEPROFILE":
                        updateProfile(line);
                        break;
                    case "CHPASS":
                        changePassword(line);
                        break;
                    case "ADDFRIEND":
                        addFriend(line);
                        break;
                    case "REMOVEFRIEND":
                        removeFriend(line);
                        break;
                    case "BLOCK":
                        blockUser(line);
                        break;
                    case "UNBLOCK":
                        unBlockUser(line);
                        break;
                    case "LISTFRIENDS":
                        listFriends();
                        break;
                    case "LISTUSERS":
                        listUsers();
                        break;
                    case "SHOWBLOCKEDFRIENDS":
                        showBlockedFriends();
                        break;
                    case "SHOWBLOCKEDUSERS":
                        showBlockedUsers();
                        break;
                    case "ADDPOST-TEXT":
                        addTextPost(line);
                        break;
                    case "ADDPOST-IMAGE":
                        addImagePost(line);
                        break;
                    case "ADDPOST-VIDEO":
                        addVideoPost(line);
                        break;
                    case "REMOVELASTPOST":
                        removePost();
                        break;
                    default:
                        System.out.println("Error: This command not found!!!");
                }
            }
            fileReader.close();
        }


    }


    private static void readCommandsFromInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("If you want to exit please write QUIT");
            System.out.print("Please enter your command tab seperated:");
            String[] line = scanner.nextLine().trim().split("\t");
            String command = line[0].toUpperCase();
            if (command.equals("QUIT")){
                System.out.println("GOOD BYE");
                scanner.close();
            }
            else {
                System.out.println("------------------------");
                //Print the whole command-line as output.
                System.out.println("COMMAND: " +
                        Arrays.toString(line).replace("[", "")
                                .replace("]", "").replace(",", "\t"));
            }
            //Evaluate the command.
            switch (command) {
                case "QUIT":
                    scanner.close();
                    return;
                case "ADDUSER":
                    addUser(line);
                    break;
                case "REMOVEUSER":
                    removeUser(line);
                    break;
                case "SHOWPOSTS":
                    showPosts(line);
                    break;
                case "SIGNIN":
                    signIn(line);
                    break;
                case "SIGNOUT":
                    if (currentUser == null){
                        System.out.println("Error: There is no user to signed out.");
                    }else {
                        currentUser.signOut();
                        currentUser = null;
                    }
                    break;
                case "UPDATEPROFILE":
                    updateProfile(line);
                    break;
                case "CHPASS":
                    changePassword(line);
                    break;
                case "ADDFRIEND":
                    addFriend(line);
                    break;
                case "REMOVEFRIEND":
                    removeFriend(line);
                    break;
                case "BLOCK":
                    blockUser(line);
                    break;
                case "UNBLOCK":
                    unBlockUser(line);
                    break;
                case "LISTFRIENDS":
                    listFriends();
                    break;
                case "LISTUSERS":
                    listUsers();
                    break;
                case "SHOWBLOCKEDFRIENDS":
                    showBlockedFriends();
                    break;
                case "SHOWBLOCKEDUSERS":
                    showBlockedUsers();
                    break;
                case "ADDPOST-TEXT":
                    addTextPost(line);
                    break;
                case "ADDPOST-IMAGE":
                    addImagePost(line);
                    break;
                case "ADDPOST-VIDEO":
                    addVideoPost(line);
                    break;
                case "REMOVELASTPOST":
                    removePost();
                    break;
                default:
                    System.out.println("This command not found!!!");
                    System.out.println("Please enter a command from this list with tab separated\n" +
                            "[ ADDUSER , REMOVEUSER , SHOWPOSTS , SIGNIN , SIGNOUT , UPDATEPROFILE , CHPASS ," +
                            " ADDFRIEND , REMOVEFRIEND , BLOCK , UNBLOCK ,\nLISTFRIENDS , LISTUSERS ," +
                            "SHOWBLOCKEDFRIENDS , SHOWBLOCKEDUSERS , ADDPOST-TEXT , ADDPOST-IMAGE ," +
                            " ADDPOST-VIDEO , REMOVELASTPOST ]");

            }

        }
    }
}


