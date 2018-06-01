package com.example.tanvi.atharva2k18;

public class DetailsRegister {
    String id;
    String name;
    String email;

    public DetailsRegister(String id, String name, String email, String user, String pass, String college, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.user = user;
        this.pass = pass;
        this.college = college;
        this.mobile = mobile;
    }

    String user;
    String pass;
    String college;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getCollege() {
        return college;
    }

    public String getMobile() {
        return mobile;
    }

    String mobile;

    public String getId() {
        return id;
    }
}
