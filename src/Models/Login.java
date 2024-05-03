package Models;

import Database.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static boolean authenticate(String username, String password, String role) throws IOException {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM login WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // If result set has next, credentials are valid
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
