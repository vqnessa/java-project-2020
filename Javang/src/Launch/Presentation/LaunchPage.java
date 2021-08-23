package Launch.Presentation;

import NotificationSystem.Logic.LogMain;
import ReviewNotificationLog.Logic.ReviewMain;
import SendNotification.Logic.NotificationMain;
import TemplateCreation.Logic.TemplateMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Florida
 * @version 11.15.2020
 */
public class LaunchPage {
    private JPanel rootPanel;
    private JButton LogSign;
    private JButton sendNotificationsButton;
    private JButton createTemplatesButton;
    private JButton reviewNotificationsButton;
    private JPanel myPanel1;
    private JPanel myPanel2;

    /**
     * @return the rootPanel
     */
    public JPanel getRootPanel() {
        return rootPanel;
    }
    public LaunchPage(){
        createLogSignButton();
        createSendNotificationsButton();
        MakeTemplatesButton();
        createReviewNotificationsButton();
    }

    /**
     * This button will open the NotificationSystem page.
     */
    private void createLogSignButton(){
        LogSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogMain.main(null);
            }
        });

    }

    /**
     * This button will open the SendNotification page.
     */
    private void createSendNotificationsButton(){
        sendNotificationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotificationMain.main(null);
            }
        });

    }

    /**
     * This button will open the TemplateCreation page.
     */
    private void MakeTemplatesButton(){
        createTemplatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TemplateMain.main(null);
            }
        });

    }

    /**
     * This button will open the ReviewNotifications page.
     */
    private void createReviewNotificationsButton(){
        reviewNotificationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReviewMain.main(null);
            }
        });

    }

}
