package com.greenfox.model;

import javax.persistence.*;

/**
 * Created by ${SzilviaB} on 2016. 12. 20..
 */

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String title;
    public boolean isUrgent;
    public boolean isDone;

    @ManyToOne
    public User user;

    public Todo() {
    }

    public Todo(String title, boolean isUrgent, boolean isDone, User user) {
        this.title = title;
        this.isUrgent = isUrgent;
        this.isDone = isDone;
        this.user = user;
    }

    public Todo(String title) {
        this.title = title;
        this.isUrgent = false;
        this.isDone = false;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
