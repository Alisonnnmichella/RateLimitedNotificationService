package com.example.RateLimitedNotification.Services;

import com.example.RateLimitedNotification.Exceptions.NotAllowNotification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(value = {SpringExtension.class, MockitoExtension.class})
class NotificationServiceTest {

    @MockBean
    Gateway gateway;

    @InjectMocks
    NotificationService notificationService;

    @Test
    public void cannotSendTwoNewsNotificationServiceToAUserInOneDay() throws NotAllowNotification {
        assertDoesNotThrow(() -> notificationService.send("news", "user", "news 1"));
        assertThrows(NotAllowNotification.class, () -> notificationService.send("news", "user", "news 2"));
    }

    @Test
    public void canSendOneNewNotificationToTwoDifferentUsers() throws NotAllowNotification {
        assertDoesNotThrow(() -> notificationService.send("news", "user", "news 1"));
        assertDoesNotThrow(() -> notificationService.send("news", "user2", "news 2"));
    }

    @Test
    public void canSendTwoMarketingNotificationToAUserInAnHour() throws NotAllowNotification {
        assertDoesNotThrow(() -> notificationService.send("marketing", "user", "marketing 1"));
        assertDoesNotThrow(() -> notificationService.send("marketing", "user", "marketing 2"));
        assertDoesNotThrow(() -> notificationService.send("marketing", "user", "marketing 3"));

    }

}