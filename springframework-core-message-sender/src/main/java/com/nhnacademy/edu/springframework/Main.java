package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            User user = new User("정은수", "");
            MessageSendService messageSendService = context.getBean(MessageSendService.class);

            messageSendService.doSendMessage(user, "안녕하세요");
        }
    }
}