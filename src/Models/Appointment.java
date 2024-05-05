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
        String query = "SELECT " +
                "appointments.appointment_id, " +
                "appointments.doctor_id, " +
                "appointments.patient_id, " +
                "appointments.appointment_date, " +
                "appointments.appointment_time, " +
                "appointments.appointment_status, " +
                "appointments.appointment_room, " +
                "doctors.cin AS doctor_cin, " +
                "doctors.first_name AS doctor_first_name, " +
                "doctors.last_name AS doctor_last_name, " +
                "doctors.email AS doctor_email, " +
                "doctors.tele AS doctor_tele, " +
                "doctors.speciality, " +
                "doctors.registration_num, " +
                "patients.cin AS patient_cin, " +
                "patients.first_name AS patient_first_name, " +
                "patients.last_name AS patient_last_name, " +
                "patients.email AS patient_email, " +
                "patients.tele AS patient_tele " +
                "FROM appointments " +
                "JOIN doctors ON appointments.doctor_id = doctors.doctor_id " +
                "JOIN patients ON appointments.patient_id = patients.patient_id;";

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ArrayList<Appointment> appointments = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                appointments.add(new Appointment(
                        resultSet.getInt("appointment_id"),
                        new Patient(
                                resultSet.getInt("patient_id"),
                                resultSet.getString("patient_cin"),
                                resultSet.getString("patient_first_name"),
                                resultSet.getString("patient_last_name"),
                                resultSet.getString("patient_email"),
                                resultSet.getString("patient_tele")
                        ),
                        new Doctor(
                                resultSet.getInt("doctor_id"),
                                resultSet.getString("doctor_cin"),
                                resultSet.getString("doctor_first_name"),
                                resultSet.getString("doctor_last_name"),
                                resultSet.getString("doctor_email"),
                                resultSet.getString("doctor_tele"),
                                Doctor.DoctorSpecialty.valueOf(resultSet.getString("speciality")),
                                resultSet.getString("registration_num")
                        ),
                        resultSet.getDate("appointment_date"),
                        resultSet.getTime("appointment_time"),
                        AppointmentStatus.valueOf(resultSet.getString("appointment_status")),
                        Room.valueOf(resultSet.getString("appointment_room"))
                ));
            }
            resultSet.close();
            statement.close();
            connection.close();
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Appointment get(int id) {
        String query = "SELECT " +
                "appointments.appointment_id, " +
                "appointments.doctor_id, " +
                "appointments.patient_id, " +
                "appointments.appointment_date, " +
                "appointments.appointment_time, " +
                "appointments.appointment_status, " +
                "appointments.appointment_room, " +
                "doctors.cin AS doctor_cin, " +
                "doctors.first_name AS doctor_first_name, " +
                "doctors.last_name AS doctor_last_name, " +
                "doctors.email AS doctor_email, " +
                "doctors.tele AS doctor_tele, " +
                "doctors.speciality, " +
                "doctors.registration_num, " +
                "patients.cin AS patient_cin, " +
                "patients.first_name AS patient_first_name, " +
                "patients.last_name AS patient_last_name, " +
                "patients.email AS patient_email, " +
                "patients.tele AS patient_tele " +
                "FROM appointments " +
                "JOIN doctors ON appointments.doctor_id = doctors.doctor_id " +
                "JOIN patients ON appointments.patient_id = patients.patient_id;" +
                "WHERE appointment_id = ?";
        Appointment appointment = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                appointment = new Appointment(
                        resultSet.getInt("appointment_id"),
                        new Patient(
                                resultSet.getInt("patient_id"),
                                resultSet.getString("patient_cin"),
                                resultSet.getString("patient_first_name"),
                                resultSet.getString("patient_last_name"),
                                resultSet.getString("patient_email"),
                                resultSet.getString("patient_tele")
                        ),
                        new Doctor(
                                resultSet.getInt("doctor_id"),
                                resultSet.getString("doctor_cin"),
                                resultSet.getString("doctor_first_name"),
                                resultSet.getString("doctor_last_name"),
                                resultSet.getString("doctor_email"),
                                resultSet.getString("doctor_tele"),
                                Doctor.DoctorSpecialty.valueOf(resultSet.getString("speciality")),
                                resultSet.getString("registration_num")
                        ),
                        resultSet.getDate("appointment_date"),
                        resultSet.getTime("appointment_time"),
                        AppointmentStatus.valueOf(resultSet.getString("appointment_status")),
                        Room.valueOf(resultSet.getString("appointment_room"))
                );
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

}
