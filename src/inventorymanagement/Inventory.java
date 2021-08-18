/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shuvo
 */
public class Inventory extends javax.swing.JFrame {
    
    
    Connection connection = null ;
    ResultSet resultSet = null ;
    PreparedStatement pst = null ;
    DefaultTableModel defaultTableModel = new DefaultTableModel();
   
        public static Connection connectDB()
    { 
      Connection connection =null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:F:\\Work\\Inventory Management System\\Inventory.sqlite");
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return  connection;
    }
    
            public void loadData()
    {
        connection = Inventory.connectDB();
        if(connection != null)
        {
            String sql = "select id , name , price , category from Database" ;
            try {
                pst = connection.prepareStatement(sql);
                resultSet = pst.executeQuery();
                Object[] columdata = new Object[4];
                while (resultSet.next()) {                    
                    columdata[0] = resultSet.getString("id");
                    columdata[1] = resultSet.getString("name");
                    columdata[2] = resultSet.getString("price");
                    columdata[3] = resultSet.getString("category");
                    
                    defaultTableModel.addRow(columdata);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
    }
    
    public Inventory() {
        initComponents();
        Object columns[] = { "ID" , "NAME" , "PRICE" , "CATEGORY" };
        defaultTableModel.setColumnIdentifiers(columns);
        table1.setModel(defaultTableModel);
        loadData();
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btninsert = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndlt = new javax.swing.JButton();
        btnclr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        idtxt = new javax.swing.JTextField();
        catcombo = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnview = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("X");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 70, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(650, 0, 70, 60);

        jButton1.setText("ID :");
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 130, 90, 30);

        jButton2.setText("Name :");
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 200, 90, 30);

        jButton3.setText("Price :");
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 270, 90, 30);

        jButton4.setText("Category :");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 340, 90, 30);

        btninsert.setText("Insert");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });
        getContentPane().add(btninsert);
        btninsert.setBounds(30, 450, 90, 30);

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate);
        btnupdate.setBounds(360, 450, 90, 30);

        btndlt.setText("Delete");
        btndlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndltActionPerformed(evt);
            }
        });
        getContentPane().add(btndlt);
        btndlt.setBounds(520, 450, 90, 30);

        btnclr.setText("Clear");
        btnclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclrActionPerformed(evt);
            }
        });
        getContentPane().add(btnclr);
        btnclr.setBounds(170, 450, 80, 30);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inventory Management");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 720, 60);
        getContentPane().add(nametxt);
        nametxt.setBounds(120, 200, 140, 30);
        getContentPane().add(pricetxt);
        pricetxt.setBounds(120, 270, 140, 30);

        idtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtxtActionPerformed(evt);
            }
        });
        getContentPane().add(idtxt);
        idtxt.setBounds(120, 130, 140, 30);

        catcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Processor", "Motherboard", "Ram", "Gpu", "Monitor", "Keyboard", "Mouse" }));
        catcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catcomboActionPerformed(evt);
            }
        });
        getContentPane().add(catcombo);
        catcombo.setBounds(120, 340, 140, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorymanagement/rsz_1inventory-management-online-database-750x410.jpg"))); // NOI18N
        jPanel1.add(jLabel3);

        jTabbedPane1.addTab("Welcome", jPanel1);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jTabbedPane2.addTab("Display", jScrollPane1);

        jTabbedPane1.addTab("Display", jTabbedPane2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(280, 100, 400, 340);

        btnview.setText("View");
        btnview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewActionPerformed(evt);
            }
        });
        getContentPane().add(btnview);
        btnview.setBounds(200, 100, 55, 23);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 70, 710, 430);

        setSize(new java.awt.Dimension(713, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed

          connection = Inventory.connectDB();
       if( connection != null)
    {
        
        try {
            String sql = "insert into Database(id , name , price , category ) values (  '"+idtxt.getText()+"' , '"+nametxt.getText()+"' , '"+pricetxt.getText()+"' , '"+catcombo.getSelectedItem().toString()+"' )";
            pst = connection.prepareStatement(sql); 
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Inserted");
            
            DefaultTableModel defaultTableModel = (DefaultTableModel)table1.getModel();
            defaultTableModel.setRowCount(0);
            loadData();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }


        // TODO add your handling code here:
    }//GEN-LAST:event_btninsertActionPerformed

    private void btnviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewActionPerformed
         
        connection= Inventory.connectDB();
        if(connection!=null)
        {
            try {
             String sql = "select * from Database where id='"+idtxt.getText()+"'";
                
             pst = connection.prepareStatement(sql);
             resultSet = pst.executeQuery();
                while (resultSet.next()) {                    
                 nametxt.setText(resultSet.getString("name"));
                 pricetxt.setText(resultSet.getString("price"));
                 catcombo.setSelectedItem(resultSet.getString("category"));
                    
                    
                }
             
             
                
            } catch (Exception e) {
            }
           
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnviewActionPerformed

    private void btnclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclrActionPerformed
                 idtxt.setText(null);
                 nametxt.setText(null);
                 pricetxt.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnclrActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
              connection = Inventory.connectDB();
       if( connection != null)
    {
        
        try {
            String sql = "update Database set name='"+nametxt.getText()+"' , price='"+pricetxt.getText()+"' ,category= '"+catcombo.getSelectedItem().toString()+"' where id='"+idtxt.getText()+"' " ;
            
            pst = connection.prepareStatement(sql); 
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Updated");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }   
    

        // TODO add your handling code here:
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndltActionPerformed
                connection = Inventory.connectDB();
       if( connection!= null)
    {
        
        String sql = "delete from Database where id='"+idtxt.getText()+"'";
        
        try {
            pst=connection.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
            DefaultTableModel defaultTableModel = (DefaultTableModel)table1.getModel();
            defaultTableModel.setRowCount(0);
            loadData();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_btndltActionPerformed

    private void catcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catcomboActionPerformed

    private void idtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtxtActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      this.dispose();    
      MainPanel mainPanel = new MainPanel();
      mainPanel.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclr;
    private javax.swing.JButton btndlt;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnview;
    private javax.swing.JComboBox<String> catcombo;
    private javax.swing.JTextField idtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
