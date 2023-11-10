package com.example.RateLimitedNotification.Services.rateLimit.RateLimitExtension;

import com.example.RateLimitedNotification.Services.constants.NotificationType;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitRule;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitRulesByNotificationType;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class NewsNotification extends RateLimitRulesByNotificationType {
    List<RateLimitRule> rateLimitRuleList = Arrays.asList(new RateLimitRule(1, Duration.ofHours(24).toMillis()));

    @Override
    public List<RateLimitRule> getRateLimitRuleList() {
        return rateLimitRuleList;
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.NEWS;
    }
}
