package com.example.RateLimitedNotification.Services;

import com.example.RateLimitedNotification.Services.interfaces.GatewayInterface;
import org.springframework.stereotype.Service;

@Service
public class Gateway implements GatewayInterface {

    public void send(String userId, String message) {
        System.out.println("sending message to user " + userId);
    }


}
