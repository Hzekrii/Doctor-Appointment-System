package Controllers;

import Models.Doctor;
import enums.DoctorSpecialty;

import java.util.ArrayList;

public class DoctorController {

    public static ArrayList<Doctor> getDoctors () { return Doctor.all(); }

    public static Doctor getDoctor(int id) { return Doctor.get(id); }

    public static void createDoctor(String cin, String firstName, String lastName, String email, String phone, DoctorSpecialty speciality, int registrationNum) {
        Doctor.create(cin, firstName, lastName, email, phone, speciality, registrationNum);
    }

    public static void updateDoctor(int id, String cin, String firstName, String lastName, String email, String phone, DoctorSpecialty speciality, int registrationNum) {
        Doctor.update(id, cin, firstName, lastName, email, phone, speciality, registrationNum);
    }

    public static void deleteDoctor(int id) { Doctor.delete(id); }

    public static int getIDByFullName(String firstName, String lastName) {
        return Doctor.getIDByFullName(firstName, lastName);
    }
}
