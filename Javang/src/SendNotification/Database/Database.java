package SendNotification.Database;

import SendNotification.Logic.TemplateData;
import SendNotification.Presentation.SendNotificationGUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * STORY - Send Notification
 *
 * The Database class will establish the connection to the DB and
 * query the subscribers list to obtain the emails of subs
 *
 * @author Johnny Perez
 * @version 2020.10.14
 */

public class Database {

    public static final String CONNECTION_STRING = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/234a_Javang";

    private static final String FETCH_SUBS_LIST = "SELECT Email FROM Users;";

    private static Connection m_Connection = null;

    /**
     * Makes connection to DB
     */
    private static void connect() {
        if (m_Connection != null)
            return;
        try {
            m_Connection = DriverManager.getConnection(CONNECTION_STRING,"234a_Javang","Javang_FA20_*)@");
        } catch (SQLException e) {
            SendNotificationGUI.displayDatabaseError();
        }
    }

    /**
     * Return all the subs from the subscriber table
     * @return The list of subs emails as string
     */
    public static ArrayList<String> fetchSubscribers() {
        ResultSet rs = null;
        ArrayList<String> subscribers = new ArrayList<>();

        try {
            connect();

            PreparedStatement stmt = m_Connection.prepareStatement(FETCH_SUBS_LIST);
            rs = stmt.executeQuery();

            while (rs.next()) {
                subscribers.add(rs.getString("Email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            SendNotificationGUI.displayDatabaseError();
        }
        return subscribers;
    }

    private static final String INSERT_NOTIFICATIONS = "INSERT INTO Notifications (Title, Content, PostedDate, Num_Suscribers)"
            + "VALUES (?,?,?,?);";

    /**
     * Logs the message data to the database
     * @param subject The subject text
     * @param messageBody The message body text
     * @param getList The list of subscribers in arraylist form to utilize size()
     */
    public static void logNotifications(String subject, String messageBody, ArrayList<String> getList) {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        try {
            connect();

            PreparedStatement stmt = m_Connection.prepareStatement(INSERT_NOTIFICATIONS);
            stmt.setString(1,subject);
            stmt.setString(2,messageBody);
            stmt.setDate(3,startDate);
            stmt.setInt(4, getList.size());

            if (subject == null || messageBody == null) return;
            else {
                stmt.execute();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            SendNotificationGUI.displayDatabaseError();
        }
    }

    private static final String FETCH_TEMPLATE_INFO = "SELECT Name, Subject, Body FROM Templates;";

    public static ArrayList<TemplateData> fetchTemplateInfo() {
        ResultSet rs = null;
        ArrayList<TemplateData> templateInfo = new ArrayList<>();

        try {
            connect();
            PreparedStatement stmt = m_Connection.prepareStatement(FETCH_TEMPLATE_INFO);
            rs= stmt.executeQuery();

            while (rs.next()) {
                templateInfo.add(new TemplateData(rs.getString("Name"),rs.getString("Subject"),rs.getString("Body")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            SendNotificationGUI.displayDatabaseError();
        }
        return templateInfo;
    }
}
