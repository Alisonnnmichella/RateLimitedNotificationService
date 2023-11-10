package com.example.RateLimitedNotification.Services.interfaces;

import java.time.LocalDateTime;
import java.util.List;

public interface RateLimitRuleInterface {

    boolean allowNotification(List<LocalDateTime> localDateTimes, LocalDateTime localDateTimeNow);
}
