package ReviewNotificationLog.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationTest {

    @Test
    void findData() {
    }

    @Test
    void getPostedDate() {
        
    }

    @Test
    void getPostedTime() {
    }

    @Test
    void getTitle() {
        Notification n = new Notification(null, null, "my notification", null, null, 0);
        assertEquals("my notification", n.getTitle());
    }

    @Test
    void getContent() {
        Notification n = new Notification(null, null, null, "my content", null, 0);
        assertEquals("my content", n.getContent());
    }

    @Test
    void getName() {
        Notification n = new Notification(null, null, null, null, "my name", 0);
        assertEquals("my name", n.getName());
    }

    @Test
    void getNum_Suscribers() {
        Notification n = new Notification(null, null, null, null, null, 1);
        assertEquals(1, n.getNum_Suscribers());
    }
}