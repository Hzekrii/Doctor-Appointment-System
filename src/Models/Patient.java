package Models;

import Database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class Patient extends Person{

    public Patient(int id, String cin, String firstName, String lastName, String email, String phone){
        super(id, cin, firstName, lastName, email, phone);
    }

    public static ArrayList<Patient> all() {
        String query = "SELECT * FROM patients";
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            ArrayList<Patient> patients = new ArrayList<>();
            while(result.next()){
                patients.add(new Patient(
                        result.getInt("patient_id"),
                        result.getString("cin"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("tele")
                ));
            }
            result.close();
            statement.close();
            connection.close();
            return patients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Patient get(int id) {
        String query = "SELECT * FROM patients WHERE patient_id = ?";
        Patient patient = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                patient = new Patient(
                        result.getInt("patient_id"),
                        result.getString("cin"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("tele")
                );
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public static void create(String cin, String firstName, String lastName, String email, String phone) {
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

    public static void delete(String cin) {
        String query = "DELETE FROM patients WHERE cin = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cin);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(String cin, String firstName, String lastName, String email, String phone) {
        String query = "UPDATE patients SET first_name = ?, last_name = ?, email = ?, tele = ? WHERE cin = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, cin);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getIDByFullName(String firstName, String lastName) {
        String query = "SELECT patient_id FROM patients WHERE first_name = ? AND last_name = ?";
        int patient = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                patient = result.getInt("patient_id");
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }
}
