package com.cloud.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JiaShun
 * @date 2018/3/27 20:58
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private Date crtTime;

    private Date updTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}