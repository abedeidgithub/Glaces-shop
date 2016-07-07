
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamal Rashad
 */
public class Traders1 extends javax.swing.JFrame {
Connection con = null;    
     PreparedStatement pst = null;
     ResultSet rs = null;
      ResultSetMetaData rsmeta;
      int id;
    /**
     * Creates new form Traders1
     */
    public Traders1() {
        initComponents();
                this.setSize(1000, 700);
                conn=Connect.connect();
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

reset();
    }
    
    
    public  void reset() {
        jTextField1.setText("");
        txtColor.setText("");
        txtName1.setText("");
        txtTotal1.setText("");
        txtTotal2.setText("");
        txtMarka.setText("");
        txtphoneNum.setText("");
        txtSanf.setText("");
        txtShumberNum.setText("");
        txtName.setText("");
        txtType.setText("");
     txtPaid.setText("0");
    txtReminder.setText("0");
    txtTotal.setText("0");
    txtKemmya.setText("0");
    txtSalePrice.setText("0");
    txtShumberPrice.setText("0");
        jDateChooser.setDate(null);
        Default();
        txtShumberNum.setText("0");
//        upDateBtn.setEnabled(false);
        
    }
    
       void Default() {

        try {
                            conn=Connect.connect();

//txtShumberNum.setText("0");


            String sql = "SELECT * FROM `traders_1` ";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            String sql1 = " SELECT  t_ID as `ID` ,t_name as`إسم التاجر` , `date` as `التاريخ `,`num_shamp` as `رقم الشمبر`, `class` as `الصنف`, `color` as `اللون`, `type` as `النوع`, `mark` as `الماركة`,`total` as `الإجمالي`, `payed` as `المدفوع`, `reset` as `الباقي`  FROM `traders_1` ";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            ResultSet rs = preparedStatement1.executeQuery();
            if (resultSet.next()) {
                Vector<String> colName = new Vector<String>();
            colName.add("كود ");
            colName.add("اسم التاجر");
            colName.add("التاريخ");
            colName.add("رقم الشمبر");
            colName.add("الصنف ");
            colName.add("اللون ");
            colName.add("النوع ");
            colName.add("الماركة ");

            colName.add("الاجمالي");
            colName.add("المدفوع ");
            colName.add("الباقي");
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(151);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(151);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
//            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);

            jTable1.setShowHorizontalLines(true);
            jTable1.setShowVerticalLines(true);
            //jTable1e.scrollRectToVisible(jTable1e.getCellRect(jTable1e.getRowCount()-1, 0, true));

        
        

           
        }

        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        for (int x = 0; x < jTable1.getColumnCount(); x++) {
            jTable1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
            } 
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Here : " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
        public void fillTxt(){

try{
            int r = jTable1.getSelectedRow();
            
            
            String data = jTable1.getModel().getValueAt(r,0).toString();
            String sql = " select * from traders_1 where  t_ID='" + (data) + "'";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
 int shumbNum = resultSet.getInt("num_shamp");
               txtShumberNum.setText(Integer.toString(shumbNum));
                String t_name = resultSet.getString("t_name");
                txtName.setText(t_name);
//                JOptionPane.showMessageDialog(null, "Errrrrrrrrrrrr");
                // 2-
                Date date1 = resultSet.getDate("date");
                jDateChooser.setDate(date1);
                
                id=resultSet.getInt("t_id");
                
                String phone = resultSet.getString("phone");
                txtphoneNum.setText(phone);
                
                  
                
               String sanf = resultSet.getString("class");
                txtSanf.setText(sanf);
                
                String color = resultSet.getString("color");
                txtColor.setText(color);
                
                String type = resultSet.getString("type");
                txtType.setText(type);
                 // 4 -
                String marka = resultSet.getString("mark");
                txtMarka.setText(marka);
                
               // int kemmya=resultSet.getInt("number");
               // txtKemmya.setText(Integer.toString(kemmya));
               
                int shumbPrice=resultSet.getInt("price_shamp");
                txtShumberPrice.setText(Integer.toString(shumbPrice));
                
                int price=resultSet.getInt("price");
                txtSalePrice.setText(Integer.toString(price));
                
                
                  int total = resultSet.getInt("total");
               txtTotal.setText(Integer.toString(total));
               
                  int paid = resultSet.getInt("payed");
               txtPaid.setText(Integer.toString(paid));
               
                int reminder  = resultSet.getInt("reset");
               txtReminder.setText(Integer.toString(reminder));
           
                String sql5 = "Select amount from makhazen where num='"+shumbNum+"' ";
       pst = con.prepareStatement(sql5);
       rs = pst.executeQuery();
       if (rs.next()){
           int amount1=rs.getInt(1);
        txtKemmya.setText(amount1+"");
       }
               
               
             upDateBtn.setEnabled(true);
            }

        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//            JOptionPane.showMessageDialog(this, " خطأ فى أسترجاع البيانات" + ex.getMessage());
            ex.printStackTrace();
        } 


              int total , payed,ba2y;

// إجمالي الحساب للتاجر
try{
    String sql1="Select SUM(total) FROM traders_1  where t_name ='"+txtName.getText()+"'";

       pst = con.prepareStatement(sql1);
    rs = pst.executeQuery();
    rs.next();
  total=( rs.getInt(1));
      txtName1.setText(Integer.toString(total));

}catch(Exception e)
{
    return;
}

   
//إجمالي المدفوع
try{
    String sql2="Select SUM(payed) FROM traders_1  where t_name ='"+txtName.getText()+"'";

       pst = con.prepareStatement(sql2);
    rs = pst.executeQuery();
    rs.next();
  payed=( rs.getInt(1));
      txtTotal1.setText(Integer.toString(payed));

}catch(Exception e)
{
    return;
}



//إجمالي الباقي
try{
    String sql3="Select SUM(reset) FROM traders_1  where t_name ='"+txtName.getText()+"'";

       pst = con.prepareStatement(sql3);
    rs = pst.executeQuery();
    if(rs.next()){
  ba2y=( rs.getInt(1));
      txtTotal2.setText(ba2y+"");
    }
}catch(Exception e)
{
    return;
}


}

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    SimpleDateFormat format1 = new SimpleDateFormat("MMM-dd-yyyy");
    java.sql.Date date;
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
        txtphoneNum = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtShumberNum = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtMarka = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtSanf = new javax.swing.JTextField();
        txtKemmya = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtShumberPrice = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtSalePrice = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtReminder = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        upDateBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        txtTotal2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("التجار");
        setBackground(new java.awt.Color(204, 204, 255));
        setFont(new java.awt.Font("078MKSDMediumCondensed", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(51, 51, 255));

        jPanel2.setBackground(new java.awt.Color(237, 234, 234));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(105, 105, 105));
        jLabel8.setText("إسم التاجر");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        txtphoneNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtphoneNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtphoneNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphoneNumKeyTyped(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(105, 105, 93));
        jLabel13.setText("تليفون التاجر");

        jDateChooser.setBackground(new java.awt.Color(255, 255, 204));
        jDateChooser.setDateFormatString("yyyy-MM-dd");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(105, 105, 105));
        jLabel14.setText("تاريخ اليوم");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtphoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel14)))))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtphoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(237, 234, 234));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        txtShumberNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtShumberNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtShumberNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtShumberNumKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtShumberNumKeyTyped(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(105, 105, 93));
        jLabel24.setText("رقم الشمبر");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(105, 105, 93));
        jLabel26.setText("اللون");

        txtColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtColor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(105, 105, 93));
        jLabel27.setText("الماركة");

        txtMarka.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMarka.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtType.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(105, 105, 93));
        jLabel21.setText("النوع");

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(105, 105, 93));
        jLabel25.setText("الصنف");

        txtSanf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSanf.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtKemmya.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKemmya.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(105, 105, 93));
        jLabel28.setText("الكميه");

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(105, 105, 93));
        jLabel29.setText("سعر الشمبر");

        txtShumberPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtShumberPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtShumberPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtShumberPriceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtShumberPriceKeyTyped(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(105, 105, 93));
        jLabel30.setText("سعر البيع ");

        txtSalePrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSalePrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMarka, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtShumberNum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtKemmya, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtShumberPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jLabel29))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSanf)
                            .addComponent(txtColor)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addComponent(jLabel21))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(txtMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(txtShumberNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtKemmya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(txtSanf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txtShumberPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30)
                        .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(237, 234, 234));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(105, 105, 105));
        jLabel22.setText("الإجمالى");

        txtTotal.setEditable(false);
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

        txtReminder.setEditable(false);
        txtReminder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtReminder.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtReminder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReminderKeyTyped(evt);
            }
        });

        txtPaid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPaid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaidKeyTyped(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(105, 105, 93));
        jLabel31.setText("مدفوع");

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(105, 105, 93));
        jLabel32.setText("الباقي");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReminder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Floppy-Small-icon.png"))); // NOI18N
        jButton1.setText("حفظ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        upDateBtn.setBackground(new java.awt.Color(153, 153, 153));
        upDateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        upDateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Actions-edit-redo-icon.png"))); // NOI18N
        upDateBtn.setText("تعديل");
        upDateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upDateBtnActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/document-add-icon.png"))); // NOI18N
        jButton4.setText("تحديث البرنامج");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Close-2-icon.png"))); // NOI18N
        jButton6.setText("حذف");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Actions-window-close-icon.png"))); // NOI18N
        jButton5.setText("رجوع");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel5.setBackground(new java.awt.Color(237, 234, 234));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 105, 105));
        jLabel9.setText("إجمالي الحساب");

        txtName1.setEditable(false);
        txtName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtName1KeyReleased(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(105, 105, 105));
        jLabel23.setText("المدفوع");

        txtTotal1.setEditable(false);
        txtTotal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotal1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotal1KeyTyped(evt);
            }
        });

        txtTotal2.setEditable(false);
        txtTotal2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotal2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotal2KeyTyped(evt);
            }
        });

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(105, 105, 105));
        jLabel33.setText("الباقي");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Zoom-icon - Copy.png"))); // NOI18N
        jLabel1.setText("بحث");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(txtTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33)
                .addGap(66, 66, 66)
                .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(59, 59, 59)
                .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(txtTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33)))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(19, 19, 19)
                        .addComponent(upDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(upDateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
//        search();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtphoneNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneNumKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneNumKeyTyped

    private void txtShumberNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtShumberNumKeyReleased

//        Thread clock;
//        clock = new Thread() {
//            @Override
//            public void run() {
//
//                while (true) {
//
//                    if (!(txtShumberNum.getText().isEmpty())) {
//                        //                        tablePatient.setVisible(true);
//                        //            String report="J:\\All Project\\report\\pharmcy_login_report.jrxml";
//                        // String sql = "select * from login  ";
//                        String sql2 = " select shumberNum as `رقم الشمبر` , sanf as `الصنف ` , color as `اللون` , "
//                        + " marka as `الماركة` , traderName as `إسم التاجر ` ,date as `التاريخ` , "
//                        + "id from trader where shumberNum like '" + txtShumberNum.getText() + "%'";
//                        //                        String sql = "select * from patient where name like '" + txtname.getText() + "%'";
//                        try {
//
//                            preparedStatement = conn.prepareStatement(sql2);
//                            resultSet = preparedStatement.executeQuery();
//
//                            if (resultSet.next()) {
//                                conn.prepareStatement(sql2);
//                                preparedStatement = conn.prepareStatement(sql2);
//                                resultSet = preparedStatement.executeQuery();
//                                jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
//
//                            } else {
//                                String sql1 = "select * from trader where shumberNum is null";
//
//                                preparedStatement = conn.prepareStatement(sql1);
//                                resultSet = preparedStatement.executeQuery();
//                                if (!resultSet.next()) {
//                                    conn.prepareStatement(sql1);
//                                    preparedStatement = conn.prepareStatement(sql1);
//                                    resultSet = preparedStatement.executeQuery();
//                                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
//
//                                }
//                            }
//                        } catch (SQLException e) {
//                            JOptionPane.showMessageDialog(null, e.getMessage());
//                        }
//
//                        try {
//                            wait();
//
//                        } catch (InterruptedException ex) {
//                            // Logger.getLogger(sea.class.getName()).log(Level.SEVERE, null, ex);
//                            JOptionPane.showMessageDialog(null, ex.getMessage());
//                        }
//                    } else {
//                        String sql1 = "select * from trader where shumberNum is null";
//
//                        try {
//                            preparedStatement = conn.prepareStatement(sql1);
//                            resultSet = preparedStatement.executeQuery();
//                            if (!resultSet.next()) {
//                                conn.prepareStatement(sql1);
//                                preparedStatement = conn.prepareStatement(sql1);
//                                resultSet = preparedStatement.executeQuery();
//                                jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
//                            }
//
//                        } catch (SQLException ex) {
//                            JOptionPane.showMessageDialog(null, ex.getMessage());
//                        }
//                        try {
//                            wait();
//
//                        } catch (InterruptedException ex) {
//                            // Logger.getLogger(sea.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//
//        };
//        clock.start();// TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_txtShumberNumKeyReleased

    private void txtShumberNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtShumberNumKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtShumberNumKeyTyped

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyTyped

    private void txtReminderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReminderKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReminderKeyTyped

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
Thread clock;
        clock = new Thread() {
            @Override
            public void run() {

                while (true) {
                    if(  Integer.parseInt(txtTotal.getText()  ) > 0)
                    {
                   int total=Integer.parseInt(txtTotal.getText()) - Integer.parseInt(txtPaid.getText());
                   txtReminder.setText(Integer.toString(total));
                    
                   try{
                                      wait();
                                      break;
                  

                   }catch(Exception e )
                   {
                   e.printStackTrace();
                   return;
                   }
                }
            
            }
}
        };
        
        clock.start();    

        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidKeyReleased

    private void txtPaidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(txtName.getText().equals("")){
JOptionPane.showMessageDialog(this, "من فضلك ادخل اسم التاجر ");
}
        int total=Integer.parseInt(txtTotal.getText());
   int ba2y=Integer.parseInt(txtTotal.getText())-Integer.parseInt(txtPaid.getText());
//   if(txtShumberNum.getText().equals(null) || Integer.parseInt(txtShumberNum.getText() ) == 0)
//{
//JOptionPane.showMessageDialog(this, "من فضلك أدخل رقم الشمبر ");
//}
//   else if(Integer.parseInt(txtKemmya.getText() ) == 0)
//   {
//   JOptionPane.showMessageDialog(this, "من فضلك أدخل كمية صحيحة ");
//   }
//else{
try{
    String sdate = ((JTextField) jDateChooser.getDateEditor().getUiComponent()).getText();


String sql="INSERT INTO `traders_1`(`t_name`, `date`, `phone`, `num_shamp`, `class`, `color`, `type`, `mark`, `number`, `price_shamp`, `price`, `payed`, `total`, `reset`) VALUES ('"+txtName.getText()+" ','"+sdate+"' ,'"+txtphoneNum.getText()+" ','"+Integer.parseInt(txtShumberNum.getText())+"','"+txtSanf.getText()+"' ,'"+txtColor.getText()+ "' ,'"+txtType.getText()+" ','"+txtMarka.getText()+ " ','"+txtKemmya.getText()+ "' ,'"+Integer.parseInt(txtShumberPrice.getText())+" ','"+Integer.parseInt(txtSalePrice.getText())+" ','"+Integer.parseInt(txtPaid.getText())+"' ,'"+total+ "','"+ba2y+"')";

 preparedStatement = conn.prepareStatement(sql);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "تم حفظ البيانات ");
                
                  int  amount,new_amount;
  amount= Integer.parseInt(txtKemmya.getText());
  int old_amount = 0;
 
        //makhazen
          try{
       String sql5 = "Select amount from makhazen where num='"+txtShumberNum.getText()+"' ";
       pst = con.prepareStatement(sql5);
       rs = pst.executeQuery();
       if (rs.next()){
         old_amount = rs.getInt(1);
       }
          }
       catch(Exception e){
               
               
               }
         try{
      
         con=Connect.connect();
        
       String sql6 = "Select * from makhazen where num='"+txtShumberNum.getText()+"' ";
       pst = con.prepareStatement(sql6);
       rs = pst.executeQuery();
       if (rs.next()){
   
          new_amount=old_amount+amount;
        con =  Connect.connect();
           try{
      String sql1= "update makhazen set  amount ='"+new_amount+"' where num='"+txtShumberNum.getText()+"'";
          pst = con.prepareStatement(sql1);
      pst.executeUpdate();
     // JOptionPane.showMessageDialog(null, "aaaa");
      }
      catch(Exception e){
      JOptionPane.showMessageDialog(null, e.getMessage());
      }
           
 
       
     
         }
       else{
       
       con =  Connect.connect();
    try{
         String sql3 = "insert into makhazen (num,amount) values ('"+txtShumberNum.getText()+"','"+txtKemmya.getText()+"')";
      pst = con.prepareStatement(sql3);
      pst.execute();
       
      
      }
      catch(Exception e){
      JOptionPane.showMessageDialog(null,  e.getMessage());
      
      }
       
       
       }
        
      }
      catch(Exception e){
      JOptionPane.showMessageDialog(null,  e.getMessage());
      
      }
                
                reset();

}catch(Exception e)
{
JOptionPane.showMessageDialog(this, "خطأ فى تسجيل البيانات ");
}
         
    
//}
        

// TODO add your handling code here:
       
        

        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void upDateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upDateBtnActionPerformed

          if (txtName.getText().equals(null)){
     JOptionPane.showMessageDialog(null,"برجاء إختيار البيانات المراد تعديلها من الجدول  "); 
     }
     else if(Integer.parseInt(txtKemmya.getText()) == 0 )
         
     {
     JOptionPane.showMessageDialog(null,"برجاء إختيار البيانات المراد تعديلها من الجدول  "); 

     }
          
          
     else {
     
            conn = Connect.connect();
            
                String sdate = ((JTextField) jDateChooser.getDateEditor().getUiComponent()).getText();

            try {
                
                
                con =  Connect.connect();
                  String sql3= "update makhazen set amount= '" +Integer.parseInt(txtKemmya.getText() ) + "' where num= '"+txtShumberNum.getText()+"'";

         String sql="UPDATE `traders_1` SET  t_name='"+txtName.getText()+"',`date`='"+sdate+ " ',`phone`='"+txtphoneNum.getText()+" ',`num_shamp`='"+Integer.parseInt(txtShumberNum.getText())+" ',"
                        + "`class`='"+ txtSanf.getText()+ "' ,`color`='"+txtColor.getText()+"' ,`type`='"+txtType.getText()+" ',`mark`='"+txtMarka.getText()
                        +" ',`number`='"+Integer.parseInt(txtKemmya.getText())+" ',`price_shamp`='"+Integer.parseInt(txtShumberPrice.getText())+" ',`price`='"+Integer.parseInt(txtSalePrice.getText())+" ',`payed`='"+Integer.parseInt(txtPaid.getText())+" ',`total`='"+Integer.parseInt(txtTotal.getText())+ " ',`reset`='"+Integer.parseInt(txtReminder.getText())+ "'  WHERE t_ID='"+id+"'  ";
          pst = con.prepareStatement(sql);
      pst.executeUpdate();
      
                   pst = con.prepareStatement(sql3);
      pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "تم التعديل بنجاح");
                   
          reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "خطأ فى تعديل البيانات  " + e.getMessage());
                reset();
            
        }
     
     
     }
    
            
            
    }//GEN-LAST:event_upDateBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 if(txtShumberNum.getText().isEmpty() && txtColor.getText().isEmpty()  ){
            JOptionPane.showMessageDialog(null, " برجاء تحديد البيانات المراد حذفها من الجدول  ");
        }
        
        try {
            if (txtShumberNum.getText().equals(""))
            {
            JOptionPane.showMessageDialog(null, " برجاء تحديد البيانات المراد حذفها من الجدول  ");
            }
            
                
                   
              int P = JOptionPane.showConfirmDialog(null, " Are you sure want to delete ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (P == 0) {
            String sql2="delete from makhazen where num='"+txtShumberNum.getText()+"' ";

            String sql = "DELETE FROM traders_1 WHERE t_ID= '" + id + "' ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "تم حذف البيانات ");
        } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " خطأفي حذف البيانات ");
        }
        try{
         String sql2 ="Select * from traders_1 "; 
        
    pst = con.prepareStatement(sql2);
    rs = pst.executeQuery();
    
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             
        } catch (Exception e) {

        
         }       
 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       

          try{
                      fillTxt();
          }catch(Exception e)
          {
//          JOptionPane.showMessageDialog(null, "خطأ فى إسترجاع البيانات ");
          }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtShumberPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtShumberPriceKeyTyped
  char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShumberPriceKeyTyped

    private void txtShumberPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtShumberPriceKeyReleased
Thread clock;
        clock = new Thread() {
            @Override
            public void run() {

                while (true) {
                    if(  Integer.parseInt(txtKemmya.getText()  ) > 0)
                    {
                   int total=Integer.parseInt(txtKemmya.getText()) * Integer.parseInt(txtShumberPrice.getText());
                   txtTotal.setText(Integer.toString(total));
                    
                   try{
                                      wait();
                                      break;
                  

                   }catch(Exception e )
                   {
                   e.printStackTrace();
                   return;
                   }
                }
                    
            
            }
}
        };
        
        clock.start();        // TODO add your handling code here:
    }//GEN-LAST:event_txtShumberPriceKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:

        try{
            con = Connect.connect();
            String sql = "select * from  traders_1 where t_name like '" + jTextField1.getText() + "%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            Vector<String> colName = new Vector<String>();
             colName.add("كود ");
            colName.add("اسم التاجر");
            colName.add("التاريخ");
            colName.add("رقم التليفون");
            colName.add("رقم الشمبر");
            colName.add("الصنف ");
            colName.add("اللون ");
            colName.add("النوع ");
            colName.add("الماركة ");
            colName.add("الكمية ");
            colName.add("سعر الشمبر ");
            colName.add("سعر البيع  ");

            colName.add("المدفوع");
            colName.add("الإجمالي ");
            colName.add("الباقي");
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(90);
//            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);

            jTable1.setShowHorizontalLines(true);
            jTable1.setShowVerticalLines(true);
            //jTable1e.scrollRectToVisible(jTable1e.getCellRect(jTable1e.getRowCount()-1, 0, true));

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        for (int x = 0; x < jTable1.getColumnCount(); x++) {
            jTable1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void txtName1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtName1KeyReleased
        //        search();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1KeyReleased

    private void txtTotal1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal1KeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == evt.VK_BACK_SPACE || c == '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "غير مسموح بكتابه حروف");
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1KeyTyped

    private void txtTotal2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal2KeyTyped

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
            java.util.logging.Logger.getLogger(Traders1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Traders1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Traders1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Traders1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Traders1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtKemmya;
    private javax.swing.JTextField txtMarka;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtReminder;
    private javax.swing.JTextField txtSalePrice;
    private javax.swing.JTextField txtSanf;
    private javax.swing.JTextField txtShumberNum;
    private javax.swing.JTextField txtShumberPrice;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    private javax.swing.JTextField txtTotal2;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtphoneNum;
    private javax.swing.JButton upDateBtn;
    // End of variables declaration//GEN-END:variables
}
