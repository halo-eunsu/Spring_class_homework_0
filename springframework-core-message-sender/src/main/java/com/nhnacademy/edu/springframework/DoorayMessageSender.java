package com.nhnacademy.edu.springframework;


import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:Dooray.properties")
public class DoorayMessageSender implements MessageSender {

    DoorayHookSender doorayHookSender;



    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @TimeLogging
    @Override
    public boolean sendMessage(User user, String message) {

            try {

                DoorayHook doorayHook = DoorayHook.builder()
                        .botName(user.getName())
                        .text(user.getMessage())
                        .build();

                doorayHookSender.send(doorayHook);

                return true;

            } catch (Exception e) {

                System.err.println("Failed to send message via Dooray: " + e.getMessage());
                return false;

            }

        }
    }