package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import Models.Secretary;
import Controllers.SecretaryController;

public class SecretaryDashboard extends JFrame {

    private JTable secretaryTable;

    public SecretaryDashboard() {
        setTitle("Secretary Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Secretary Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        secretaryTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(secretaryTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load and display secretaries
        loadSecretaries();

        add(panel);
    }

    private void loadSecretaries() {

        ArrayList<Secretary> secretaries = SecretaryController.getAllSecretaries();
        if (secretaries != null) {
            // Create table model with column names
            DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "CIN", "First Name", "Last Name", "Email", "Phone"}, 0);
            // Populate table model with secretary data
            for (Secretary secretary : secretaries) {
                model.addRow(new Object[]{secretary.getID(), secretary.getCIN(), secretary.getFirstName(), secretary.getLastName(), secretary.getEmail(), secretary.getPhone()});
            }
            // Set table model to display data
            secretaryTable.setModel(model);
        } else {
            // Display an error message if loading failed
            JOptionPane.showMessageDialog(this, "Failed to load secretaries from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
