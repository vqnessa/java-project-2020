package NotificationSystem.Presentation;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vanessa Watson
 * @version 11.5.2020
 *
 */

class NotificationSystemTest {

    @Test
    void getRootPanel() {
        NotificationSystem gui = new NotificationSystem();
        JPanel rootPanel = new JPanel();
        rootPanel = gui.getRootPanel();
        assertEquals(gui.getRootPanel(), rootPanel);
    }

    @Test
    void getFirstName() {
        NotificationSystem gui = new NotificationSystem();
        assertEquals(gui.getFirstName(),gui.getFirstName());
    }

    @Test
    void getUsername() {
        NotificationSystem gui = new NotificationSystem();
        assertEquals(gui.getUsername(),gui.getUsername());
    }

    @Test
    void getPassword1() {
        NotificationSystem gui = new NotificationSystem();
    }

    @Test
    void getEmail() {
        NotificationSystem gui = new NotificationSystem();;
    }
}