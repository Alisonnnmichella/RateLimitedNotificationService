package com.example.RateLimitedNotification.Services.rateLimit;

import com.example.RateLimitedNotification.Services.constants.NotificationType;

import java.time.LocalDateTime;
import java.util.List;

public abstract class RateLimitRulesByNotificationType {

    public abstract List<RateLimitRule> getRateLimitRuleList();

    public abstract NotificationType getNotificationType();

    public void addRateLimitRules(RateLimitRule rateLimitRule) {
        getRateLimitRuleList().add(rateLimitRule);
    }

    public boolean allowNotification(List<LocalDateTime> localDateTimes) {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        return getRateLimitRuleList().stream().allMatch(rateLimitRule -> rateLimitRule.allowNotification(localDateTimes, localDateTimeNow));
    }


}
