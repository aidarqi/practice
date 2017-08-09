package com.aidar.transient_test;

import java.io.Serializable;

/**
 * @desc
 * @date 17-7-7
 */
class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    public static String username;
    private transient String passwd;
    private  String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
