package com.nhnacademy.edu.springframework;

import org.aspectj.bridge.Message;

public class MessageSendService {
    private MessageSender messageSender;

    private String phoneNumber = "";

    public MessageSendService( MessageSender messageSender, String phoneNumber) {

        this.messageSender = messageSender;
        this.phoneNumber = phoneNumber;
    }

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doSendMessage(User user, String message) {

        String mockMessage = "";
        user.setMessage(message);
        messageSender.sendMessage(user, mockMessage);
    }
}