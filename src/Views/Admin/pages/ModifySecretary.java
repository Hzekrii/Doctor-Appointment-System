package Views.Admin.pages;

import Controllers.SecretaryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModifySecretary extends JFrame {
    private JPanel Panel;
    private JButton modifySecretaryButton;
    private JLabel modifySecretaryTitle;
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

    private Secretaries secretaries;
    private int id;

    public ModifySecretary(Secretaries s,int id, String cin, String firstName, String lastName, String email, String phone) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
        cinField.setText(cin);
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        emailField.setText(email);
        telephoneField.setText(phone);
        this.id = id;
        secretaries = s;
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        Panel = new JPanel();
        modifySecretaryTitle = new JLabel();
        cinTitle=new JLabel();
        firstNameTitle = new JLabel();
        lastNameTitle = new JLabel();
        emailTitle = new JLabel();
        telephoneTitle = new JLabel();
        cinField= new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        telephoneField = new JTextField();
        modifySecretaryButton = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Modify Secretary");
        setPreferredSize(new Dimension(470, 650));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(470, 650));
        jPanel1.setLayout(null);

        Panel.setBackground(new Color(255, 255, 255));

        modifySecretaryTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        modifySecretaryTitle.setForeground(new Color(0, 102, 102));
        modifySecretaryTitle.setText("Modify Secretary");
        modifySecretaryTitle.setHorizontalAlignment(SwingConstants.CENTER);

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

        modifySecretaryButton.setBackground(new Color(0, 102, 102));
        modifySecretaryButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        modifySecretaryButton.setForeground(new Color(255, 255, 255));
        modifySecretaryButton.setText("Modify Secretary");
        modifySecretaryButton.addActionListener(e -> {
            SecretaryController.updateSecretary(id,getCIN(), getFirstName(), getLastName(), getEmail(), getTelephone());
            secretaries.refreshTable();
            dispose();
        });

        GroupLayout PanelLayout = new GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(modifySecretaryTitle)
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
                                                .addComponent(modifySecretaryButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(modifySecretaryTitle)
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
                                .addComponent(modifySecretaryButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
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

        getAccessibleContext().setAccessibleName("MODIFYSECRETARY");

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

    public void initModifySecretaryButtonActionListener(ActionListener listener) {
        modifySecretaryButton.addActionListener(listener);
    }
}
