package com.example.RateLimitedNotification.Services.rateLimit.RateLimitExtension;

import com.example.RateLimitedNotification.Services.constants.NotificationType;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitRule;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitRulesByNotificationType;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class StatusNotification extends RateLimitRulesByNotificationType {
    List<RateLimitRule> rateLimitRuleList = Arrays.asList(new RateLimitRule(2, Duration.ofMinutes(1).toMillis()));


    @Override
    public List<RateLimitRule> getRateLimitRuleList() {
        return rateLimitRuleList;
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.STATUS;
    }

}
