package com.example.tanvi.atharva2k18;

public class DetailsAcco {
    String id;
    String name;

    public DetailsAcco(String id, String name, String college, String mobile, String email, String date) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.mobile = mobile;
        this.email = email;
        this.date = date;
    }

    String college;
    String mobile;
    String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    String date;
}
