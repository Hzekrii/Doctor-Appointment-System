package Controllers;

import Views.AdminDashboard;
import Views.Login;
import Views.SecretaryDashboard;

import javax.swing.JOptionPane;
import java.io.IOException;

public class LoginController {
    private Login loginForm;

    public LoginController(Login loginForm){
        this.loginForm = loginForm;
        this.loginForm.initLoginButtonActionListener(e -> {
            try {
                authenticateUser();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void authenticateUser() throws IOException {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        String role = loginForm.getSelectedRole();

        // Query the database to check credentials
        boolean isAuthenticated = Models.Login.authenticate(username, password, role);

        if (isAuthenticated) {
            // Redirect to Secretary or Admin dashboard based on role
            if (role.equals("Secretary")) {
                SecretaryDashboard secretaryDashboard = new SecretaryDashboard();
                secretaryDashboard.setVisible(true);
            } else if (role.equals("Admin")) {
                AdminDashboard adminDashboard = new AdminDashboard();
                adminDashboard.setVisible(true);
            }

            // Close the login form
            loginForm.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Credentials");
        }
    }

    public static Integer cerateCredentials(String username, String password, String role){
        return Models.Login.create(username, password, role);
    }
}
