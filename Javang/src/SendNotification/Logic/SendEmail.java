package SendNotification.Logic;

import SendNotification.Database.Database;
import SendNotification.Presentation.SendNotificationGUI;

import javax.mail.Session;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

/**
 * STORY - Send Notification
 *
 * This class will establish the email connection and send email
 *
 * @author Johnny Perez
 * @version 2020.10.13
 */

public class SendEmail {

    /**
     * Prepares the email to be sent
     * @param subject The subject text
     * @param messageBody The message body text
     * @param subscriberList The list of subscribers converted from arraylist to string
     * @return null
     */
    public static SendEmail prepareNewEmail(String subject, String messageBody, String subscriberList) {

        final String username = "javangfoodpantry@gmail.com";
        final String password = "Javang_FA20_*)@";

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("javangfoodpantry@gmail.com"));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(subscriberList));

            if (subject == null || messageBody == null) {
                return null;
            } else {
                message.setSubject(subject);
                message.setText(messageBody);
                Transport.send(message);
            }

            SendNotificationGUI.displayEmailSent();
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
            SendNotificationGUI.displaySendEmailError();
        }
        return null;
    }

    /**
     * Calls the objects/methods necessary to send out the email
     * @param subject The subject text
     * @param messageBody The message body text
     * @param subscribersList The list of subscribers converted from arraylist to string
     * @param getList The list of subscribers in arraylist form to utilize size()
     */
    public static void sendNewEmail(String subject, String messageBody, String subscribersList, ArrayList<String> getList) {
        SendEmail.prepareNewEmail(subject, messageBody, subscribersList);
        Database.logNotifications(subject,messageBody, getList);
    }

}