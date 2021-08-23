package TemplateCreation.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.exit;

/**
 * Template Creation story Database
 * @Author Melissa Chan
 * @version 11.11.2020
 * Makes a connection to Database and writes into it
 */
public class Database {
    public static Connection connection = null;
    private static String CONN_STRING = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/234a_Javang";
    private static String USERNAME = "234a_Javang";
    private static String PASSWORD = "Javang_FA20_*)@";
    private static String INSERT_TEMPLATES = "INSERT INTO Templates(Name, Tag, Subject, Body)" +
            "VALUES(?,?,?,?);";

    /**
     * connects the database
     */
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

    /**
     *
     * @param name name text
     * @param tag tag text
     * @param subject subject text
     * @param body body text
     */
    public static void insert(String name,String tag, String subject, String body) {
        connect();

        try{
            PreparedStatement stmt = connection.prepareStatement(INSERT_TEMPLATES);
            stmt.setString(1,name);
            stmt.setString(2,tag);
            stmt.setString(3,subject);
            stmt.setString(4,body);
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
