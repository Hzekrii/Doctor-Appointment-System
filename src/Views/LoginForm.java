package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Secretary", "Admin"};
        roleComboBox = new JComboBox<>(roles);
        loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(roleLabel);
        panel.add(roleComboBox);
        panel.add(loginButton);

        add(panel);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getSelectedRole() {
        return (String) roleComboBox.getSelectedItem();
    }

    public void initLoginButtonActionListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
}
