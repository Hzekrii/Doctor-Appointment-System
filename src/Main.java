import Database.DBConnection;
import Controllers.LoginController;
import Views.Login;

import javax.swing.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Initialize the database connection
                Connection conn = DBConnection.getConnection();

                // Check if the connection is successful
                if (conn != null) {
                    System.out.println("Connected to the database.");

                    // Create the login form and controller
                    Login loginForm = new Login();
                    LoginController loginController = new LoginController(loginForm);
                    loginForm.setVisible(true);
                } else {
                    System.out.println("Failed to connect to the database.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
