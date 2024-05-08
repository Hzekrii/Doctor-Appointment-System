package Views.Admin.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModifyDoctor extends JFrame {
    private JPanel Panel;
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
    private JTextField specialtyField; // New JTextField for specialty
    private JTextField regNumberField; // New JTextField for registration number

    public ModifyDoctor() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        Panel = new JPanel();
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
        specialtyField = new JTextField(); // Initialize specialty text field
        regNumberField = new JTextField(); // Initialize registration number text field
        modifyDoctorButton = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Modify Doctor");
        setPreferredSize(new Dimension(530, 650));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(530, 650));
        jPanel1.setLayout(null);

        Panel.setBackground(new Color(255, 255, 255));

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

        lastNameField.setFont(new Font("Segoe UI", 1, 18));
        lastNameField.setForeground(new Color(102, 102, 102));

        emailTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        emailTitle.setText("Email");

        emailField.setFont(new Font("Segoe UI", 1, 18));
        emailField.setForeground(new Color(102, 102, 102));

        telephoneTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        telephoneTitle.setText("Telephone");

        telephoneField.setFont(new Font("Segoe UI", 1, 18));
        telephoneField.setForeground(new Color(102, 102, 102));

        specialtyTitle.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Set font for specialty label
        specialtyTitle.setText("Specialty"); // Set text for specialty label

        specialtyField.setFont(new Font("Segoe UI", 1, 18)); // Set font for specialty text field
        specialtyField.setForeground(new Color(102, 102, 102)); // Set text color for specialty text field

        regNumberTitle.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Set font for registration number label
        regNumberTitle.setText("Registration Number"); // Set text for registration number label

        regNumberField.setFont(new Font("Segoe UI", 1, 18)); // Set font for registration number text field
        regNumberField.setForeground(new Color(102, 102, 102)); // Set text color for registration number text field

        modifyDoctorButton.setBackground(new Color(0, 102, 102));
        modifyDoctorButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        modifyDoctorButton.setForeground(new Color(255, 255, 255));
        modifyDoctorButton.setText("Modify Doctor");

        GroupLayout PanelLayout = new GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(modifyDoctorTitle)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(cinTitle)
                                                        .addComponent(firstNameTitle)
                                                        .addComponent(lastNameTitle)
                                                        .addComponent(emailTitle)
                                                        .addComponent(telephoneTitle)
                                                        .addComponent(specialtyTitle) // Add specialty label
                                                        .addComponent(regNumberTitle)) // Add registration number label
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cinField)
                                                        .addComponent(firstNameField)
                                                        .addComponent(lastNameField)
                                                        .addComponent(emailField)
                                                        .addComponent(telephoneField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                        .addComponent(specialtyField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE) // Add specialty text field
                                                        .addComponent(regNumberField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)) // Add registration number text field
                                                .addGap(30, 30, 30))
                                        .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                .addComponent(modifyDoctorButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(modifyDoctorTitle)
                                .addGap(40, 40, 40)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cinTitle)
                                        .addComponent(cinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstNameTitle)
                                        .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastNameTitle)
                                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailTitle)
                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(telephoneTitle)
                                        .addComponent(telephoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(specialtyTitle) // Add specialty label
                                        .addComponent(specialtyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) // Add specialty text field
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(regNumberTitle) // Add registration number label
                                        .addComponent(regNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) // Add registration number text field
                                .addGap(26, 26, 26)
                                .addComponent(modifyDoctorButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
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

    public String getSpecialty() {
        return specialtyField.getText();
    }

    public String getRegistrationNumber() {
        return regNumberField.getText();
    }

    public void initModifyDoctorButtonActionListener(ActionListener listener) {
        modifyDoctorButton.addActionListener(listener);
    }

}
