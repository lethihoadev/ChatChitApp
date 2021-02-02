package com.example.chatchit.model;

public class Chat {
    private String senderId, receiverId, message;
    private boolean isSeen;

    public Chat(String senderId, String receiverId, String message, boolean isSeen) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.isSeen = isSeen;
    }

    public Chat() {
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsSeen() {
        return isSeen;
    }

    public void setIsSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }
}
