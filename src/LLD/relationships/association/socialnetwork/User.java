package LLD.relationships.association.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> followers = new ArrayList<>();
    private List<User> following = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
    public void follow(User user){
        following.add(user);
        user.followers.add(this);
    }

    public List<Message> getMessages() {
        return messages;
    }
    public void sendMessage(String content, String timeStamp){
        Message message = new Message(this, content, timeStamp);
        messages.add(message);
    }

    public String getName() {
        return name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowing() {
        return following;
    }
}
