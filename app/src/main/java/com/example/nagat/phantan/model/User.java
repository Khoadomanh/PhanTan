package com.example.nagat.phantan.model;

/**
 * Created by nagat on 27/3/2018.
 */

public class User {
    private String idUser;
    private String userName;
    private String password;
    private String name;

    public User(String idUser, String userName, String password, String name) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    public String getIdUser() {

        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public User(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
