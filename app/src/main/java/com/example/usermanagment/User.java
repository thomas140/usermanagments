package com.example.usermanagment;

public class User  {
    String fullname;
    String email;
    String password;
    String phone;
    String username;
    String gender;

    public User() {
    }

    public User(String fullname, String email, String password, String phone, String username, String gender) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
