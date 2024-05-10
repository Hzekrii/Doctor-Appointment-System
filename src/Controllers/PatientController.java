package Controllers;

import Models.Doctor;
import Models.Patient;

import java.util.ArrayList;

public class PatientController {

    public static ArrayList<Patient> getPatients () { return Patient.all(); }

    public static Patient getPatient(int id) { return Patient.get(id); }

    public static void createPatient(String cin, String firstName, String lastName, String email, String phone) {
        Patient.create(cin, firstName, lastName, email, phone);
    }

    public static void updatePatient(String cin, String firstName, String lastName, String email, String phone) {
        Patient.update(cin, firstName, lastName, email, phone);
    }

    public static void deletePatient(String cin) { Patient.delete(cin); }

    public static int getIDByFullName(String firstName, String lastName) {
        return Patient.getIDByFullName(firstName, lastName);
    }
}
