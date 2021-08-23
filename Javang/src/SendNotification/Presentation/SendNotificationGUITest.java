package SendNotification.Presentation;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SendNotificationGUITest {
    @Test
    void getSubjectNull() {
        SendNotificationGUI gui = new SendNotificationGUI();
        assertNull(gui.getSubject());
    }

    @Test
    void getSubject() {
        SendNotificationGUI gui = new SendNotificationGUI();
        assertEquals(gui.getSubject(),gui.getSubject());
    }

    @Test
    void getMessageNull() {
        SendNotificationGUI gui = new SendNotificationGUI();
        assertNull(gui.getMessage());
    }
    @Test
    void getMessage() {
        SendNotificationGUI gui = new SendNotificationGUI();
        assertEquals(gui.getMessage(),gui.getMessage());
    }

    @Test
    void getRootPanel() {
        SendNotificationGUI gui = new SendNotificationGUI();
        JPanel rootPanel = new JPanel();
        rootPanel = gui.getRootPanel();
        assertEquals(gui.getRootPanel(),rootPanel);
    }
}