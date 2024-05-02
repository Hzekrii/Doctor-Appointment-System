package Controllers;

import Models.Login;
import Views.AdminDashboard;
import Views.LoginForm;
import Views.SecretaryDashboard;

import javax.swing.*;

public class LoginController {
    private LoginForm loginForm;

    public LoginController(LoginForm loginForm) {
        this.loginForm = loginForm;
        this.loginForm.initLoginButtonActionListener(e -> authenticateUser());
    }

    private void authenticateUser() {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        String role = loginForm.getSelectedRole();

        // Query the database to check credentials
        boolean isAuthenticated = Login.authenticate(username, password, role);

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
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }
}
