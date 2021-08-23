package SendNotification.Presentation;

import SendNotification.Database.Database;
import SendNotification.Logic.SendEmail;
import SendNotification.Logic.TemplateData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import static SendNotification.Database.Database.fetchSubscribers;

/**
 * STORY - Send Notification
 *
 * The GUI for the Send Notification STORY
 *
 * @author Johnny Perez
 * @version 2020.10.08
 */

public class SendNotificationGUI {
    private JPanel rootPanel;
    private JLabel headLabel;
    private JComboBox selectTemplateCombo;
    private JLabel selectTemplateLabel;
    private JTextField subjectTextField;
    private JTextArea messageTextArea;
    private JButton sendButton;
    private JLabel toLabel;
    private JLabel listLabel;
    private JLabel subjectLabel;
    private JLabel messageLabel;

    public SendNotificationGUI() {
        rootPanel.setPreferredSize(new Dimension(500,350));
        messageTextArea.setLineWrap(true);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subject = getSubject();
                String messageBody = getMessage();

                ArrayList<String> getList = fetchSubscribers();
                String subscriberList = getList.toString().replace("[", "").replace("]", "");

                SendEmail.sendNewEmail(subject,messageBody,subscriberList,getList);

                subjectTextField.setText("");
                messageTextArea.setText("");
            }
        });


        ArrayList<TemplateData> templates = Database.fetchTemplateInfo();
        for (TemplateData template: templates) {
            selectTemplateCombo.addItem(template.getTemplateName());
        }

        selectTemplateCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem().toString();
                    for (TemplateData template: templates) {
                        if (template.getTemplateName() == e.getItem()) {
                            subjectTextField.setText(template.getTemplateSubject());
                            messageTextArea.setText(template.getTemplateMessage());
                        }
                    }
                }
            }
        });
    }


    /**
     * Get the subject from the subject text field
     * @return The subject or null if empty
     */
    public String getSubject() {
        try {
            String subject = subjectTextField.getText();
            if (subject.equals("")) {
                JOptionPane.showMessageDialog(null,"Error. Must have subject.","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                return subject;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error. Must have subject.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Get the message from text area
     * @return The message text entered
     */
    public String getMessage() {
        try {
            String message = messageTextArea.getText();
            if (message.equals("")) {
                JOptionPane.showMessageDialog(null,"Error. Must have message body.","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                return message;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error. Must have message body.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Get the root panel
     * @return The root panel
     */
    public JPanel getRootPanel() {
        return rootPanel;
    }

    /**
     * Method to display errors associated with the DB.
     */
    public static void displayDatabaseError() {
        JOptionPane.showMessageDialog(null,"Error connecting to database.","Error",JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays error associated with sending the email
     */
    public static void displaySendEmailError() {
        JOptionPane.showMessageDialog(null,"Error sending email.","Error",JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays successful email sent message
     */
    public static void displayEmailSent() {
        JOptionPane.showMessageDialog(null, "Email Sent.");
    }

}
