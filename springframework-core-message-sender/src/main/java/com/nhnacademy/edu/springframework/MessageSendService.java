package com.nhnacademy.edu.springframework;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageSendService {
    private MessageSender messageSender;
    private String phoneNumber;





    @Autowired
    public MessageSendService( MessageSender messageSender, @Value("${phoneNumber}") String phoneNumber) {


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