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
        return Secretary.all();
    }

    public static Secretary getSecretary(int id) {
        // Call the model method to retrieve a secretary by ID
        return Secretary.get(id);
    }

    public static void createSecretary(String cin, String firstName, String lastName, String email, String phone) {
        Secretary.create(cin, firstName, lastName, email, phone);
        Integer id = LoginController.cerateCredentials(lastName, cin, "Secretary");
        if(id != null) {
            Secretary.addLoginID(id, cin);
        }
    }

    public static void updateSecretary(String cin, String firstName, String lastName, String email, String phone) {
        Secretary.update(cin, firstName, lastName, email, phone);
    }

    public static void deleteSecretary(String cin) {
        // Call the model method to delete a secretary by CIN
            Secretary.delete(cin);
    }
}
