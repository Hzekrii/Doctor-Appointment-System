package Views.Secretary.pages;

import Controllers.AppointmentController;
import Controllers.DoctorController;
import Controllers.PatientController;
import Models.Appointment;
import Models.Doctor;
import Models.Patient;

import enums.ActionButtonType;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Appointments extends JPanel {
    private final Icon updateIcon = new ImageIcon(getClass().getResource("/assets/icons/edit.png"));
    private final Icon deleteIcon = new ImageIcon(getClass().getResource("/assets/icons/delete.png"));
    private final JButton addAppointmentButton = new JButton("Add New Appointment"); // New button for adding a new patient
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;

    public Appointments() {
        doctors= DoctorController.getDoctors();
        patients= PatientController.getPatients();
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
        addAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle redirecting to the add patient form
                showAddAppointmentForm();}
        });

        // Apply styling to the Add Patient button
        addAppointmentButton.setBackground(new Color(19, 164, 164)); // Set background color
        addAppointmentButton.setForeground(Color.WHITE); // Set text color
        addAppointmentButton.setFocusPainted(false); // Remove focus border
        addAppointmentButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // Set font and size
        addAppointmentButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set padding

        setLayout(new BorderLayout());
        add(addAppointmentButton, BorderLayout.NORTH); // Add the button to the top of the panel
        add(panel, BorderLayout.CENTER);
    }

    private void showAddAppointmentForm() {
        // Create an instance of the AddAppointmentForm
        AddNewAppointment addAppointmentForm = new AddNewAppointment(this);

        // Create a JFrame to hold the form
        JFrame frame = new JFrame("Add New Appointment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(addAppointmentForm);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
    private void setupTable() {
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID","Doctor", "Patient", "Date", "Time", "Room", "Status", "Update","Delete"
                }
        ) {
            Class[] types = new Class [] {
                    Integer.class,String.class, String.class, String.class, String.class, String.class, String.class, Icon.class, Icon.class
            };
            boolean[] canEdit = new boolean [] {
                    false,false, false, false, false, false,false,true,true
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        // Set the width of the ID column to 0, so it's effectively hidden
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setWidth(0);
        // Set custom renderer for the actions column
        table.getColumnModel().getColumn(7).setCellRenderer(new Appointments.ActionRenderer(updateIcon));
        table.getColumnModel().getColumn(7).setCellEditor(new Appointments.ButtonEditor(new JCheckBox(), updateIcon, ActionButtonType.UPDATE, this));
        table.getColumnModel().getColumn(8).setCellRenderer(new Appointments.ActionRenderer(deleteIcon));
        table.getColumnModel().getColumn(8).setCellEditor(new Appointments.ButtonEditor(new JCheckBox(), deleteIcon, ActionButtonType.DELETE, this));
        spTable.setViewportView(table);
    }

    private void populateTable() {
        ArrayList<Appointment> appointments = AppointmentController.getAppointments();
        for(Appointment a : appointments) {
            table.addRow(new Object[]{a.getId(),a.getDoctor().getFirstName()+" "+a.getDoctor().getLastName(), a.getPatient().getFirstName()+" "+a.getPatient().getLastName(), a.getDate(), a.getTime(),a.getRoom(), a.getAppointmentStatus(),""});
        }
    }
    public void refreshTable() {
        ((DefaultTableModel)(table.getModel())).setRowCount(0);
        populateTable();
    }

    // ActionRenderer class for rendering update and delete icons in the Actions column
    class ActionRenderer extends DefaultTableCellRenderer {
        private final JButton actionBtn;

        public ActionRenderer(Icon icon) {
            actionBtn = new JButton(icon);
            actionBtn.setPreferredSize(new Dimension(40, 40));

            // Set background color for buttons
            actionBtn.setBackground(Color.WHITE); // Set your desired background color

            // Remove border around icons
            actionBtn.setBorder(null);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            panel.setBackground(Color.WHITE); // Set your desired background color for the panel
            panel.add(actionBtn);
            return panel;
        }
    }
    class ButtonEditor extends DefaultCellEditor {
        private JButton actionBtn;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox, Icon icon, ActionButtonType actionButtonType, Appointments a) {
            super(checkBox);
            actionBtn = new JButton(icon);
            actionBtn.addActionListener(e -> {
                // Handle update action here
                int selectedRow = table.getSelectedRow();
                if(selectedRow != -1){
                    String cin = table.getValueAt(selectedRow, 0).toString();
                    if(actionButtonType.equals(ActionButtonType.DELETE)){
                        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Appointment ?", "Delete", JOptionPane.YES_NO_OPTION) == 0){
                            AppointmentController.deleteAppointment(getId(table.getValueAt(selectedRow,0)));
                            refreshTable();
                        }
                    } else if(actionButtonType.equals(ActionButtonType.UPDATE)) {
                        new ModifyAppointment(
                                a,
                                getId(table.getValueAt(selectedRow,0)),
                                getDoctor(table.getValueAt(selectedRow, 1)),
                                getPatient(table.getValueAt(selectedRow, 2)),
                                getDate(table.getValueAt(selectedRow, 3)),
                                getTime(table.getValueAt(selectedRow, 4)),
                                getRoom(table.getValueAt(selectedRow, 5)),
                                getStatus(table.getValueAt(selectedRow, 6))
                        );
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                actionBtn.setBackground(table.getSelectionBackground());
            } else {
                actionBtn.setBackground(Color.white);
            }
            isPushed = true;
            return actionBtn;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    private Doctor getDoctor(Object selectedItem) {
        String doctor= (String) selectedItem;
        for (Doctor d : doctors) {
            String fullName = d.getFirstName() + " " + d.getLastName();
            if (fullName.equals(doctor)) {
                return d;
            }
        }
        return null;
    }

    private Patient getPatient(Object selectedItem) {
        String patient= (String) selectedItem;
        for(Patient p: patients){
            String fullName=p.getFirstName()+" "+p.getLastName();
            if(fullName.equals(patient)){
                return p;
            }
        }
        return null;
    }

    private Date getDate(Object selectedDate) {
        if (selectedDate instanceof java.sql.Date) {
            return (java.sql.Date) selectedDate;
        } else {
            try {
                String dateString = (String) selectedDate;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    private Time getTime(Object selectedTime) {
        if (selectedTime instanceof java.sql.Time) {
            return (java.sql.Time) selectedTime;
        } else {
            try {
                String timeString = (String) selectedTime;
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                return new Time(formatter.parse(timeString).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private Appointment.Room getRoom(Object selectedItem) {
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
    private Appointment.AppointmentStatus getStatus(Object selectedItem) {
        if (selectedItem != null) {
            String selectedStatus = selectedItem.toString();
            for (Appointment.AppointmentStatus s : Appointment.AppointmentStatus.values()) {
                if (s.name().equalsIgnoreCase(selectedStatus)) {
                    return s;
                }
            }
        }
        return null;
    }
    private int getId(Object selectedItem) {
       return (int) selectedItem;
    }

    private JPanel panel;
    private Views.Secretary.swing.PanelBorder panelBorder1;
    private JLabel jLabel1;
    private JScrollPane spTable;
    private Views.Secretary.swing.Table table;
}
