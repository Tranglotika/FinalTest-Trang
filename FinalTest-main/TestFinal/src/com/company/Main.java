package com.company;

public class Main {

    public static void main(String[] args) {
        setUser();
        Controller.runApp();

    }

    public static void setUser() {
        Controller.test.addUser(new User("a", "trang1@gmail.com", "Password@123"));
        Controller.test.addUser(new User("b", "trang2@gmail.com", "Password@123"));
        Controller.test.addUser(new User("c", "trang3@gmail.com", "Password@123"));
        Controller.test.addUser(new User("d", "trang4@gmail.com", "Password@123"));
    }
}


