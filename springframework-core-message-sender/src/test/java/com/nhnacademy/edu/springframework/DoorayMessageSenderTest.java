package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DoorayMessageSenderTest {

    @Test
    public void sendMessageTest() {

        String userName = "User";
        String message = "Message";


        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);


        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSender);


        boolean result = doorayMessageSender.sendMessage(new User(userName, message), message);


        assertTrue(result);
        verify(doorayHookSender, times(1)).send(any(DoorayHook.class));
    }

}
