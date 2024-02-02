package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.web.client.RestTemplate;

public class Dooray implements MessageSender{

    @Override
    public boolean sendMessage(User user, String message) {
        try{
            new DoorayHookSender(new RestTemplate(), "${hookUrl}")
                    .send(DoorayHook.builder()
                            .botName("${작성자 이름}")
                            .text("${동료들에게 하고싶은말}")
                            .build());
            return true;
        }catch (Exception e){
            return  false;
        }

    }
}
