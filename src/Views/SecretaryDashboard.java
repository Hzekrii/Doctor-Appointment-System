package Views;

import javax.swing.*;
import java.awt.*;

public class SecretaryDashboard extends JFrame {
    public SecretaryDashboard() {
        setTitle("Secretary Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Secretary Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea secretaryInfoTextArea = new JTextArea();
        secretaryInfoTextArea.setEditable(false);
        secretaryInfoTextArea.setText("Display secretary information or functionality here.");
        panel.add(new JScrollPane(secretaryInfoTextArea), BorderLayout.CENTER);

        add(panel);
    }
}
