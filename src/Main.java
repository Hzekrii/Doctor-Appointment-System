import Database.DBConnection;
import Controllers.LoginController;
import Views.Login;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Check if the connection is successful
                if (DBConnection.getConnection() != null) {
                    System.out.println("Connected to the database.");
                    // Create the login form and controller
                    new LoginController(new Login());
                } else {
                    System.out.println("Failed to connect to the database.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
