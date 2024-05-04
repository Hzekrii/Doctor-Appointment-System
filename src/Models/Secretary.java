package Models;

import Database.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Secretary extends Person{

    public Secretary(int id, String cin, String firstName, String lastName, String email, String phone){
        super(id,cin,firstName,lastName,email,phone);
    }
    public static ArrayList<Secretary> all() {
        String query = "SELECT * FROM secretaries";
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            ArrayList<Secretary> secretaries = new ArrayList<>();
            while(result.next()){
                secretaries.add(new Secretary(
                        result.getInt("secretary_id"),
                        result.getString("cin"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("tele")
                ));
            }
            statement.close();
            connection.close();
            return secretaries;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Secretary get(int id) {
        String query = "SELECT * FROM secretaries WHERE secretary_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return new Secretary(
                        result.getInt("secretary_id"),
                        result.getString("cin"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("tele")
                );
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void create(String cin, String firstName, String lastName, String email, String phone) {
        String query = "INSERT INTO secretaries(cin, first_name, last_name, email, tele,login_id) VALUES (?, ?, ?, ?, ?,null)";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM secretaries WHERE secretary_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(int id, String cin, String firstName, String lastName, String email, String phone) {
        String query = "UPDATE secretaries SET cin=?,first_name = ?, last_name = ?, email = ?, tele = ? WHERE secretary_id=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

