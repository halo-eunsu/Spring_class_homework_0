package com.nhnacademy.edu.springframework;


import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:Dooray.properties")
public class DoorayMessageSender implements MessageSender {

    @Value("${propertyUrl}")
    public String url;


    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
    }

    @TimeLogging
    @Override
    public boolean sendMessage(User user, String message) {

            try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

                DoorayHookSender doorayHookSender = (DoorayHookSender) context.getBean("messageSender");
                RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");

                new DoorayHookSender(new RestTemplate(), url)
                        .send(DoorayHook.builder()
                                .botName(user.getName())
                                .text(user.getMessage())
                                .build());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }
    }