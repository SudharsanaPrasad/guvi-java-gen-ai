package com.activity.two;

public class Notification {
    // "EMAIL", "SMS", "PUSH"
    private Channel type;
    // "abc"
    public Notification() {
        this.type = Channel.PUSH;
    }

    public Notification(Channel type) {
        this.type = type;
    }

    public void send(String msg){
        System.out.println("Sending: " + msg);
    }

    public Channel getType() {
        return type;
    }
}

