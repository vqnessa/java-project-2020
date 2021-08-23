package NotificationSystem.Data;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * @author Vanessa Watson
 * @version 11.5.2020
 *
 */


public class Database {
    public static Connection connection = null;
    private static String CONN_STRING = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/234a_Javang";
    private static String USERNAME = "234a_Javang";
    private static String PASSWORD = "Javang_FA20_*)@";
    private static String INSERT_USERS = "INSERT INTO Users (FirstName, LastName, Username, PasswordHash, Salt, Email, Role)" +
            "VALUES (?,?,?,?,?,?,?);";

    public static void connect() {
        if (connection != null) {
            return;
        } else {
            try {
                connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                exit(-1);
            }
        }
    }

    public static void insert(String firstName, String lastName, String username, String passwordDB, String salt, String emailDB, String role) {
        connect();
        try {
            PreparedStatement stmt = connection.prepareStatement(INSERT_USERS);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, username);
            stmt.setString(4, passwordDB);
            stmt.setString(5, salt);
            stmt.setString(6, emailDB);
            stmt.setString(7, role);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String FETCH_USER_INFO = "SELECT Username FROM Users";

    public static boolean checkUserExists(String username) {
        connect();
        ArrayList<String> usernames = new ArrayList<String>();
        boolean userExists = false;

        try (
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(FETCH_USER_INFO)
        ) {
            while (rs.next()) {
                usernames.add(rs.getString("Username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (String s : usernames) {
            if (username.equals(s)) {
                userExists = true;
            }
        }
        return userExists;
    }

    public static void deactivateAccount(String username) {
        connect();
        try(
                PreparedStatement stmt = connection.prepareStatement("DELETE FROM Users WHERE Username = ?");
        ){
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static final String FETCH_PASSWORD = "SELECT PasswordHash FROM Users WHERE Username =?";

    public static boolean getPasswordHash(String hashedPW) {
        connect();
        boolean pwMatch = false;
        try(
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(FETCH_PASSWORD);
        ){
            while(rs.next()) {
                if(rs.getString("PasswordHash").equals(hashedPW)) {
                    pwMatch = true;
                }
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return pwMatch;
    }
}