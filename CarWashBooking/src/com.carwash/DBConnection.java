package com.carwash;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Change credentials here
            String url = "jdbc:sqlserver://DRUGBULLETS\\SERVER;databaseName=CarWashDB;encrypt=false;";
            String user = "arin";
            String password = "12345678";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
