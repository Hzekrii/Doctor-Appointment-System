package Controllers;

import Models.Appointment;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentController {

    public static ArrayList<Appointment> getAppointments () { return Appointment.all(); }

    public static Appointment getAppointment(int id) { return Appointment.get(id); }

    public static void createAppointment(int patient, int doctor, Date date, Time time, Appointment.AppointmentStatus appointmentStatus, Appointment.Room room) {
        Appointment.create(patient, doctor, date, time, appointmentStatus, room);
    }

    public static void updateAppointment(int id, int patient, int doctor, Date date, Time time, Appointment.AppointmentStatus appointmentStatus, Appointment.Room room) {
        Appointment.update(id, patient, doctor, date, time, appointmentStatus, room);
    }

    public static void deleteAppointment(int id) { Appointment.delete(id); }
}
