package Models;

import Database.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Secretary {
    private int id;
    private String cin;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int login_id ;


    public Secretary(int id,String cin,String firstName,String lastName,String email,String phone){
        this.id=id;
        this.cin=cin;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;

    }

    public void add() throws SQLException, IOException {
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
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
