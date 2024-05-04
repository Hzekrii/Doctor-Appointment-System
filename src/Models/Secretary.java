package Models;

import Database.DBConnection;

import java.io.IOException;
import java.sql.*;

public class Secretary {


    public static ResultSet all() {
        String query = "SELECT * FROM secretaries";
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void create(String cin, String firstName, String lastName, String email, String phone) {
        String query = "INSERT INTO secretaries(cin, first_name, last_name, email, tele,login_id) VALUES (?, ?, ?, ?, ?,null)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM secretaries WHERE id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(int id, String cin, String firstName, String lastName, String email, String phone) {
        String query = "UPDATE secretaries SET cin=?,first_name = ?, last_name = ?, email = ?, tele = ? WHERE id=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ResultSet get(int id) {
        String query = "SELECT * FROM secretaries WHERE id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

