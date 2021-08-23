package NotificationSystem.Logic;

import NotificationSystem.Presentation.NotificationSystem;

import javax.swing.*;

/**
 * @author Vanessa Watson
 * @version 11.5.2020
 *
 */

public class LogMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        NotificationSystem presentation = new NotificationSystem();
        JPanel root = presentation.getRootPanel();
        JFrame frame = new JFrame("Notification System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}

