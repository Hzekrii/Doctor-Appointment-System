package Controllers;

import Models.Secretary;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SecretaryController {

    private SecretaryController() {
        // Private constructor to prevent instantiation
    }

    public static ArrayList<Secretary> getAllSecretaries() {
        // Call the model method to retrieve all secretaries
        ArrayList<Secretary> secretaries = Secretary.all();
        if (secretaries != null) {
            return secretaries;
        } else {
            // Handle the case when the list is null (e.g., log, display error message)
            JOptionPane.showMessageDialog(null, "Failed to retrieve secretaries from the database.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static Secretary getSecretary(int id) {
        // Call the model method to retrieve a secretary by ID
        Secretary secretary = Secretary.get(id);
        if (secretary != null) {
            return secretary;
        } else {
            JOptionPane.showMessageDialog(null, "Failed to retrieve secretary with ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static void createSecretary(String cin, String firstName, String lastName, String email, String phone) {
       // try {
            // Call the model method to create a new secretary
            Secretary.create(cin, firstName, lastName, email, phone);
       // } catch (SQLException e) {
            // Handle the exception
           // JOptionPane.showMessageDialog(null, "Failed to create secretary: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      //  }
    }

    public static void updateSecretary(int id, String cin, String firstName, String lastName, String email, String phone) {
        Secretary.update(id, cin, firstName, lastName, email, phone);
        //JOptionPane.showMessageDialog(null, "Secretary updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void deleteSecretary(int id) {
        // Call the model method to delete a secretary by ID
            Secretary.delete(id);
    }
}
