package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");


        User user = new User("정은수", "");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSendService messageSendService = (MessageSendService) context.getBean("sendService");


            messageSendService.doSendMessage(user, "안녕하세요");






    }





}
}