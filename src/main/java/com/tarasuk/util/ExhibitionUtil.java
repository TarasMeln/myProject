package com.tarasuk.util;

import com.tarasuk.db.entity.Exhibition;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.tarasuk.db.DBManager.*;

public class ExhibitionUtil {
    private DataSource dataSource;

    private static final String UPDATE_EXHIBITION = "update exhibitions set theme=? , hall=? , date=?, ticket_price=? where id=?";
    private static final String DELETE_EXHIBITION = "delete from exhibitions where id=?";
    private static final String INSERT_USERS_EXHIBITIONS = "insert into users_exhibitions (user_id,exhibition_id) values (?,?)";
    private static final String FIND_USERS_EXHIBITIONS = "SELECT `exhibition_id`, COUNT(`exhibition_id`) AS `count` FROM users_exhibitions";
    private static final String INSERT_EXHIBITION = "insert into exhibitions (theme,hall,date,ticket_price) values (?,?,?,?)";
    private static final String FIND_EXHIBITION_BY_ID = "SELECT * FROM exhibitions where id = ?";
    private static final String FIND_ALL_EXHIBITION =
            "SELECT * FROM exhibitions";
    private static final String FIELD_ID =
            "id";
    private static final String FIELD_THEME =
            "theme";
    private static final String FIELD_HALL =
            "hall";
    private static final String FIELD_DATE =
            "date";
    private static final String FIELD_TICKET_PRICE =
            "ticket_price";


    public ExhibitionUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Exhibition> findAllExhibition() {
        List<Exhibition> exhibitions = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            con = dataSource.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(FIND_ALL_EXHIBITION);
            while (resultSet.next()) {
                long id = resultSet.getLong(FIELD_ID);
                String theme = resultSet.getString(FIELD_THEME);
                long hall = resultSet.getLong(FIELD_HALL);
                Timestamp date = resultSet.getTimestamp(FIELD_DATE);
                double ticketPrice = resultSet.getDouble(FIELD_TICKET_PRICE);
                Exhibition exhibition = new Exhibition(id, theme, hall, date, ticketPrice);
                exhibitions.add(exhibition);
            }

        } catch (SQLException e) {
            //
            System.out.println(e.getMessage());
        } finally {
            close(con, statement, resultSet);
        }
        return exhibitions;
    }

    public void addExhibition(Exhibition exhibition) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = dataSource.getConnection();
            preparedStatement = con.prepareStatement(INSERT_EXHIBITION);
            preparedStatement.setString(1, exhibition.getTheme());
            preparedStatement.setLong(2, exhibition.getHall());
            preparedStatement.setTimestamp(3, exhibition.getDate());
            preparedStatement.setDouble(4, exhibition.getTicketPrice());
            preparedStatement.execute();

        } catch (SQLException e) {
            //
            System.out.println(e.getMessage());
        } finally {
            close(con, preparedStatement, null);
        }
    }

    public Exhibition getExhibitionById(String idExh) throws Exception {
        Exhibition exhibition = null;
        Connection myConn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        long exhibitionId;
        try {
            myConn = dataSource.getConnection();
            exhibitionId = Long.parseLong(idExh);
            preparedStatement = myConn.prepareStatement(FIND_EXHIBITION_BY_ID);
            preparedStatement.setLong(1, exhibitionId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong(FIELD_ID);
                String theme = resultSet.getString(FIELD_THEME);
                long hall = resultSet.getLong(FIELD_HALL);
                Timestamp date = resultSet.getTimestamp(FIELD_DATE);
                double ticketPrice = resultSet.getDouble(FIELD_TICKET_PRICE);
                exhibition = new Exhibition(id, theme, hall, date, ticketPrice);
            } else {
                throw new Exception("Could not find exhibition id: " + idExh);
            }
            return exhibition;
        } finally {
            close(myConn, preparedStatement, resultSet);
        }
    }

    public void updateExhibition(Exhibition exhibition) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_EXHIBITION);
            preparedStatement.setString(1, exhibition.getTheme());
            preparedStatement.setLong(2, exhibition.getHall());
            preparedStatement.setTimestamp(3, exhibition.getDate());
            preparedStatement.setDouble(4, exhibition.getTicketPrice());
            preparedStatement.setLong(5, exhibition.getId());
            preparedStatement.execute();
        } finally {
            close(connection, preparedStatement, null);
        }

    }

    public void deleteExhibition(String id) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long exhibitionId = Long.parseLong(id);
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_EXHIBITION);
            preparedStatement.setLong(1, exhibitionId);
            preparedStatement.execute();
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    public void buyTicket(long exhibitionId, long userId) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_USERS_EXHIBITIONS);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, exhibitionId);
            preparedStatement.executeUpdate();
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    public int statistics() throws Exception {

        Connection myConn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            myConn = dataSource.getConnection();
            preparedStatement = myConn.prepareStatement(FIND_USERS_EXHIBITIONS);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            } else {
                return count;
            }
            return count;
        } finally {
            close(myConn, preparedStatement, resultSet);
        }
    }

    public List<Exhibition> sortBy(String orderBy) {
        List<Exhibition> exhibitions = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlOrderBy;
        switch (orderBy) {
            case "Theme":
                sqlOrderBy = "SELECT * FROM exhibitions order by theme";
                break;
            case "Date":
                sqlOrderBy = "SELECT * FROM exhibitions order by date";
                break;
            case "Price":
                sqlOrderBy = "SELECT * FROM exhibitions order by ticket_price";
                break;
            default:
                sqlOrderBy = "SELECT * FROM exhibitions ";
        }
        try {
            con = dataSource.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sqlOrderBy);
            while (resultSet.next()) {
                long id = resultSet.getLong(FIELD_ID);
                String theme = resultSet.getString(FIELD_THEME);
                long hall = resultSet.getLong(FIELD_HALL);
                Timestamp date = resultSet.getTimestamp(FIELD_DATE);
                double ticketPrice = resultSet.getDouble(FIELD_TICKET_PRICE);
                Exhibition exhibition = new Exhibition(id, theme, hall, date, ticketPrice);
                exhibitions.add(exhibition);
            }

        } catch (SQLException e) {
            //
            System.out.println(e.getMessage());
        } finally {
            close(con, statement, resultSet);
        }
        return exhibitions;
    }
}
