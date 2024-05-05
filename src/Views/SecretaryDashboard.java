package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import Models.Secretary;
import Controllers.SecretaryController;

public class SecretaryDashboard extends JFrame {

    private final JTable secretaryTable;
    private final DefaultTableModel tableModel;
    private final JTextField cinField;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField emailField;
    private final JTextField phoneField;
    private final JButton submitButton;
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

        // Form for adding a new secretary
        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        JLabel cinLabel = new JLabel("CIN:");
        cinField = new JTextField();
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String cin = cinField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            // Call createSecretary method from controller
            SecretaryController.createSecretary(cin, firstName, lastName, email, phone);
            // Reload secretaries after creating a new one
            loadSecretaries();
            // Clear input fields after submission
            clearFields();
        });
        formPanel.add(cinLabel);
        formPanel.add(cinField);
        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(submitButton);
        panel.add(formPanel, BorderLayout.WEST);


        //table
        tableModel = new DefaultTableModel(new Object[]{"ID", "CIN", "First Name", "Last Name", "Email", "Phone", "Delete", "Edit"}, 0);
        secretaryTable = new JTable(tableModel);
        secretaryTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer("Delete"));
        secretaryTable.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer("Edit"));
        secretaryTable.addMouseListener(new ButtonClickListener(secretaryTable));
        JScrollPane scrollPane = new JScrollPane(secretaryTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load and display secretaries
        loadSecretaries();

        add(panel);
    }
    private void clearFields() {
        cinField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }
    private void loadSecretaries() {
        ArrayList<Secretary> secretaries = SecretaryController.getAllSecretaries();
        if (secretaries != null) {
            tableModel.setRowCount(0); // Clear existing table rows
            // Populate table model with secretary data
            for (Secretary secretary : secretaries) {
                Object[] rowData = new Object[]{secretary.getID(), secretary.getCIN(), secretary.getFirstName(), secretary.getLastName(),
                        secretary.getEmail(), secretary.getPhone(), "Delete", "Edit"};
                tableModel.addRow(rowData);
            }
        } else {
            // Display an error message if loading failed
            JOptionPane.showMessageDialog(this, "Failed to load secretaries from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer(String text) {
            setText(text);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonClickListener extends MouseAdapter {
        private final JTable table;

        public ButtonClickListener(JTable table) {
            this.table = table;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY() / table.getRowHeight();
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof String && ((String) value).equalsIgnoreCase("delete")) {
                    // Call deleteSecretary method
                    int id = (int) table.getValueAt(row, 0);
                    SecretaryController.deleteSecretary(id);
                    // Reload secretaries after deletion
                    loadSecretaries();
                } else if (value instanceof String && ((String) value).equalsIgnoreCase("edit")) {
                    // Call editSecretary method
                    int id = (int) table.getValueAt(row, 0);
                    String cin = (String) table.getValueAt(row, 1);
                    String firstName = (String) table.getValueAt(row, 2);
                    String lastName = (String) table.getValueAt(row, 3);
                    String email = (String) table.getValueAt(row, 4);
                    String phone = (String) table.getValueAt(row, 5);
                    // Populate the form fields with the secretary's data
                    cinField.setText(cin);
                    firstNameField.setText(firstName);
                    lastNameField.setText(lastName);
                    emailField.setText(email);
                    phoneField.setText(phone);

                    // Define an action listener for the submit button to update the secretary
                    submitButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Get the updated values from the form fields
                            String updatedCin = cinField.getText();
                            String updatedFirstName = firstNameField.getText();
                            String updatedLastName = lastNameField.getText();
                            String updatedEmail = emailField.getText();
                            String updatedPhone = phoneField.getText();
                            // Call the updateSecretary method
                            SecretaryController.updateSecretary(id, updatedCin, updatedFirstName, updatedLastName, updatedEmail, updatedPhone);
                            // Reload secretaries after updating
                            loadSecretaries();
                            // Clear input fields after submission
                            clearFields();
                        }
                    });
                }
            }
        }
    }

}
