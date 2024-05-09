package Models;

import Database.DBConnection;

import java.sql.*;

public class Login {
    public static boolean authenticate(String username, String password, String role) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM login WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);

            ResultSet resultSet = statement.executeQuery();
            boolean result = resultSet.next(); // If result set has next, credentials are valid
            resultSet.close();
            statement.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Integer create(String username, String password, String role){
        String query1 = "INSERT INTO login(username, password, role) VALUES (?, ?, ?);";
        String query2 = "SELECT MAX(login_id) FROM login;";
        Integer id = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query2);
            if(resultSet.next()) {
                id = resultSet.getInt("MAX(login_id)");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
