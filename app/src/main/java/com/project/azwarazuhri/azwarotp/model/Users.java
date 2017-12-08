package com.project.azwarazuhri.azwarotp.model;

/**
 * Created by azwarazuhri on 12/7/17.
 */

public class Users {
    private String username;
    private String pasword;
    private String msisdn;

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
