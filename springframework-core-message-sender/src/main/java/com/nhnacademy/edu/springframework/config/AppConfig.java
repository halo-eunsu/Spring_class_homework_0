
package com.nhnacademy.edu.springframework.config;


import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.DoorayMessageSender;
import com.nhnacademy.edu.springframework.MessageSendService;
import com.nhnacademy.edu.springframework.MessageSender;
import com.nhnacademy.edu.springframework.aspectj.DoorayAspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:Dooray.properties")
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate, @Value("${propertyUrl}") String url) {
        return new DoorayHookSender(restTemplate, url);
    }

    @Bean
    public MessageSender messageSender(DoorayHookSender doorayHookSender) {
        return new DoorayMessageSender(doorayHookSender);
    }

    @Bean
    public MessageSendService sendService(MessageSender messageSender) {
        return new MessageSendService(messageSender);
    }

    @Bean
    public DoorayAspect doorayAspect() {
        return new DoorayAspect();
    }
}