package Views.Secretary.pages;

import Controllers.AppointmentController;
import Controllers.DoctorController;
import Controllers.PatientController;
import Models.Appointment;
import Models.Doctor;
import Models.Patient;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.SpinnerDateModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class AddNewAppointment extends JFrame {
    private JComboBox<String> doctorComboBox;
    private JComboBox<String> patientComboBox;
    private JComboBox<Appointment.Room> roomComboBox;
    private JDateChooser dateChooser;
    private JSpinner timeSpinner; // Replace JTextField with JSpinner for time input

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
    private Appointments appointments;

    public AddNewAppointment(Appointments a) {
        rooms= Appointment.Room.values();
        patients= PatientController.getPatients();
        doctors= DoctorController.getDoctors();
        doctorNames=new String[doctors.size()];
        patientNames= new String[patients.size()];
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
        appointments=a;
        initAddAppointmentButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from user input fields
                int doctor_id =getDoctor();
                int patient_id=getPatient();
                Date date = getDate();
                Time time = getTime();
                Appointment.Room room = getRoom();
                if(doctor_id != -1 && patient_id!= -1 && date != null && time != null && room != null){
                // Call the appointmentController to create an appointment
                    AppointmentController.createAppointment(getPatient(), getDoctor(), getDate(), getTime(), Appointment.AppointmentStatus.SCHEDULED ,getRoom());
                    appointments.refreshTable();
                    dispose();
                }else{
                    System.out.println("Error In Input Fields");
                }

            }
        });
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

        patientLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        patientLabel.setText("Parient");

        dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dateLabel.setText("Date");

        // Set up time spinner format
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        timeLabel.setText("Time");

        roomLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        roomLabel.setText("Room");

        doctorComboBox.setPreferredSize(new Dimension(150, 30));
        doctorComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        doctorComboBox.setBackground(Color.white);

        patientComboBox.setPreferredSize(new Dimension(150, 30));
        patientComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        patientComboBox.setBackground(Color.white);

        roomComboBox.setPreferredSize(new Dimension(150, 30));
        roomComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        roomComboBox.setBackground(Color.white);

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
                                                        .addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Use dateChooser
                                                        .addComponent(timeSpinner) // Use timeSpinner
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

        pack();
        setVisible(true);
    }

    public int getDoctor() {
        String doctor= (String) doctorComboBox.getSelectedItem();
        for (Doctor d : doctors) {
            String fullName = d.getFirstName() + " " + d.getLastName();
            if (fullName.equals(doctor)) {
                return d.getID();
            }
        }
        System.out.println("doctor selected :"+doctor);
        return -1;
    }

    public int getPatient() {
        String patient= (String) patientComboBox.getSelectedItem();
        for(Patient p: patients){
            String fullName=p.getFirstName()+" "+p.getLastName();
            if(fullName.equals(patient)){
                return p.getID();
            }
        }
        System.out.println("patient selected :"+patient +";"+patients.get(0).getFirstName()+" "+patients.get(0).getLastName());

        return -1;
    }

    public Date getDate() {
        return dateChooser.getDate();
    }

    public Time getTime() {
        Date selectedTime = (Date) timeSpinner.getValue();
        return new Time(selectedTime.getTime());
    }

    public Appointment.Room getRoom() {
        Object selectedItem = roomComboBox.getSelectedItem();
        if (selectedItem != null) {
            String selectedRoomName = selectedItem.toString();
            for (Appointment.Room r : Appointment.Room.values()) {
                if (r.name().equalsIgnoreCase(selectedRoomName)) {
                    return r;
                }
            }
        }
        return null;
    }


    public void initAddAppointmentButtonActionListener(ActionListener listener) {
        addAppointmentButton.addActionListener(listener);
    }

}