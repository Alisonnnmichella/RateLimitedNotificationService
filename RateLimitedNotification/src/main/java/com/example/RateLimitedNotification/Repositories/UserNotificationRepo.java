package com.example.RateLimitedNotification.Repositories;

import com.example.RateLimitedNotification.Models.UserNotification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserNotificationRepo {

    List<UserNotification> userNotifications;

    public UserNotificationRepo() {
        userNotifications = new ArrayList<>();
    }


    public void setUserNotifications(List<UserNotification> userNotifications) {
        this.userNotifications = userNotifications;
    }

//this class would be a repo that consults from database throw JPQL

    public List<LocalDateTime> getLastSendByUserAndNotificationType(String userId, String type) {
        return userNotifications.stream().filter(userNotification ->
                        userNotification.getUserId().equalsIgnoreCase(userId) && userNotification.getType().equalsIgnoreCase(type))
                .map(userNotification -> userNotification.getLocalDateTimeSend()).collect(Collectors.toList());

    }

    public UserNotification saveUserNotification(UserNotification userNotification) {
        userNotifications.add(userNotification);
        return userNotification;
    }

}
