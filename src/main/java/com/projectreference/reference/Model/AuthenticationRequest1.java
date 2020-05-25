package com.projectreference.reference.Model;

public class AuthenticationRequest1 {

    String userName;
    String password;

    public AuthenticationRequest1() {
    }

    public AuthenticationRequest1(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
}
