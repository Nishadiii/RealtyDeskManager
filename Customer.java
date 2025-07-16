import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RSC extends javax.swing.JFrame {
    
    
    public RSC() {
        initComponents();
        Connect();
        loadCustomerNumber();
        Fetch();
        
    }
   Connection con;
   PreparedStatement pst;
   ResultSet rs;
   
   
   public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/realstatecompany","root","");
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }   
   }
    public void loadCustomerNumber(){
    
        try {
            pst =con.prepareStatement("SELECT Cus_ID FROM customer");
            rs = pst.executeQuery();
            txtItems.removeAllItems();
            while(rs.next()){
                
            txtItems.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM customer");
            rs =pst.executeQuery();
            ResultSetMetaData rss =rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df =(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1;a<=q;a++){
                     v2.add(rs.getString("Cus_ID"));
                     v2.add(rs.getString("CUS_Name"));
                     v2.add(rs.getString("Cus_Address"));
                     v2.add(rs.getString("Cus_Contact"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblCus_Name = new javax.swing.JLabel();
        lblCus_Address = new javax.swing.JLabel();
        lblCus_Contact = new javax.swing.JLabel();
        txtCus_Name = new javax.swing.JTextField();
        txtCus_Address = new javax.swing.JTextField();
        txtCus_Contact = new javax.swing.JTextField();
        btnAddNew = new javax.swing.JButton();
        btnUpdateDetails = new javax.swing.JButton();
        btnDeleteDetails = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblCus_Id = new javax.swing.JLabel();
        txtItems = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel1.setText("User Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Contact"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 410, 630, 180));

        lblCus_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCus_Name.setText("Customer Name ");
        jPanel1.add(lblCus_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        lblCus_Address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCus_Address.setText("Customer Address");
        jPanel1.add(lblCus_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        lblCus_Contact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCus_Contact.setText("Customer Contact Number");
        jPanel1.add(lblCus_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));
        jPanel1.add(txtCus_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 250, -1));

        txtCus_Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCus_AddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtCus_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 250, -1));

        txtCus_Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCus_ContactActionPerformed(evt);
            }
        });
        jPanel1.add(txtCus_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 250, -1));

        btnAddNew.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddNew.setText("Add New Customer");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 110, -1));

        btnUpdateDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateDetails.setText("Update Details");
        btnUpdateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdateDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 130, -1));

        btnDeleteDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteDetails.setText(" Delete Details");
        btnDeleteDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 130, -1));

        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 90, -1));

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 89, -1));

        lblCus_Id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCus_Id.setForeground(new java.awt.Color(255, 255, 255));
        lblCus_Id.setText("Customer ID ");
        jPanel1.add(lblCus_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 90, 30));

        txtItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemsActionPerformed(evt);
            }
        });
        jPanel1.add(txtItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 200, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive - Sri Lanka Institute of Information Technology\\Desktop\\ima.jpg")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1200, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentShown

    private void txtCus_ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCus_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCus_ContactActionPerformed

    private void txtCus_AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCus_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCus_AddressActionPerformed

    private void btnUpdateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDetailsActionPerformed

        try {
            String cusname = txtCus_Name.getText();
            String cusaddress = txtCus_Address.getText();
            String cuscontact = txtCus_Contact.getText();
            String cid = txtItems.getSelectedItem().toString();
            
            pst =con.prepareStatement("UPDATE customer SET Cus_Name=?,Cus_Address=?,Cus_Contact=? WHERE Cus_ID=?");
            
             pst.setString(1,cusname);
             pst.setString(2,cusaddress);
             pst.setString(3,cuscontact);
             pst.setString(4,cid);
             
             int k=pst.executeUpdate();
             if(k==1){
                  JOptionPane.showMessageDialog(this,"Recoard has been successfully updated !! "); 
                 txtCus_Name.setText("");
                 txtCus_Address.setText("");
                 txtCus_Contact.setText("");
                 txtCus_Name.requestFocus();
                 loadCustomerNumber();
                 
                 
             }
            
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateDetailsActionPerformed

    private void btnDeleteDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDetailsActionPerformed
    
        try {
            String cid = txtItems.getSelectedItem().toString();
            pst =con.prepareStatement("DELETE FROM customer WHERE Cus_ID =?");
            pst.setString(1,cid);
            
            int k = pst.executeUpdate();
            if(k==1){
                
                JOptionPane.showMessageDialog(this,"Recoard has been successfully deleted !! ");
                
                txtCus_Name.setText("");   
                txtCus_Address.setText("");
                txtCus_Contact.setText("");
                txtCus_Name.requestFocus();
                loadCustomerNumber();
            }
            
            else{
                JOptionPane.showMessageDialog(this,"Recoard failed to delete !! ");
            }
            
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteDetailsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        try {
            String cid = txtItems.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM customer WHERE Cus_ID=?");
            pst.setString(1, cid);
            rs = pst.executeQuery();
            
            if(rs.next()==true){
                txtCus_Name.setText(rs.getString(2));
                txtCus_Address.setText(rs.getString(3));
                txtCus_Contact.setText(rs.getString(4));
                
            }else{
                 JOptionPane.showMessageDialog(this,"No recoard found ! ");
            }
            
            // TODO add your handling code here:
        } 
            catch (SQLException ex) {
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        try {
            String cusname = txtCus_Name.getText();
            String cusaddress = txtCus_Address.getText();
            String cuscontact = txtCus_Contact.getText();
            
            pst = con.prepareStatement("INSERT INTO customer (Cus_Name,Cus_Address,Cus_Contact)VALUES(?,?,?)");
            pst.setString(1, cusname);
            pst.setString(2, cusaddress);
            pst.setString(3, cuscontact);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record Added!! successfully!");
                txtCus_Name.setText("");
                txtCus_Address.setText("");
                txtCus_Contact.setText("");
            }else{
                
                 JOptionPane.showMessageDialog(this,"Record failed to save!! ");
            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RSC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeleteDetails;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCus_Address;
    private javax.swing.JLabel lblCus_Contact;
    private javax.swing.JLabel lblCus_Id;
    private javax.swing.JLabel lblCus_Name;
    private javax.swing.JTextField txtCus_Address;
    private javax.swing.JTextField txtCus_Contact;
    private javax.swing.JTextField txtCus_Name;
    private javax.swing.JComboBox<String> txtItems;
    // End of variables declaration//GEN-END:variables
}
