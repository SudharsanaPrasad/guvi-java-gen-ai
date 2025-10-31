package com.activity.two;

public class EmailNotification extends Notification {

    public EmailNotification() {
        super(Channel.EMAIL);
    }

    @Override
    public void send(String msg) {
        System.out.println("Email: " + msg);
    }
}

