package Views.Admin.pages;

import Controllers.DoctorController;
import Models.Appointment;
import Models.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyDoctor extends JFrame {
    private JPanel panel;
    private JButton modifyDoctorButton;
    private JLabel modifyDoctorTitle;
    private JLabel cinTitle;
    private JLabel firstNameTitle;
    private JLabel lastNameTitle;
    private JLabel emailTitle;
    private JLabel telephoneTitle;
    private JLabel specialtyTitle; // New JLabel for specialty
    private JLabel regNumberTitle; // New JLabel for registration number
    private JTextField cinField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField telephoneField;
    private JComboBox<Doctor.DoctorSpecialty> specialtyComboBox; // New JComboBox for specialty
    private JTextField regNumberField; // New JTextField for registration number
    private Doctor.DoctorSpecialty[] specialties ;
    private Doctors doctors;
    private int id;


    public ModifyDoctor(Doctors d, int id,String cin, String firstName, String lastName, String email, String phone,Doctor.DoctorSpecialty speciality,String registration_num) {
        specialties=Doctor.DoctorSpecialty.values();
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
        cinField.setText(cin);
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        emailField.setText(email);
        telephoneField.setText(phone);
        regNumberField.setText(registration_num);
        for (int i = 0; i < specialties.length; i++) {
            if (specialties[i].name().equalsIgnoreCase(speciality.name())) {
                specialtyComboBox.setSelectedIndex(i);
                break;
            }
        }
        this.id=id;
        doctors=d;

        initModifyDoctorButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from user input fields
                Doctor.DoctorSpecialty specialty=getSpecialty();
                if(specialty != null){
                    DoctorController.updateDoctor(id,getCIN(),getFirstName(),getLastName(),getEmail(),getTelephone(),getSpecialty(),getRegistrationNumber());
                    doctors.refreshTable();
                    dispose();
                }else{
                    System.out.println("Error In Input Fields");
                }
            }
        });

    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        panel = new JPanel();
        modifyDoctorTitle = new JLabel();
        cinTitle = new JLabel();
        firstNameTitle = new JLabel();
        lastNameTitle = new JLabel();
        emailTitle = new JLabel();
        telephoneTitle = new JLabel();
        specialtyTitle = new JLabel(); // Initialize specialty label
        regNumberTitle = new JLabel(); // Initialize registration number label
        cinField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        telephoneField = new JTextField();
        specialtyComboBox = new JComboBox<>(specialties); // Initialize specialty combo box
        regNumberField = new JTextField(); // Initialize registration number text field
        modifyDoctorButton = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Modify Doctor");
        setPreferredSize(new Dimension(530, 650));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(530, 650));
        jPanel1.setLayout(null);

        panel.setBackground(new Color(255, 255, 255));

        modifyDoctorTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        modifyDoctorTitle.setForeground(new Color(0, 102, 102));
        modifyDoctorTitle.setText("Modify Doctor");
        modifyDoctorTitle.setHorizontalAlignment(SwingConstants.CENTER);

        cinTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cinTitle.setText("CIN");

        cinField.setFont(new Font("Segoe UI", 1, 18));
        cinField.setForeground(new Color(102, 102, 102));

        firstNameTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        firstNameTitle.setText("First Name");

        firstNameField.setFont(new Font("Segoe UI", 1, 18));
        firstNameField.setForeground(new Color(102, 102, 102));

        lastNameTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lastNameTitle.setText("Last Name");

        lastNameField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lastNameField.setForeground(new Color(102, 102, 102));

        emailTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        emailTitle.setText("Email");

        emailField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        emailField.setForeground(new Color(102, 102, 102));

        telephoneTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        telephoneTitle.setText("Telephone");

        telephoneField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        telephoneField.setForeground(new Color(102, 102, 102));

        specialtyTitle.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Set font for specialty label
        specialtyTitle.setText("Specialty"); // Set text for specialty label

        specialtyComboBox.setPreferredSize(new Dimension(150, 30));
        specialtyComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        specialtyComboBox.setBackground(Color.white);

        regNumberTitle.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Set font for registration number label
        regNumberTitle.setText("Registration Number"); // Set text for registration number label

        regNumberField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        regNumberField.setForeground(new Color(102, 102, 102));

        modifyDoctorButton.setBackground(new Color(0, 102, 102));
        modifyDoctorButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        modifyDoctorButton.setForeground(new Color(255, 255, 255));
        modifyDoctorButton.setText("Modify Doctor");

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(modifyDoctorTitle)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(cinTitle)
                                                        .addComponent(firstNameTitle)
                                                        .addComponent(lastNameTitle)
                                                        .addComponent(emailTitle)
                                                        .addComponent(telephoneTitle)
                                                        .addComponent(specialtyTitle) // Add specialty label
                                                        .addComponent(regNumberTitle)) // Add registration number label
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cinField)
                                                        .addComponent(firstNameField)
                                                        .addComponent(lastNameField)
                                                        .addComponent(emailField)
                                                        .addComponent(telephoneField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                        .addComponent(specialtyComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Add specialty combo box
                                                        .addComponent(regNumberField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)) // Add registration number text field
                                                .addGap(30, 30, 30))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(modifyDoctorButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(modifyDoctorTitle)
                                .addGap(40, 40, 40)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cinTitle)
                                        .addComponent(cinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstNameTitle)
                                        .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastNameTitle)
                                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailTitle)
                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(telephoneTitle)
                                        .addComponent(telephoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(specialtyTitle) // Add specialty label
                                        .addComponent(specialtyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) // Add specialty combo box
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(regNumberTitle) // Add registration number label
                                        .addComponent(regNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) // Add registration number text field
                                .addGap(26, 26, 26)
                                .addComponent(modifyDoctorButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(panel);
        panel.setBounds(0, 0, 500, 600);

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

        getAccessibleContext().setAccessibleName("MODIFYDOCTOR");

        pack();
        setVisible(true);
    }

    public String getCIN() {
        return cinField.getText();
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getTelephone() {
        return telephoneField.getText();
    }

    public Doctor.DoctorSpecialty getSpecialty() {
        Object selectedItem = specialtyComboBox.getSelectedItem();
        if (selectedItem != null) {
            String selectedSpecialityName = selectedItem.toString();
            for (Doctor.DoctorSpecialty s : Doctor.DoctorSpecialty.values()) {
                if (s.name().equalsIgnoreCase(selectedSpecialityName)) {
                    return s;
                }
            }
        }
        return null;
    }
    public int getRegistrationNumber() {
        return Integer.parseInt(regNumberField.getText());
    }

    public void initModifyDoctorButtonActionListener(ActionListener listener) {
        modifyDoctorButton.addActionListener(listener);
    }

}
