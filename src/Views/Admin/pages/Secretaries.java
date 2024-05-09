package Views.Admin.pages;

import Controllers.SecretaryController;
import Models.Secretary;
import enums.ActionButtonType;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Secretaries extends JPanel {
    private final Icon updateIcon = new ImageIcon(getClass().getResource("/assets/icons/edit.png"));
    private final Icon deleteIcon = new ImageIcon(getClass().getResource("/assets/icons/delete.png"));
    private final JButton addSecretaryButton = new JButton("Add New Secretary"); // New button for adding a new secretary

    public Secretaries() {
        initComponents();
        setupTable();
        populateTable();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panel = new JPanel();
        panelBorder1 = new Views.Admin.swing.PanelBorder();
        jLabel1 = new JLabel();
        spTable = new JScrollPane();
        table = new Views.Admin.swing.Table();

        setBackground(new Color(242, 242, 242));

        panel.setLayout(new GridLayout(1, 0, 10, 0));

        panelBorder1.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font("sansserif", 1, 18));
        jLabel1.setForeground(new Color(127, 127, 127));
        jLabel1.setText("List of Secretaries");

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

        // Add action listener to the Add Secretary button
        addSecretaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle redirecting to the add secretary form
                showAddSecretaryForm();
            }
        });

        // Apply styling to the Add Secretary button
        addSecretaryButton.setBackground(new Color(19, 164, 164)); // Set background color
        addSecretaryButton.setForeground(Color.WHITE); // Set text color
        addSecretaryButton.setFocusPainted(false); // Remove focus border
        addSecretaryButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // Set font and size
        addSecretaryButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set padding

        setLayout(new BorderLayout());
        add(addSecretaryButton, BorderLayout.NORTH); // Add the button to the top of the panel
        add(panel, BorderLayout.CENTER);
    }

    private void showAddSecretaryForm() {
        // Create an instance of the AddSecretaryForm
        AddNewSecretary addSecretaryForm = new AddNewSecretary(this);

        // Create a JFrame to hold the form
        JFrame frame = new JFrame("Add New Secretary");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(addSecretaryForm);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
    
    private void setupTable() {
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "CIN", "First Name", "Last Name", "Email", "Telephone", "Update", "Delete"
                }
        ) {
            Class[] types = new Class [] {
                    String.class, String.class, String.class, String.class, String.class, String.class, Icon.class, Icon.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        // Set custom renderer for the actions column
        table.getColumnModel().getColumn(5).setCellRenderer(new ActionRenderer(updateIcon));
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), updateIcon, ActionButtonType.UPDATE, this));
        table.getColumnModel().getColumn(6).setCellRenderer(new ActionRenderer(deleteIcon));
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), deleteIcon, ActionButtonType.DELETE, this));
        spTable.setViewportView(table);
    }

    public void populateTable() {
        ArrayList<Secretary> secretaries = SecretaryController.getAllSecretaries();
        for(Secretary s : secretaries){
            table.addRow(new Object[]{s.getCIN(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getPhone(),""});
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
            // Set preferred size for buttons
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

        public ButtonEditor(JCheckBox checkBox, Icon icon, ActionButtonType actionButtonType, Secretaries s) {
            super(checkBox);
            actionBtn = new JButton(icon);
            actionBtn.addActionListener(e -> {
                // Handle update action here
                int selectedRow = table.getSelectedRow();
                if(selectedRow != -1){
                    String cin = table.getValueAt(selectedRow, 0).toString();
                    if(actionButtonType.equals(ActionButtonType.DELETE)){
                        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?", "Logout", JOptionPane.YES_NO_OPTION) == 0){
                            SecretaryController.deleteSecretary(cin);
                            refreshTable();
                        }
                    } else if(actionButtonType.equals(ActionButtonType.UPDATE)) {
                        new ModifySecretary(
                                s,
                                table.getValueAt(selectedRow, 0).toString(),
                                table.getValueAt(selectedRow, 1).toString(),
                                table.getValueAt(selectedRow, 2).toString(),
                                table.getValueAt(selectedRow, 3).toString(),
                                table.getValueAt(selectedRow, 4).toString()
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

    private JPanel panel;
    private Views.Admin.swing.PanelBorder panelBorder1;
    private JLabel jLabel1;
    private JScrollPane spTable;
    private Views.Admin.swing.Table table;
}
