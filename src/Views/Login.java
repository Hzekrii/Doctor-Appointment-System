package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JComboBox<String> roleComboBox;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel Left;
    private JPanel Right;
    private JButton loginButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public Login() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        Right = new JPanel();
        Left = new JPanel();
        JLabel logoLabel = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        loginButton = new JButton();

        ImageIcon logoIcon = new ImageIcon("assets/icons/logo.png");
        Image logoImage = logoIcon.getImage(); // Get the image from the icon
        Image scaledLogo = logoImage.getScaledInstance(110, 110,  java.awt.Image.SCALE_SMOOTH); // Resize the image to 100x100 with anti-aliasing
        logoLabel.setIcon(new ImageIcon(scaledLogo));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setPreferredSize(new Dimension(1240, 600)); // Updated size
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(1240, 600)); // Updated size
        jPanel1.setLayout(null);

        Right.setBackground(new Color(0, 102, 102));

        Right.add(logoLabel);

        jLabel6.setFont(new Font("Showcard Gothic", 1, 36)); // Updated font size
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("Hospital Appointment System");

        jLabel7.setFont(new Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel7.setForeground(new Color(204, 204, 204));

        GroupLayout RightLayout = new GroupLayout(Right);
        Right.setLayout(RightLayout);
        jLabel5.setText(""); // Assuming jLabel5 is not used for anything else
        RightLayout.setHorizontalGroup(
                RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(40, 40, 40))
                        .addGroup(RightLayout.createSequentialGroup()
                                .addContainerGap(180, Short.MAX_VALUE) // Adjust horizontal padding as needed
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoLabel)
                                .addContainerGap(180, Short.MAX_VALUE)) // Adjust horizontal padding as needed
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel6))
        );

        RightLayout.setVerticalGroup(
                RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(logoLabel))
                                .addGap(40, 40, 40) // Adjust vertical spacing between logo and other elements as needed
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(78, 78, 78))
        );
        jPanel1.add(Right);
        Right.setBounds(0, 0, 820, 600); // Updated size

        Left.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new Color(0, 102, 102));
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel2.setText("Username");

        jTextField1.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.setForeground(new Color(102, 102, 102));

        jPasswordField1.setFont(new Font(null, 0, 16));

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel3.setText("Password");

        // Initialize the JComboBox with roles
        String[] roles = {"Secretary", "Admin"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        roleComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // Set font
        //roleComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border
        roleComboBox.setBackground(Color.white);


        loginButton.setBackground(new Color(0, 102, 102));
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16)); // NOI18N
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setText("Login");

        GroupLayout LeftLayout = new GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
                LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(LeftLayout.createSequentialGroup()
                                                .addGap(138, 138, 138)
                                                .addComponent(jLabel1))
                                        .addGroup(LeftLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(roleComboBox, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(loginButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
                LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(roleComboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(181, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(820, 0, 500, 600); // Updated size

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

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
    }

    public String getUsername() {
        return jTextField1.getText();
    }

    public String getPassword() {
        return new String(jPasswordField1.getPassword());
    }

    public String getSelectedRole() {
        return (String) roleComboBox.getSelectedItem();
    }

    public void initLoginButtonActionListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
