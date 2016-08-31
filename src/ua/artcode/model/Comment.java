package ua.artcode.model;

import java.util.Date;

/**
 * Created by serhii on 21.08.16.
 */
public class Comment {

    private long id;
    private String title;
    private String body;
    private User owner;
    private Date createdTime;

    // constructors --------------------------------------------------------------------------------
    public Comment(String title, String body, User owner, Date createdTime) {
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.createdTime = createdTime;
    }

    public Comment() {
    }

    // geters & seters -----------------------------------------------------------------------------
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
