package Views.Admin.pages;

import Controllers.AppointmentController;
import Controllers.DoctorController;
import Controllers.PatientController;
import Controllers.SecretaryController;
import Views.Admin.model.Model_Card;

import javax.swing.ImageIcon;

public class Dashboard_Page extends javax.swing.JPanel {

    public Dashboard_Page() {
        initComponents();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/assets/icons/2_admin.png")), "Total Secretaries", String.valueOf(SecretaryController.getAllSecretaries().size()), ""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/assets/icons/3_admin.png")), "Total Doctors", String.valueOf(DoctorController.getDoctors().size()), ""));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/assets/icons/2_secretary.png")), "Total Patients", String.valueOf(PatientController.getPatients().size()), ""));
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/assets/icons/3_secretary.png")), "Total Appointmnets", String.valueOf(AppointmentController.getAppointments().size()), ""));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new Views.Admin.components.Card();
        card2 = new Views.Admin.components.Card();
        card3 = new Views.Admin.components.Card();
        card4 = new Views.Admin.components.Card();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(122, 214, 109));
        card1.setColor2(new java.awt.Color(95, 205, 96));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(209, 200, 97));
        card2.setColor2(new java.awt.Color(197, 188, 87));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(142, 142, 250));
        card3.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card3);

        card4.setColor1(new java.awt.Color(186, 123, 247));
        card4.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Admin.components.Card card1;
    private Views.Admin.components.Card card2;
    private Views.Admin.components.Card card3;
    private Views.Admin.components.Card card4;
    private javax.swing.JLayeredPane panel;
    // End of variables declaration//GEN-END:variables
}
