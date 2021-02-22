package com.tarasuk.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBManager {
//    private static DBManager instance;
//
//    private DBManager() {
//        super();
//    }
//
//    public static synchronized DBManager getInstance() {
//        if (instance == null) {
//            instance = new DBManager();
//        }
//        return instance;
//    }

//    public static Connection getConnection() throws SQLException {
//        Context ctx;
//        Connection c = null;
//        try {
//            ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydatabase");
//            c = ds.getConnection();
//        }  catch (NamingException e) {
//            e.printStackTrace();
//        }
//        return c;
//    }
//
//    public static String getURL() {
//        String prop = null;
////        "jdbc:mysql://localhost:3306/new_schema?user=root&password=111122"
//        FileInputStream fis=null;
//        Properties properties = new Properties();
//        try {
//            fis = new FileInputStream("src/main/resources/app.properties");
//            properties.load(fis);
//            prop = properties.getProperty("connection.url");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return prop;
//    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
