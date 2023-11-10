package com.example.RateLimitedNotification.Services.RateLimitRules;

import com.example.RateLimitedNotification.Services.rateLimit.RateLimitRule;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RateLimitRuleTest {


    @Test
    public void rateLimit3PerHour() {
        int limit3 = 3;
        Long perHourInMillis = Duration.ofHours(1).toMillis();

        LocalDateTime localDateTimeNow = LocalDateTime.of(2023, 11, 10, 12, 10, 1);
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 11, 10, 12, 05, 1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2023, 11, 10, 12, 0, 1);
        LocalDateTime localDateTime3 = LocalDateTime.of(2023, 11, 10, 8, 59, 1);
        List<LocalDateTime> localDateTimeList = Arrays.asList(localDateTime1, localDateTime2, localDateTime3);

        RateLimitRule rateLimitRule = new RateLimitRule(limit3, perHourInMillis);
        assertTrue(rateLimitRule.allowNotification(localDateTimeList, localDateTimeNow));
    }

    @Test
    public void ratesLimit2PerHour() {
        int limit2 = 2;
        Long perHourInMillis = Duration.ofHours(1).toMillis();

        LocalDateTime localDateTimeNow = LocalDateTime.of(2023, 11, 10, 12, 10, 1);
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 11, 10, 12, 05, 1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2023, 11, 10, 12, 0, 1);
        LocalDateTime localDateTime3 = LocalDateTime.of(2023, 11, 10, 8, 59, 1);
        List<LocalDateTime> localDateTimeList = Arrays.asList(localDateTime1, localDateTime2, localDateTime3);
        RateLimitRule rateLimitRule = new RateLimitRule(limit2, perHourInMillis);
        assertFalse(rateLimitRule.allowNotification(localDateTimeList, localDateTimeNow));
    }

    @Test
    public void rateLimit3PerDay() {
        int limit3 = 3;
        Long perDayInMillis = Duration.ofHours(24).toMillis();

        LocalDateTime localDateTimeNow = LocalDateTime.of(2023, 11, 10, 12, 10, 1);
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 11, 10, 12, 05, 1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2023, 11, 10, 12, 0, 1);
        LocalDateTime localDateTime3 = LocalDateTime.of(2023, 11, 9, 23, 59, 1);
        List<LocalDateTime> localDateTimeList = Arrays.asList(localDateTime1, localDateTime2, localDateTime3);
        RateLimitRule rateLimitRule = new RateLimitRule(limit3, perDayInMillis);
        assertFalse(rateLimitRule.allowNotification(localDateTimeList, localDateTimeNow));
    }

}