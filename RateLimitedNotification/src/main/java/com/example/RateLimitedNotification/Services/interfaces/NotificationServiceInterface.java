package com.example.RateLimitedNotification.Services.interfaces;

import com.example.RateLimitedNotification.Exceptions.NotAllowNotification;

public interface NotificationServiceInterface {
    void send(String type, String userId, String message) throws NotAllowNotification;

}
