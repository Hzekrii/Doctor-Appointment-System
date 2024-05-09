package Views;

import Controllers.LoginController;
import Views.Admin.event.EventMenuSelected;
import Views.Admin.pages.Doctors;
import Views.Admin.pages.Dashboard_Page;
import Views.Admin.pages.Secretaries;
import Views.Secretary.pages.Appointments;
import Views.Secretary.pages.Patients;

import java.awt.Color;
import javax.swing.*;

public class AdminDashboard extends JFrame {

    private Dashboard_Page home;
    private Secretaries secretariesPage;
    private Doctors doctorsPage;
    private Patients patientsPage;
    private Appointments appointmentsPage;

    public AdminDashboard() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        home = new Dashboard_Page();
        secretariesPage = new Secretaries();
        doctorsPage = new Doctors();
        patientsPage = new Patients();
        appointmentsPage = new Appointments();
        menu.initMoving(AdminDashboard.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 1) {
                    setForm(secretariesPage);
                } else if (index == 2) {
                    setForm(doctorsPage);
                } else if (index == 3) {
                    setForm(patientsPage);
                }else if (index == 4) {
                    setForm(appointmentsPage);
                } else if (index == 5) {
                    handleLogout();
                }
            }
        });
        //  set when system open start with home form
        setForm(new Dashboard_Page());
    }
    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Views.Admin.swing.PanelBorder();
        menu = new Views.Admin.components.Menu();
        header2 = new Views.Admin.components.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void handleLogout() {
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?", "Logout", JOptionPane.YES_NO_OPTION) == 0){
            new LoginController(new Login());
            dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Admin.components.Header header2;
    private javax.swing.JPanel mainPanel;
    private Views.Admin.components.Menu menu;
    private Views.Admin.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
