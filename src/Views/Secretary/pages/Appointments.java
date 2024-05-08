package Views.Secretary.pages;

import Controllers.AppointmentController;
import Models.Appointment;
import Models.Patient;
import Views.Secretary.model.StatusType;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Appointments extends JPanel {
    private final Icon updateIcon = new ImageIcon(getClass().getResource("/assets/icons/edit.png"));
    private final Icon deleteIcon = new ImageIcon(getClass().getResource("/assets/icons/delete.png"));
    private final JButton addPatientButton = new JButton("Add New Appointment"); // New button for adding a new patient

    public Appointments() {
        initComponents();
        setupTable();
        populateTable();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panel = new JPanel();
        panelBorder1 = new Views.Secretary.swing.PanelBorder();
        jLabel1 = new JLabel();
        spTable = new JScrollPane();
        table = new Views.Secretary.swing.Table();

        setBackground(new Color(242, 242, 242));

        panel.setLayout(new GridLayout(1, 0, 10, 0));

        panelBorder1.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font("sansserif", 1, 18));
        jLabel1.setForeground(new Color(127, 127, 127));
        jLabel1.setText("List of Appointments");

        spTable.setBorder(null);

        GroupLayout panelBorder1Layout = new GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
                panelBorder1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(spTable))
                                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
                panelBorder1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spTable, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );

        // Add action listener to the Add Patient button
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle adding new patient action here
                System.out.println("Add New Appointment");
                // You can add your logic to open a new form or dialog for adding a new patient
            }
        });

        // Apply styling to the Add Patient button
        addPatientButton.setBackground(new Color(19, 164, 164)); // Set background color
        addPatientButton.setForeground(Color.WHITE); // Set text color
        addPatientButton.setFocusPainted(false); // Remove focus border
        addPatientButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // Set font and size
        addPatientButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set padding

        setLayout(new BorderLayout());
        add(addPatientButton, BorderLayout.NORTH); // Add the button to the top of the panel
        add(panel, BorderLayout.CENTER);
    }

    private void setupTable() {
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Doctor", "Patient", "Date", "Time", "Room", "Status", "Actions"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false,false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        // Set custom renderer for the actions column
        table.getColumnModel().getColumn(6).setCellRenderer(new ActionRenderer());
        spTable.setViewportView(table);
    }

    private void populateTable() {
        ArrayList<Appointment> appointments = AppointmentController.getAppointments();
        for(Appointment a : appointments) {
        table.addRow(new Object[]{a.getDoctor().getFirstName()+" "+a.getDoctor().getLastName(), a.getPatient().getFirstName()+" "+a.getPatient().getLastName(), a.getDate(), a.getTime(),a.getRoom(), a.getAppointmentStatus(),""});
        }
    }

    // ActionRenderer class for rendering update and delete icons in the Actions column
    class ActionRenderer extends DefaultTableCellRenderer {
        private final JButton updateButton = new JButton(updateIcon);
        private final JButton deleteButton = new JButton(deleteIcon);

        public ActionRenderer() {
            // Set preferred size for buttons
            updateButton.setPreferredSize(new Dimension(40, 40));
            deleteButton.setPreferredSize(new Dimension(40, 40));

            // Set background color for buttons
            updateButton.setBackground(Color.WHITE); // Set your desired background color
            deleteButton.setBackground(Color.WHITE); // Set your desired background color

            // Remove border around icons
            updateButton.setBorder(null);
            deleteButton.setBorder(null);

            // Set focusable property to false
            updateButton.setFocusable(false);
            deleteButton.setFocusable(false);

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            panel.setBackground(Color.WHITE); // Set your desired background color for the panel
            panel.add(updateButton);
            panel.add(deleteButton);

            // Disable buttons if no row is selected
            if (table.getSelectedRow() == -1) {
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
            } else {
                updateButton.setEnabled(true);
                deleteButton.setEnabled(true);
            }

            deleteButton.addActionListener(e -> {
                int confirmDialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the appointment?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmDialogResult == JOptionPane.YES_OPTION) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Patient patient = (Patient) table.getValueAt(selectedRow, 1);
                        System.out.println("Delete button clicked for appointment: " + patient);
                        // Call the deleteAppointment method from the controller, passing the appointment
                        // Example: AppointmentController.deleteAppointment(appointment);
                    } else {
                        System.out.println("No row selected for delete");
                    }
                }
            });

            updateButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    System.out.println("Update button clicked for appointment at row: " + selectedRow);
                } else {
                    System.out.println("No row selected for update");
                }
            });


            return panel;
        }
    }



    private JPanel panel;
    private Views.Secretary.swing.PanelBorder panelBorder1;
    private JLabel jLabel1;
    private JScrollPane spTable;
    private Views.Secretary.swing.Table table;
}
