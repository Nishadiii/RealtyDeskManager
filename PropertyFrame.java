import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PropertyFrame extends javax.swing.JFrame {

    
    public PropertyFrame() {
        initComponents();   //initialize components first
        Connect();
        LoadPropertyID ();   // load sdata after initialization
        Fetch();
        
    }


    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private void Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_management_system","root","");
        }
        
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PropertyFrame.class.getName()).log(Level.SEVERE, null,ex);
            
        }
        
    }
        
    
    
    public void LoadPropertyID(){
        
        try {
            pst = con.prepareStatement("SELECT pID FROM property_management");
            rs = pst.executeQuery();
            txtPID.removeAllItems();
            
            while(rs.next()){
                txtPID.addItem(rs.getString(1));
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(PropertyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM property_management");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                
                Vector v2 = new Vector();
                
                for( int a = 1 ; a <= q ; a++ ){
                    v2.add(rs.getString("pID"));
                    v2.add(rs.getString("pName"));
                    v2.add(rs.getString("location"));
                    v2.add(rs.getString("area"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("description"));
                    
                    df.addRow(v2);
                    
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblProjectName = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtProjectName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblPropertyID = new javax.swing.JLabel();
        txtPID = new javax.swing.JComboBox<>();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagess/R (2).jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 600));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setText("PROPERTY MANAGEMENT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, 66));

        lblProjectName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProjectName.setText("Project Name");
        jPanel1.add(lblProjectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, -1, 20));

        lblLocation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLocation.setText("Location");
        jPanel1.add(lblLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 71, -1));

        lblArea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblArea.setText("Area in perches");
        jPanel1.add(lblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 120, 24));

        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrice.setText("Price per perch");
        jPanel1.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, 22));

        txtLocation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationActionPerformed(evt);
            }
        });
        jPanel1.add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 300, -1));

        txtArea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });
        jPanel1.add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 300, -1));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, 300, -1));

        txtDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 300, 20));

        lblDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescription.setText("Description");
        jPanel1.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, -1, -1));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, -1, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 490, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 490, -1, -1));

        txtProjectName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtProjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtProjectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 300, -1));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 70, 80, -1));

        jTable1.setBackground(new java.awt.Color(0, 153, 0));
        jTable1.setForeground(new java.awt.Color(242, 242, 242));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Property ID", "Project Name", "Location", "Area in perches", "Price per perch", "Description"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(242, 242, 242));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 590, 270));

        lblPropertyID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPropertyID.setText("Property ID");
        jPanel1.add(lblPropertyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 110, 30));

        txtPID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtPID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentShown

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // TODO add your handling code here:
            String pName = txtProjectName.getText();
            String location = txtLocation.getText();
            String area = txtArea.getText();
            String price = txtPrice.getText();
            String description = txtDescription.getText();
            
            pst = con.prepareStatement("INSERT INTO property_management (pName, location, area, price, description) VALUES (?,?,?,?,?)");
            pst.setString(1,pName);
            pst.setString(2, location);
            pst.setString(3,area );
            pst.setString(4, price);
            pst.setString(5, description);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record Added!! Successfully!");
                txtProjectName.setText("");
                txtLocation.setText("");
                txtArea.setText("");
                txtPrice.setText("");
                txtDescription.setText("");
                Fetch();
                LoadPropertyID();
                
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to saved!!");

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            
            String pid = txtPID.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM property_management WHERE pID=?");
            pst.setString(1,pid);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record has been successfully Deleted!!");
                txtProjectName.setText("");
                txtLocation.setText("");
                txtArea.setText("");
                txtPrice.setText("");
                txtDescription.setText("");
                Fetch();
                LoadPropertyID();
                
                
                
            }
            else{
                 JOptionPane.showMessageDialog(this,"Record failed to Delete!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void txtProjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProjectNameActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            // TODO add your handling code here:
            
            String pID = txtPID.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM property_management WHERE pID = ?");
            pst.setString(1,pID);
            rs= pst.executeQuery();
            
            if(rs.next()==true){
                txtProjectName.setText(rs.getString(2));
                txtLocation.setText(rs.getString(3));
                txtArea.setText(rs.getString(4));
                txtPrice.setText(rs.getString(5));
                txtDescription.setText(rs.getString(6));
            }
            
            else{
                JOptionPane.showMessageDialog(this,"No Record Found");

            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            
            String pname = txtProjectName.getText();
            String location = txtLocation.getText();
            String area = txtArea.getText();
            String price = txtPrice.getText();
            String description = txtDescription.getText();
            String pid = txtPID.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE property_management SET pName=?, location=?, area=?,price=?, description=? WHERE pID=?");
            
            pst.setString(1,pname);
            pst.setString(2,location);
            pst.setString(3,area);
            pst.setString(4,price);
            pst.setString(5,description);
            pst.setString(6,pid);

            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record has been successfully updated!!");
                txtProjectName.setText("");
                txtLocation.setText("");
                txtArea.setText("");
                txtPrice.setText("");
                txtDescription.setText("");
                txtProjectName.requestFocus();
                Fetch();
                LoadPropertyID();
                
                
            
            }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtPIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPIDActionPerformed

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
            java.util.logging.Logger.getLogger(PropertyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PropertyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PropertyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PropertyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
        new PropertyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JLabel lblPropertyID;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JComboBox<String> txtPID;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProjectName;
    // End of variables declaration//GEN-END:variables
}
