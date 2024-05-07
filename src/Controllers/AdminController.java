package Controllers;

import Models.Admin;

import java.util.ArrayList;

public class AdminController {
    private AdminController(){

    }
    // Admin
    public static Admin getAdmin(int id) {
        // Call the model method to retrieve a secretary by ID
        return Admin.get(id);
    }
    public static void updateAdmin(int id, String cin, String firstName, String lastName, String email, String phone) {
        Admin.update(id, cin, firstName, lastName, email, phone);
    }

}
