package Models;

import Database.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient {
    private int id;
    private String cin;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Patient(int id, String cin, String firstName, String lastName, String email, String phone) throws SQLException, IOException {
        this.id = id;
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        add();
    }

    public void add() throws SQLException, IOException {
        String query = "INSERT INTO patients(cin, first_name, last_name, email, tele) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
