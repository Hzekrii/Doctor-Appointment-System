package Models;

import Database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Appointment {

    public enum AppointmentStatus {

    }

    public enum Room {

    }

    // attributes
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private Time time;
    private AppointmentStatus appointmentStatus;
    private Room room;

    // constructor
    public Appointment(int id, Patient patient, Doctor doctor, Date date, Time time, AppointmentStatus appointmentStatus, Room room) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.appointmentStatus = appointmentStatus;
        this.room = room;
    }

    // getters
    public int getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public Date getDate() { return date; }
    public Time getTime() { return time; }
    public Room getRoom() { return room; }
    public AppointmentStatus getAppointmentStatus() { return appointmentStatus; }

    public ArrayList<Appointment> all() {
        String query = "SELECT * FROM appointments;";
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ArrayList<Appointment> appointments = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                appointments.add(new Appointment(
                        resultSet.getInt("appointment_id"),
                        resultSet.getObject("patient_id", Patient.class),
                        resultSet.getObject("doctor_id", Doctor.class),
                        resultSet.getDate("appointment_date"),
                        resultSet.getTime("appointment_time"),
                        AppointmentStatus.valueOf(resultSet.getString("appointment_status")),
                        Room.valueOf(resultSet.getString("appointment_room"))
                ));
            }
            statement.close();
            connection.close();
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Appointment get(int id) {
        String query = "SELECT * FROM appointments WHERE appointment_id = ?;";
        Appointment appointment = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                appointment = new Appointment(
                        resultSet.getInt("appointment_id"),
                        resultSet.getObject("patient_id", Patient.class),
                        resultSet.getObject("doctor_id", Doctor.class),
                        resultSet.getDate("appointment_date"),
                        resultSet.getTime("appointment_time"),
                        AppointmentStatus.valueOf(resultSet.getString("appointment_status")),
                        Room.valueOf(resultSet.getString("appointment_room"))
                );
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

}
