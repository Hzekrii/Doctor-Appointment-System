package Views.Secretary.pages;

import Controllers.PatientController;
import Controllers.SecretaryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddNewPatient extends JFrame {
    private JPanel Panel;
    private JButton addPatientButton;
    private JLabel addPatientTitle;
    private JLabel cinTitle;
    private JLabel firstNameTitle;
    private JLabel lastNameTitle;
    private JLabel emailTitle;
    private JLabel telephoneTitle;
    private JTextField cinField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField telephoneField;

    private Patients patients_page;

    public AddNewPatient(Patients p) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
        patients_page = p;
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        Panel = new JPanel();
        addPatientTitle = new JLabel();
        cinTitle = new JLabel();
        firstNameTitle = new JLabel();
        lastNameTitle = new JLabel();
        emailTitle = new JLabel();
        telephoneTitle = new JLabel();
        cinField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        telephoneField = new JTextField();
        addPatientButton = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add a New Patient");
        setPreferredSize(new Dimension(470, 650));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(470, 650));
        jPanel1.setLayout(null);

        Panel.setBackground(new Color(255, 255, 255));

        addPatientTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        addPatientTitle.setForeground(new Color(0, 102, 102));
        addPatientTitle.setText("Add a New Patient");
        addPatientTitle.setHorizontalAlignment(SwingConstants.CENTER);

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

        addPatientButton.setBackground(new Color(0, 102, 102));
        addPatientButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        addPatientButton.setForeground(new Color(255, 255, 255));
        addPatientButton.setText("Add Patient");

        addPatientButton.addActionListener(e -> {
            PatientController.createPatient(getCIN(), getFirstName(), getLastName(), getEmail(), getTelephone());
            patients_page.refreshTable();
            dispose();
        });

        GroupLayout PanelLayout = new GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addPatientTitle)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(cinTitle)
                                                        .addComponent(firstNameTitle)
                                                        .addComponent(lastNameTitle)
                                                        .addComponent(emailTitle)
                                                        .addComponent(telephoneTitle))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cinField)
                                                        .addComponent(firstNameField)
                                                        .addComponent(lastNameField)
                                                        .addComponent(emailField)
                                                        .addComponent(telephoneField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                                .addGap(30, 30, 30))
                                        .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                .addComponent(addPatientButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(addPatientTitle)
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
                                .addGap(26, 26, 26)
                                .addComponent(addPatientButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
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

        getAccessibleContext().setAccessibleName("ADDPATIENT");

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

}
