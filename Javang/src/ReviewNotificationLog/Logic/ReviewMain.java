package ReviewNotificationLog.Logic;

import ReviewNotificationLog.Presentation.NotificationLog;

import javax.swing.*;

/**
 *
 * This is the main class of the ReviewNotificationLog
 *
 * @author Florida
 * @version 10.13.2020
 */

public class ReviewMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateReviewGUI();
            }
        });
    }
    /**
     * This will create the properties of my GUI frame
     */
    private static void CreateReviewGUI() {
        NotificationLog presentation = new NotificationLog();
        JPanel root = presentation.getRootPanel();
        JFrame frame = new JFrame("Notification Log");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
