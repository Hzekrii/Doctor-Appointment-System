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

    public static void delete(int id) {
        String query = "DELETE FROM patients WHERE patient_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(int id, String cin, String firstName, String lastName, String email, String phone) {
        String query = "UPDATE patient SET cin = ?, first_name = ?, last_name = ?, email = ?, tele = ? WHERE patient_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cin);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, email);
            statement.setString(5, phone);
            statement.setInt(6, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
