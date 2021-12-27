package com.company;

import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private String pass;
    private final ArrayList<User> UserList = new ArrayList<>();

    public User(String name, String email, String pass) {
        this.username = name;
        setEmail(email);
        setPass(pass);
    }

    public User() {
    }

    public void addUser(User newUser) {
        UserList.add(newUser);
    }

    public boolean checkValidUser(String toCheckID){
        for (User i: UserList){
            if (i.getUsername().toLowerCase().equals(toCheckID.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    public ArrayList<User> getUserList() {
        return UserList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!CheckEmail.isEmailValid(email))
            throw new IllegalArgumentException("Email sai định dạng");
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        if (!CheckPass.isPassValid(pass))
            throw new IllegalArgumentException("Password sai định dạng");
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
