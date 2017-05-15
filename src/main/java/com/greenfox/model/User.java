package com.greenfox.model;

import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Szilvi on 2017. 05. 09..
 */
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    private List<Todo> todos;

    public String getName() {
        return name;
    }
}
