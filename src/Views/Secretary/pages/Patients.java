package Views.Secretary.pages;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Patients extends JPanel {
    private final Icon updateIcon = new ImageIcon(getClass().getResource("/assets/icons/edit.png"));
    private final Icon deleteIcon = new ImageIcon(getClass().getResource("/assets/icons/delete.png"));
    private final JButton addPatientButton = new JButton("Add New Patient"); // New button for adding a new patient

    public Patients() {
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
        jLabel1.setText("List of Patients");

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
                System.out.println("Add New Patient");
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
                        "CIN", "First Name", "Last Name", "Email", "Telephone", "Actions"
                }
        ) {
            Class[] types = new Class [] {
                    String.class, String.class, String.class, String.class, String.class, String.class, Icon.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        // Set custom renderer for the actions column
        table.getColumnModel().getColumn(5).setCellRenderer(new ActionRenderer());
        spTable.setViewportView(table);
    }

    private void populateTable() {
        table.addRow(new Object[]{"123456", "Mike", "Bhand", "mikebhand@gmail.com", "+1234567890",""});
        table.addRow(new Object[]{"789012", "Andrew", "Strauss", "andrewstrauss@gmail.com", "+0987654321",""});
        // Add more rows as needed
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

            updateButton.addActionListener(e -> {
                // Handle update action here
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    System.out.println("Update button clicked at row: " + selectedRow);
                } else {
                    System.out.println("No row selected for update");
                }
            });

            deleteButton.addActionListener(e -> {
                // Handle delete action here
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    System.out.println("Delete button clicked at row: " + selectedRow);
                } else {
                    System.out.println("No row selected for delete");
                }
            });
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            panel.setBackground(Color.WHITE); // Set your desired background color for the panel
            panel.add(updateButton);
            panel.add(deleteButton);
            return panel;
        }
    }



    private JPanel panel;
    private Views.Secretary.swing.PanelBorder panelBorder1;
    private JLabel jLabel1;
    private JScrollPane spTable;
    private Views.Secretary.swing.Table table;
}
