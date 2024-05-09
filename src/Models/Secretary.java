package Models;

import Database.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

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
            result.close();
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
        Secretary secretary = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                secretary = new Secretary(
                        result.getInt("secretary_id"),
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
        return secretary;
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

    public static void delete(String cin) {
        String query = "DELETE FROM secretaries WHERE cin = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String cin, String firstName, String lastName, String email, String phone) {
        String query = "UPDATE secretaries SET first_name = ?, last_name = ?, email = ?, tele = ? WHERE cin=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, cin);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addLoginID(Integer id, String cin) {
        String query = "UPDATE secretaries SET login_id = ? WHERE cin = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id.intValue());
            preparedStatement.setString(2, cin);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getLoginID(String cin){
        String query = "SELECT login_id FROM secretaries WHERE cin = ?";
        int login_id = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            ResultSet resultset = preparedStatement.executeQuery();
            if(resultset.next()){
                login_id = resultset.getInt("login_id");
            }
            resultset.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login_id;
    }
}

