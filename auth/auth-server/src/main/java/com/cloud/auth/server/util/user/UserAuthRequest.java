package com.cloud.auth.server.util.user;

import java.io.Serializable;

/**
 * @author JiaShun
 * @date 2018/3/29 09:48
 */
public class UserAuthRequest implements Serializable{
    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;

    public UserAuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
