package com.example.RateLimitedNotification.Services.rateLimit;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RateLimitRule {
    private int limit;
    private long intervalInMillis;

    public RateLimitRule(int limit, long intervalInMillis) {
        this.limit = limit;
        this.intervalInMillis = intervalInMillis;
    }


    public boolean allowNotification(List<LocalDateTime> localDateTimes, LocalDateTime localDateTimeNow) {
        if (localDateTimes.isEmpty()) {
            return true;
        }
        Collections.sort(localDateTimes, Comparator.reverseOrder());
        LocalDateTime lastLocalDate = localDateTimes.get(0);
        long millisecondsDifference = ChronoUnit.MILLIS.between(lastLocalDate, localDateTimeNow);

        if (millisecondsDifference >= intervalInMillis) {
            return true;
        }

        int count = localDateTimes.stream()
                .filter(localDateTime -> ChronoUnit.MILLIS.between(localDateTime, localDateTimeNow) <= intervalInMillis)
                .mapToInt(email -> 1)
                .sum();
        return count < limit;
    }
}