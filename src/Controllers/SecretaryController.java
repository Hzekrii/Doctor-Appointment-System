package Controllers;

import Models.Secretary;

import java.sql.SQLException;
import java.util.ArrayList;

public class SecretaryController {

    public static ArrayList<Secretary> getAllSecretaries() {
        try {
            // Call the model method to retrieve all secretaries
            return Secretary.all();
        } catch (SQLException e) {
            // Handle the exception (e.g., log, display error message)
            JOptionPane.showMessageDialog(null, "Failed to retrieve secretaries from the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
            // Or return an empty list return new ArrayList<>();
        }
    }

    public static Secretary getSecretary(int id) {
        try {
            // Call the model method to retrieve a secretary by ID
            return Secretary.get(id);
        } catch (SQLException e) {
            // Handle the exception (e.g., log, display error message)
            JOptionPane.showMessageDialog(null, "Failed to retrieve secretaries from the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
            // Or return an empty list return new ArrayList<>();
        }
    }

    public static void createSecretary(String cin, String firstName, String lastName, String email, String phone) {
        try {
            // Call the model method to create a new secretary
            Secretary.create(cin, firstName, lastName, email, phone);
        } catch (SQLException e) {
            // Handle the exception (e.g., log, display error message)
            JOptionPane.showMessageDialog(null, "Failed to retrieve secretaries from the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
            // Or return an empty list return new ArrayList<>();
        }
    }

    public static void updateSecretary(int id, String cin, String firstName, String lastName, String email, String phone) {
        try {
            // Call the model method to update an existing secretary
            Secretary.update(id, cin, firstName, lastName, email, phone);
        } catch (SQLException e) {
            // Handle the exception (e.g., log, display error message)
            JOptionPane.showMessageDialog(null, "Failed to retrieve secretaries from the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
            // Or return an empty list return new ArrayList<>();
        }
    }

    public static void deleteSecretary(int id) {
        try {
            // Call the model method to delete a secretary by ID
            Secretary.delete(id);
        } catch (SQLException e) {
            // Handle the exception (e.g., log, display error message)
            JOptionPane.showMessageDialog(null, "Failed to retrieve secretaries from the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
            // Or return an empty list return new ArrayList<>();
        }
    }
}
