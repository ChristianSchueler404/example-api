package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="users")
@SequenceGenerator(name="seq_user", initialValue = 100, allocationSize = 1)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private int id;

    private String name;

    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
