package Models;

import Database.DBConnection;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;

public class Doctor extends Person{

    public enum DoctorSpecialty {
        GENERAL_PRACTITIONER,
        CARDIOLOGIST,
        DERMATOLOGIST,
        NEUROLOGIST,
        ORTHOPEDIST
    }

    // attributes
    private DoctorSpecialty speciality;
    private int registrationNum;

    // constructor
    public Doctor(int id, String cin, String firstName, String lastName, String email, String phone, DoctorSpecialty speciality, int registrationNum) {
        super(id, cin, firstName, lastName, email, phone);
        this.speciality = speciality;
        this.registrationNum = registrationNum;
    }

    // getters
    public DoctorSpecialty getSpeciality() { return this.speciality; }
    public int getRegistrationNum() { return this.registrationNum; }


    public static ArrayList<Doctor> all() {
        String query = "SELECT * FROM doctors";
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            ArrayList<Doctor> doctors = new ArrayList<>();
            while(result.next()){
                doctors.add(new Doctor(
                        result.getInt("doctor_id"),
                        result.getString("cin"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("tele"),
                        DoctorSpecialty.valueOf(result.getString("speciality")),
                        result.getInt("registration_num")
                ));
            }
            result.close();
            statement.close();
            connection.close();
            return doctors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Doctor get(int id) {
        String query = "SELECT * FROM doctors WHERE doctor_id = ?";
        Doctor doctor = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                doctor = new Doctor(
                        result.getInt("doctor_id"),
                        result.getString("cin"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("tele"),
                        DoctorSpecialty.valueOf(result.getString("speciality")),
                        result.getInt("registration_num")
                );
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public static void create(String cin, String firstName, String lastName, String email, String phone, DoctorSpecialty speciality, int registrationNum) {
        String query = "INSERT INTO doctors(cin, first_name, last_name, email, tele, speciality, registration_num) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, speciality.toString());
            preparedStatement.setInt(7, registrationNum);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM doctors WHERE doctor_id = ?";
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

    public static void update(int id, String cin, String firstName, String lastName, String email, String phone, DoctorSpecialty speciality, int registrationNum) {
        String query = "UPDATE doctors SET cin = ?, first_name = ?, last_name = ?, email = ?, tele = ?, speciality = ?, registration_num = ? WHERE doctor_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cin);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, email);
            statement.setString(5, phone);
            statement.setString(6, speciality.toString());
            statement.setInt(7, registrationNum);
            statement.setInt(8, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getIDByFullName(String firstName, String lastName) {
        String query = "SELECT doctor_id FROM doctors WHERE first_name = ? AND last_name = ?";
        int doctor = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                doctor = result.getInt("doctor_id");
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }
}
