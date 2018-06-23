package com.cloud.auth.server.util.user;

import java.io.Serializable;

/**
 * @author JiaShun
 * @date 2018/3/29 09:50
 */
public class UserAuthResponse implements Serializable{
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public UserAuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
