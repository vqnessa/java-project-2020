package SendNotification.Logic;

import SendNotification.Presentation.SendNotificationGUI;

import javax.swing.*;

/**
 * STORY - Send Notification
 *
 * Manager (or staff member) can enter subject and message which is emailed to everyone
 * on the subscriber list.
 * The message will be a straight text in sprint 1. For sprint 2, the message
 * could be either straight text or built from a template.
 * Message data (subject and message sent, staff who sent, date and time sent,
 * number of subscribers the message was sent to) is written to a notification log.
 *
 * @author Johnny Perez
 * @version 2020.10.08
 */
public class NotificationMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGui();
            }
        });
    }

    private static void createGui() {
        SendNotificationGUI ui = new SendNotificationGUI();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame("Food Pantry Notification System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
