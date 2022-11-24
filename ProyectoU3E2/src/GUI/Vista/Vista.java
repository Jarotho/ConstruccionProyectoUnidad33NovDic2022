package GUI.Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vista extends javax.swing.JFrame {

    private DefaultTableModel tablaModelo1;
    private JScrollPane panelPrincipal;
    private JTable jTable1;
    private JLabel jLabel1;

    public Vista() {
        initComponents();
        jTable1.setDefaultRenderer(Object.class,new imgTable());
        jTable1.setRowHeight(50);
        tablaModelo1 = (DefaultTableModel) this.jTable1.getModel();
       
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        panelPrincipal = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Empleados");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "firstName", "lastName", "photo"
            }
        ));
        panelPrincipal.setViewportView(jTable1);

      
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1))
            )));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                
        );

        pack();
    }

    public DefaultTableModel Table(){
        return tablaModelo1;
    }

}


