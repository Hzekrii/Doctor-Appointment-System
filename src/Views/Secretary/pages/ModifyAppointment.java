package Views.Secretary.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModifyAppointment extends JFrame {
    private JComboBox<String> doctorComboBox;
    private JComboBox<String> appointmentComboBox;
    private JComboBox<String> statusComboBox;
    private JComboBox<String> roomComboBox;
    private JTextField dateField;
    private JTextField timeField;

    private JPanel Panel;
    private JButton modifyAppointmentButton;
    private JLabel modifyAppointmentTitle;
    private JLabel doctorLabel;
    private JLabel patientLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel statusLabel;
    private JLabel roomLabel;

    private String[] patients = {"patient1", "patient2"};
    private String[] doctors = {"doctor1", "doctor2"};
    private String[] statusValues = {"CANCELLED", "COMPLETED"};
    private String[] rooms = {"room1", "room2"};

    public ModifyAppointment() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        Panel = new JPanel();
        modifyAppointmentTitle = new JLabel();
        doctorLabel = new JLabel();
        patientLabel = new JLabel();
        dateLabel = new JLabel();
        timeLabel = new JLabel();
        statusLabel = new JLabel();
        roomLabel = new JLabel();
        doctorComboBox = new JComboBox<>(doctors);
        appointmentComboBox = new JComboBox<>(patients);
        statusComboBox = new JComboBox<>(statusValues);
        roomComboBox = new JComboBox<>(rooms);
        dateField = new JTextField();
        timeField = new JTextField();
        modifyAppointmentButton = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Modify Appointment");
        setPreferredSize(new Dimension(470, 650));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(470, 650));
        jPanel1.setLayout(null);

        Panel.setBackground(new Color(255, 255, 255));

        modifyAppointmentTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        modifyAppointmentTitle.setForeground(new Color(0, 102, 102));
        modifyAppointmentTitle.setText("Modify Appointment");
        modifyAppointmentTitle.setHorizontalAlignment(SwingConstants.CENTER);

        doctorLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        doctorLabel.setText("Doctor");

        doctorComboBox.setPreferredSize(new Dimension(150, 30));
        doctorComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        doctorComboBox.setBackground(Color.white);

        patientLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        patientLabel.setText("Patient");

        appointmentComboBox.setPreferredSize(new Dimension(150, 30));
        appointmentComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        appointmentComboBox.setBackground(Color.white);

        dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dateLabel.setText("Date");

        dateField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        timeLabel.setText("Time");

        timeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        statusLabel.setText("Status");

        statusComboBox.setPreferredSize(new Dimension(150, 30));
        statusComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statusComboBox.setBackground(Color.white);

        roomLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        roomLabel.setText("Room");

        roomComboBox.setPreferredSize(new Dimension(150, 30));
        roomComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        roomComboBox.setBackground(Color.white);

        modifyAppointmentButton.setBackground(new Color(0, 102, 102));
        modifyAppointmentButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        modifyAppointmentButton.setForeground(new Color(255, 255, 255));
        modifyAppointmentButton.setText("Modify Appointment");

        GroupLayout PanelLayout = new GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(modifyAppointmentTitle)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(doctorLabel)
                                                        .addComponent(patientLabel)
                                                        .addComponent(dateLabel)
                                                        .addComponent(timeLabel)
                                                        .addComponent(statusLabel)
                                                        .addComponent(roomLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(doctorComboBox)
                                                        .addComponent(appointmentComboBox)
                                                        .addComponent(dateField)
                                                        .addComponent(timeField)
                                                        .addComponent(statusComboBox)
                                                        .addComponent(roomComboBox, 0, 300, Short.MAX_VALUE))
                                                .addGap(30, 30, 30))
                                        .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                .addComponent(modifyAppointmentButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(modifyAppointmentTitle)
                                .addGap(40, 40, 40)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(doctorLabel)
                                        .addComponent(doctorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientLabel)
                                        .addComponent(appointmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(timeLabel)
                                        .addComponent(timeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(statusLabel)
                                        .addComponent(statusComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(roomLabel)
                                        .addComponent(roomComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(modifyAppointmentButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
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

        getAccessibleContext().setAccessibleName("MODIFYAPPOINTMENT");

        pack();
        setVisible(true);
    }

    public String getDoctor() {
        return (String) doctorComboBox.getSelectedItem();
    }

    public String getAppointment() {
        return (String) appointmentComboBox.getSelectedItem();
    }

    public String getDate() {
        return dateField.getText();
    }

    public String getTime() {
        return timeField.getText();
    }

    public String getStatus() {
        return (String) statusComboBox.getSelectedItem();
    }

    public String getRoom() {
        return (String) roomComboBox.getSelectedItem();
    }

    public void initModifyAppointmentButtonActionListener(ActionListener listener) {
        modifyAppointmentButton.addActionListener(listener);
    }

}
