package LLD.relationships.association.socialnetwork;

import java.time.LocalDate;

public class Message {
    private User author;
    private String content;
    private String timeStamp;

    public Message(User author, String content, String timeStamp) {
        this.author = author;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
