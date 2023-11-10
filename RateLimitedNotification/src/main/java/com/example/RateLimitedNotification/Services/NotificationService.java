package com.example.RateLimitedNotification.Services;

import com.example.RateLimitedNotification.Exceptions.NotAllowNotification;
import com.example.RateLimitedNotification.Models.UserNotification;
import com.example.RateLimitedNotification.Repositories.UserNotificationRepo;
import com.example.RateLimitedNotification.Services.constants.NotificationType;
import com.example.RateLimitedNotification.Services.interfaces.NotificationServiceInterface;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitRulesByNotificationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.RateLimitedNotification.Services.constants.RateLimitRulesFactory.RULES_MAP;

@Service
public class NotificationService implements NotificationServiceInterface {
    UserNotificationRepo userNotificationRepo = new UserNotificationRepo();


    @Autowired
    Gateway gateway;
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Override
    public void send(String type, String userId, String message) throws NotAllowNotification {
        List<LocalDateTime> localDateTimeList = userNotificationRepo.getLastSendByUserAndNotificationType(userId, type);
        NotificationType notificationType = NotificationType.valueOf(type.toUpperCase());
        RateLimitRulesByNotificationType rateLimitRulesByNotificationType = RULES_MAP.get(notificationType);
        if (!rateLimitRulesByNotificationType.allowNotification(localDateTimeList)) {
            logger.error(String.format("Not allowed send message to user: %s. Notification type: %s", userId, type));
            throw new NotAllowNotification(type);
        }
        gateway.send(userId, message);
        userNotificationRepo.saveUserNotification(new UserNotification(userId, type, LocalDateTime.now()));
    }

}




