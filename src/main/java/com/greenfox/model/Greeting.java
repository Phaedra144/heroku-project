package com.greenfox.model;

/**
 * Created by Szilvi on 2017. 05. 15..
 */
public class Greeting {

    static long counter = 1;
    long id;
    String content;

    public Greeting(String s) {
        this.id = counter++;
        this.content = s;
    }

    public static long getCounter() {
        return counter;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
