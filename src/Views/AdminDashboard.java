package Views;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Admin Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea adminInfoTextArea = new JTextArea();
        adminInfoTextArea.setEditable(false);
        adminInfoTextArea.setText("Display admin information or functionality here.");
        panel.add(new JScrollPane(adminInfoTextArea), BorderLayout.CENTER);

        add(panel);
    }
}
