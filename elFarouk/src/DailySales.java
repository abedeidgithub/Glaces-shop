
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamal Rashad
 */
public class DailySales extends javax.swing.JFrame {
Connection con = null;    
     PreparedStatement pst = null;
     ResultSet rs = null;
     int a,b,mab;
     int d,e,f,g,mas;
      ResultSetMetaData rsmeta;
    /**
     * Creates new form DailySales
     */
    public DailySales() {
        initComponents();
        Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//           Toolkit tool = Toolkit.getDefaultToolkit();
//        Dimension d = tool.getScreenSize();
//        int w = d.width;
//        int h = d.height;
//        this.setSize(w, h);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtTotal1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtName1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("جرد يومي");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(237, 234, 234));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(105, 105, 105));
        jLabel8.setText("إجمالى المبيعات");

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(105, 105, 105));
        jLabel22.setText("إجمالى المصروفات");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalKeyTyped(evt);
            }
        });

        txtTotal1.setEditable(false);
        txtTotal1.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotal1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotal1KeyTyped(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(105, 105, 105));
        jLabel23.setText("صافي الربح ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(79, 79, 79))
        );

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        txtName1.setEditable(false);
        txtName1.setBackground(new java.awt.Color(204, 204, 255));
        txtName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtName1KeyReleased(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 105, 105));
        jLabel9.setText("تاريخ اليوم");

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Apps-accessories-calculator-icon.png"))); // NOI18N
        jButton1.setText("عرض");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(61, 61, 61)
                .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        //        search();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyTyped

    private void txtTotal1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1KeyTyped

    private void txtName1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtName1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         
       
             DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
Calendar cal = Calendar.getInstance();
txtName1.setText(dateFormat.format(cal.getTime()));
        double maksab=0;
        
        try{ 
            con=Connect.connect();
   String sql ="Select SUM(total) FROM sales  where date ='"+txtName1.getText()+"'";
    pst = con.prepareStatement(sql);
    rs = pst.executeQuery();
    rs.next();
  a=( rs.getInt(1));

   }
   catch(Exception e){
   
    JOptionPane.showMessageDialog(null, e.getMessage());
   }
        
          try{     
   String sql ="Select SUM(payed) FROM warsha  where date ='"+txtName1.getText()+"'";
    pst = con.prepareStatement(sql);
    rs = pst.executeQuery();
    rs.next();
   g=( rs.getInt(1));
  
   }
   catch(Exception e){
   
    JOptionPane.showMessageDialog(null, e.getMessage());
   }
  
maksab=a+g;
   txtName.setText(maksab+"");
        
        
   
   
   //اجمالي المصروفات
   
    try{ 
            con=Connect.connect();
   String sql ="Select SUM(total) FROM glass_office  where date ='"+txtName1.getText()+"'";
    pst = con.prepareStatement(sql);
    rs = pst.executeQuery();
    rs.next();
 d=( rs.getInt(1));

   }
   catch(Exception e){
   
    JOptionPane.showMessageDialog(null, e.getMessage());
   }
   try{     
   String sql ="Select SUM(total) FROM traders_1  where date ='"+txtName1.getText()+"'";
    pst = con.prepareStatement(sql);
    rs = pst.executeQuery();
    rs.next();
  e=( rs.getInt(1));
 
   }
   catch(Exception e){
   
    JOptionPane.showMessageDialog(null, e.getMessage());
   }
   
    try{ 
            con=Connect.connect();
   String sql ="Select SUM(value) FROM masrofat  where date ='"+txtName1.getText()+"'";
    pst = con.prepareStatement(sql);
    rs = pst.executeQuery();
    rs.next();
  f=( rs.getInt(1));
  
   }
   catch(Exception e){
   
    JOptionPane.showMessageDialog(null, e.getMessage());
   }
 
   mas=d+e+f;
   txtTotal.setText(mas+"");
   
  int t=a-mas;
   txtTotal1.setText(t+"");
   
   
   
   //عرض
   
   
   try{     
   String sql ="Select  name ,num_shamp,total FROM sales  where date ='"+txtName1.getText()+"'";
    pst = con.prepareStatement(sql);
    rs = pst.executeQuery();
     Vector<String> colName = new Vector<String>();
           
            colName.add("الاسم");
           
            colName.add("رقم الشمبر");
           
            colName.add("الاجمالي");
            
            Vector<Vector> rows = new Vector<Vector>();

            rsmeta = rs.getMetaData();
            for (int i = 1; i <= rsmeta.getColumnCount(); i++) {
                // colName.add(rsmeta.getColumnName(i));

            }
            while (rs.next()) {
                Vector<String> oneRow = new Vector<String>();
                for (int i = 1; i <= rsmeta.getColumnCount(); i++) {
                    oneRow.add(rs.getString(i));

                }
                rows.add(oneRow);
            }

            DefaultTableModel tableModel = new DefaultTableModel(rows, colName);
            jTable1.setModel(tableModel);

            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
               jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(213);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(216);
           
          
            jTable1.setShowHorizontalLines(true);
            jTable1.setShowVerticalLines(true);
    
  
   }
   catch(Exception e){
   
    JOptionPane.showMessageDialog(null, e.getMessage());
   }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

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
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailySales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable jTable1;
    protected javax.swing.JTextField txtName;
    protected javax.swing.JTextField txtName1;
    protected javax.swing.JTextField txtTotal;
    protected javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
}
