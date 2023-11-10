package com.example.RateLimitedNotification.Models;

import java.time.LocalDateTime;

public class UserNotification {
    public UserNotification() {
    }

    public UserNotification(String userId, String type, LocalDateTime localDateTimeSend) {
        this.userId = userId;
        this.type = type;
        this.localDateTimeSend = localDateTimeSend;
    }

    private String userId;
    private String type;
    private LocalDateTime localDateTimeSend;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getLocalDateTimeSend() {
        return localDateTimeSend;
    }

    public void setLocalDateTimeSend(LocalDateTime localDateTimeSend) {
        this.localDateTimeSend = localDateTimeSend;
    }
}
