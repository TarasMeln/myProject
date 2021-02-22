package com.tarasuk.util;

import com.tarasuk.db.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.tarasuk.db.DBManager.*;

public class UserUtil {
    private static final String INSERT_USER = "insert into users (email,password,isAdmin) values (?,?,?)";
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "select * from users where email=? and password=?";
    private static final String FIELD_isADMIN =
            "isAdmin";
    private static final String FIELD_ID =
            "id";
    private static final String SQL__FIND_ALL_USERS =
            "SELECT * FROM users";
    private static final String FIELD_EMAIL = "email";

    private DataSource dataSource;

    public UserUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean login(String login, String password)  {
        boolean status=false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = dataSource.getConnection();
            preparedStatement = con.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);

            ResultSet rs=preparedStatement.executeQuery();
            status=rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(con, preparedStatement, null);
        }
        return status;
    }

    public void addUser(User user) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = dataSource.getConnection();
            preparedStatement = con.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getAdmin());
            preparedStatement.execute();

        } catch (SQLException e) {
            //
            System.out.println(e.getMessage());
        } finally {
            close(con, preparedStatement, null);
        }
    }

    public boolean UserIsAdmin(String email,String password) { // ---
        boolean isAdmin=false;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = dataSource.getConnection();
            preparedStatement = con.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next())
            isAdmin=rs.getBoolean(FIELD_isADMIN);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(con, preparedStatement, null);
        }
        return isAdmin;
    }

    public Long getUserId(String email, String password) {
        long id = 0;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = dataSource.getConnection();
            preparedStatement = con.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next())
                id=rs.getLong(FIELD_ID);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(con, preparedStatement, null);
        }
        return id;
    }


}
