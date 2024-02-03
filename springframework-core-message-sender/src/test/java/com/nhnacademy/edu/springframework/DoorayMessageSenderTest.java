package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DoorayMessageSenderTest {

    @Test
    public void testSendMessageSuccess() {
        // Arrange
        String userName = "TestUser";
        String message = "TestMessage";

        // Mock DoorayHookSender
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);

        // Create an instance of DoorayMessageSender and inject the mock DoorayHookSender
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSender);

        // Act
        boolean result = doorayMessageSender.sendMessage(new User(userName, message), message);

        // Assert
        assertTrue(result); // Check if sendMessage returns true on success
        verify(doorayHookSender, times(1)).send(any(DoorayHook.class)); // Verify that send method was called once
    }

    @Test
    public void testSendMessageFailure() {
        // Arrange
        String userName = "TestUser";
        String message = "TestMessage";

        // Mock DoorayHookSender
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);

        // Create an instance of DoorayMessageSender and inject the mock DoorayHookSender
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSender);

        // Configure the behavior of the mock to throw an exception when send is called
        doThrow(new RuntimeException("Sending failed")).when(doorayHookSender).send(any(DoorayHook.class));

        // Act
        boolean result = doorayMessageSender.sendMessage(new User(userName, message), message);

        // Assert
        assertFalse(result); // Check if sendMessage returns false on failure
        verify(doorayHookSender, times(1)).send(any(DoorayHook.class)); // Verify that send method was called once
    }
}
