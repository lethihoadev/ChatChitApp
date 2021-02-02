package com.example.chatchit.model;
public class User {
    private String id, nickName, avatar, status;
    public User() {
    }
    public User(String id, String nickName, String avatar, String status) {
        this.id = id;
        this.nickName = nickName;
        this.avatar = avatar;
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
