package Views.Secretary.pages;

import com.toedter.calendar.JDateChooser;

import Controllers.AppointmentController;
import Controllers.DoctorController;
import Controllers.PatientController;
import Models.Appointment;
import Models.Doctor;
import Models.Patient;

import javax.swing.*;
import javax.swing.SpinnerDateModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;

public class AddNewAppointment extends JFrame {
    private JComboBox<String> doctorComboBox;
    private JDateChooser dateChooser;
    private JSpinner timeSpinner; // Replace JTextField with JSpinner for time input
    private JComboBox<String> patientComboBox;
    private JComboBox<Appointment.Room> roomComboBox;


    private JPanel Panel;
    private JButton addAppointmentButton;
    private JLabel addAppointmentTitle;
    private JLabel doctorLabel;
    private JLabel patientLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel roomLabel;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private String[] doctorNames;
    private String[] patientNames;
    private Appointment.Room[] rooms;

    public AddNewAppointment() {
        rooms= Appointment.Room.values();
        patients= PatientController.getPatients();
        doctors= DoctorController.getDoctors();
        doctorNames=new String[doctors.size()];
        patientNames= new String[patients.size()];
        initAddAppointmentButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from user input fields
                int doctor_id =getDoctor();
                int patient_id=getPatient();
                Date date = getDate();
                Time time = getTime();
                Appointment.Room room = getRoom();

                // Call the appointmentController to create an appointment
                AppointmentController.createAppointment(patient_id, doctor_id, date, time, Appointment.AppointmentStatus.SCHEDULED ,room);

                // Optionally, you can perform additional actions after creating the appointment
            }
        });
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        Panel = new JPanel();
        addAppointmentTitle = new JLabel();
        doctorLabel = new JLabel();
        patientLabel = new JLabel();
        dateLabel = new JLabel();
        timeLabel = new JLabel();
        roomLabel = new JLabel();
        int index=0;
        for(Patient patient: patients){
           String fullName= patient.getFirstName()+" "+patient.getLastName();
           patientNames[index++]=fullName;
        }
        index=0;
        for(Doctor doctor: doctors){
            String fullName= doctor.getFirstName()+" "+doctor.getLastName();
            doctorNames[index++]=fullName;
        }
       // doctorNames = addDefaultDoctorOption(doctorNames);
       // patientNames = addDefaultPatientOption(patientNames);
        doctorComboBox = new JComboBox<>(doctorNames);
        patientComboBox = new JComboBox<>(patientNames);
        roomComboBox = new JComboBox<>(rooms);
        dateChooser = new JDateChooser();
        timeSpinner = new JSpinner(new SpinnerDateModel()); // Initialize the time spinner
        addAppointmentButton = new JButton();

        // Set preferred height for date chooser and time spinner
        dateChooser.setPreferredSize(new Dimension(150, 30)); // Set the preferred size for dateChooser
        timeSpinner.setPreferredSize(new Dimension(150, 30)); // Set the preferred size for timeSpinner

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add a New Appointment");
        setPreferredSize(new Dimension(470, 650));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(470, 650));
        jPanel1.setLayout(null);

        Panel.setBackground(new Color(255, 255, 255));

        addAppointmentTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        addAppointmentTitle.setForeground(new Color(0, 102, 102));
        addAppointmentTitle.setText("Add a New Appointment");
        addAppointmentTitle.setHorizontalAlignment(SwingConstants.CENTER);

        doctorLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        doctorLabel.setText("Doctor");

        doctorComboBox.setPreferredSize(new Dimension(150, 30));
        doctorComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        doctorComboBox.setBackground(Color.white);

        patientLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        patientLabel.setText("Patient");

        patientComboBox.setPreferredSize(new Dimension(150, 30));
        patientComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        patientComboBox.setBackground(Color.white);

        dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dateLabel.setText("Date");

        // Set up time spinner format
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        timeLabel.setText("Time");

        roomLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        roomLabel.setText("Room");

        addAppointmentButton.setBackground(new Color(0, 102, 102));
        addAppointmentButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        addAppointmentButton.setForeground(new Color(255, 255, 255));
        addAppointmentButton.setText("Add Appointment");

        GroupLayout PanelLayout = new GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addAppointmentTitle)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(doctorLabel)
                                                        .addComponent(patientLabel)
                                                        .addComponent(dateLabel)
                                                        .addComponent(timeLabel)
                                                        .addComponent(roomLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(doctorComboBox)
                                                        .addComponent(patientComboBox)
                                                        .addComponent(roomComboBox, 0, 300, Short.MAX_VALUE))
                                                .addGap(30, 30, 30))
                                        .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                .addComponent(addAppointmentButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(addAppointmentTitle)
                                .addGap(40, 40, 40)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(doctorLabel)
                                        .addComponent(doctorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientLabel)
                                        .addComponent(patientComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) // Use dateChooser
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(timeLabel)
                                        .addComponent(timeSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) // Use timeSpinner
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(roomLabel)
                                        .addComponent(roomComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(addAppointmentButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(Panel);
        Panel.setBounds(0, 0, 500, 600);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("ADDAPPOINTMENT");

        // Set default selected items in doctorComboBox , patientComboBox and roomComboBox
        doctorComboBox.setSelectedIndex(0);
        patientComboBox.setSelectedIndex(0);
        roomComboBox.setSelectedIndex(0);

        pack();
        setVisible(true);
    }

    // Method to add a default "Select" option to the beginning of the array
    private String[] addDefaultOption(String[] array, String defaultOption) {
        String[] arrayWithDefault = new String[array.length + 1];
        arrayWithDefault[0] = defaultOption; // Default option
        System.arraycopy(array, 0, arrayWithDefault, 1, array.length);
        return arrayWithDefault;
    }

  /*  // Method to add a default "Select Doctor" option to the beginning of the doctor names array
    private String[] addDefaultDoctorOption(String[] array) {
        return addDefaultOption(array, "...");
    }

    // Method to add a default "Select Patient" option to the beginning of the patient names array
    private String[] addDefaultPatientOption(String[] array) {
        return addDefaultOption(array, "...");
    }

    // Method to add a default "Select Room" option to the beginning of the Room enum array
    private Appointment.Room[] addDefaultRoomOption(Appointment.Room[] rooms) {
        Appointment.Room[] roomsWithDefault = new Appointment.Room[rooms.length + 1];
        roomsWithDefault[0] = null; // Default option
        System.arraycopy(rooms, 0, roomsWithDefault, 1, rooms.length);
        return roomsWithDefault;
    }*/


    public int getDoctor() {
        String doctor= (String) doctorComboBox.getSelectedItem();
        for(Doctor d: doctors){
            if(d.getFirstName()+" "+d.getLastName() == doctor){
                return d.getID();
            }
        }
        return -1;
    }

    public int getPatient() {
        String patient= (String) patientComboBox.getSelectedItem();
        for(Patient p: patients){
            if(p.getFirstName()+" "+p.getLastName() == patient){
                return p.getID();
            }
        }
        return -1;
    }

    public Date getDate() {
        return dateChooser.getDate();
    }

    public Time getTime() {
        return (Time) timeSpinner.getValue();
    }



    public Appointment.Room getRoom() {

        for(Appointment.Room r : Appointment.Room.values()){
            if(r.name().equalsIgnoreCase((String) roomComboBox.getSelectedItem())){
                return r;
            }
        }
        return null;
    }

    public void initAddAppointmentButtonActionListener(ActionListener listener) {
        addAppointmentButton.addActionListener(listener);
    }

}
