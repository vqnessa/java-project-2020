package ReviewNotificationLog.Data;

import ReviewNotificationLog.Logic.Notification;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * @author Florida
 * @author Florida
 * @version 11.5.2020
 *
 */

public class Database {
    public static Connection connection = null;
    private static String CONN_STRING = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/234a_Javang";
    private static String USERNAME = "234a_Javang";
    private static String PASSWORD = "Javang_FA20_*)@";
    private static String GET_DATA_BY_DATE_SQL = "SELECT  CAST (PostedDate AS Date)AS Date,\n" +
            "\t\tCAST (PostedDate AS Time) AS Time,\n" +
            "\t\tTitle AS \"Subject\",\n" +
            "\t\tContent AS \"Message\",\n" +
            "\t\tFirstName + ' ' + LastName AS \"Staff Name\",\n" +
            "\t\tNum_Suscribers AS \"Number of subscribers\"\n" +
            "FROM\tNotifications \n" +
            "\t\tJOIN Users ON Notifications.FK_UserID = Users.UserID\n" +
            "WHERE\tPostedDate BETWEEN ? AND ?;";

    /**
     *
     */
    public static void connect() {
        if (connection != null) {
            return;
        } else{
            try{
                connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                exit(-1);
            }
        }
    }
    /**
     *
     * @param fromDate the user will enter the start date and
     * @param toDate the end date of notifications they want to see and this will
     * @return the notifications from that date range
     */
    public static ArrayList<Notification> findData(java.util.Date fromDate, java.util.Date toDate){

        connect();

        ArrayList<Notification> notifications = new ArrayList<Notification>();

        java.sql.Date fromDateAsSqlDate = new java.sql.Date(fromDate.getTime());
        java.sql.Date toDateAsSqlDate = new java.sql.Date(toDate.getTime());

        try {
            PreparedStatement stmt = connection.prepareStatement(GET_DATA_BY_DATE_SQL);
            stmt.setDate(1, fromDateAsSqlDate);
            stmt.setDate(2, toDateAsSqlDate);


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notifications.add(new Notification(
                        rs.getDate("Date"),
                        rs.getTime("Time"),
                        rs.getString("Subject"),
                        rs.getString("Message"),
                        rs.getString("Staff Name"),
                        rs.getInt("Number of subscribers")
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return notifications;
    }
}
