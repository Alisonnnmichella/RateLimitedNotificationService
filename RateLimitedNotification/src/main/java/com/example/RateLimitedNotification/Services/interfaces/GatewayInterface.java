package com.example.RateLimitedNotification.Services.interfaces;

public interface GatewayInterface {
    void send(String userId, String message);
}
