package com.projectreference.reference.Model;

public class AuthenticationResponse {

    String jwt;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
