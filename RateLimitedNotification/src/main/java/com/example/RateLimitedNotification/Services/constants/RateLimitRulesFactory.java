package com.example.RateLimitedNotification.Services.constants;

import com.example.RateLimitedNotification.Services.rateLimit.RateLimitExtension.DailyNotification;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitExtension.MarketingNotification;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitExtension.NewsNotification;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitExtension.StatusNotification;
import com.example.RateLimitedNotification.Services.rateLimit.RateLimitRulesByNotificationType;

import java.util.EnumMap;
import java.util.Map;

public class RateLimitRulesFactory {
    public static final Map<NotificationType, RateLimitRulesByNotificationType> RULES_MAP = new EnumMap<>(NotificationType.class);

    static {
        RULES_MAP.put(NotificationType.STATUS, new StatusNotification());
        RULES_MAP.put(NotificationType.NEWS, new NewsNotification());
        RULES_MAP.put(NotificationType.MARKETING, new MarketingNotification());
        RULES_MAP.put(NotificationType.DAILY, new DailyNotification());
    }

    public static RateLimitRulesByNotificationType getRules(NotificationType notificationType) {
        return RULES_MAP.get(notificationType);
    }

}
