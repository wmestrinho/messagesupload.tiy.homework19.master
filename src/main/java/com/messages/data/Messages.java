package com.messages.data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by WagnerMestrinho on 2/9/17.
 */
@Entity
public class Messages {
    @Id
    @GeneratedValue
    private long id;
    private String content;
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    public Messages() {
    }

    public Messages(String content, Author author) {
        this.content = content;
        this.author = author;
        this.time = new Date();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
