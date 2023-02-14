import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class productForm extends javax.swing.JFrame {

    public productForm() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
	// Clear All
	public void clear() {
		txtSSN.setText("");
		txtName.setText("");
		txtAge.setText("");
		//txtDnum.setText("");
		txtSalary.setText("");
		//txtDN.setText("");
		ShowDnum.setText("");
		
		
		txtName.requestFocus();
	}
 public void Connect() {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/company", "root", "123456");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);

       }
 }
    public void LoadProductNo(){
        try {
            pst = con.prepareStatement("SELECT Dep_num FROM department");
            rs = pst.executeQuery();
           txtDnum.removeAllItems();
            while(rs.next()){
            txtDnum.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void LoadSSN(){
        try {
            pst = con.prepareStatement("SELECT SSN FROM emplooye");
            rs = pst.executeQuery();
           // txtFindBySSN.removeAllItems();
            
            while(rs.next()){
            	//txtFindBySSN.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	// Load Table

	
	
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM emplooye");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("SSN"));
                    v2.add(rs.getString("Age"));
                    v2.add(rs.getString("Salary"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Department_Dep_num"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        txtDnum = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Age:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Salary:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPnameActionPerformed(evt);
            }
        });

        txtDnum.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6"}));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        btnSearch = new javax.swing.JButton();
        
                btnSearch.setText("Search");
                btnSearch.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSearchActionPerformed(evt);
                    }
                });
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clear();
        	}
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(btnAdd)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnUpdate)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnDelete)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnSearch)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnClear)
        			.addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(8)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnAdd)
        				.addComponent(btnUpdate)
        				.addComponent(btnDelete)
        				.addComponent(btnSearch)
        				.addComponent(btnClear))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jTable1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"SSN", "Age", "Salary", "Name", "Department Number"
        	}
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Company MS 0.5");
        
        txtSSN = new JTextField();
        txtSSN.setColumns(10);
        
        JLabel lblSsn = new JLabel();
        lblSsn.setText("SSN :");
        lblSsn.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel jLabel4_1 = new JLabel();
        jLabel4_1.setText("Department Number:");
        jLabel4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        ShowDnum = new JTextField();
        ShowDnum.setColumns(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(273)
        						.addComponent(jLabel5))
        					.addGroup(layout.createSequentialGroup()
        						.addContainerGap()
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(lblSsn)
        								.addGap(18)
        								.addComponent(txtSSN, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        									.addComponent(jLabel2))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(txtAge, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        									.addComponent(txtName)))))
        					.addGroup(layout.createSequentialGroup()
        						.addContainerGap()
        						.addComponent(jLabel3)
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(txtSalary, 187, 187, 187))
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(jLabel4_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(txtDnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(ShowDnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGroup(layout.createSequentialGroup()
        						.addContainerGap()
        						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(21)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtSSN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblSsn, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel1)
        						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2))))
        			.addGap(1)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(txtSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(ShowDnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(43)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(168, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPnameActionPerformed
    }//GEN-LAST:event_txtPnameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
     // TODO add your handling code here:
			String id = txtSSN.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			String Dnum = txtDnum.getSelectedItem().toString();
			String ESalary=txtSalary.getText();
     
    pst = con.prepareStatement ("Insert INTO emplooye(SSN,Age,Salary,Name,Department_Dep_num)VALUES(?,?,?,?,?)");
    pst.setString(4, name);
    pst.setString(1   , id);
     pst.setString(2, age);
      pst.setString(3, ESalary);
       pst.setString(5, Dnum);
  
     int k = pst.executeUpdate();
             
     if (k==1) {
        JOptionPane.showMessageDialog(this, "Record Added!! successfully!");
        clear();
         Fetch();
         LoadProductNo();
     }else{
    JOptionPane.showMessageDialog(this, "Record failed to saved!!!");
     }
        }catch (SQLException ex) {
    Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    //GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    	   // TODO add your handling code here:
        try {
     String SSN = txtSSN.getText();
    pst = con.prepareStatement("SELECT * FROM emplooye WHERE SSN=?");
    pst.setString(1,SSN);
    rs=pst.executeQuery();
     if (rs.next()==true) {
         txtSSN.setText(rs.getString(1));
         txtAge.setText(rs.getString(2));
         txtName.setText(rs.getString(4));
         txtSalary.setText(rs.getString(3));
         ShowDnum.setText(rs.getString(5));;

         
        }else {
         JOptionPane.showMessageDialog(this,"No record found!!");
     }
        } catch (SQLException ex) {
    Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);

    }//GEN-LAST:event_btnSearchActionPerformed
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try{
			String id = txtSSN.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			String Dnum = txtDnum.getSelectedItem().toString();
			String ESalary=txtSalary.getText();
        pst = con.prepareStatement("UPDATE emplooye SET Age=?,Salary=?,Name=?,Department_Dep_num=? WHERE SSN=?");
        //UPDATE `emplooye` SET `SSN`='[value-1]',`Age`='[value-2]',`Salary`='[value-3]',`Name`='[value-4]',`Department_Dep_num`='[value-5]' WHERE 1
        pst.setString(5 , id);
        pst.setString(1, age);
        pst.setString(2, ESalary);
        pst.setString(3, name);
        pst.setString(4, Dnum);
        int k = pst.executeUpdate();
        if(k==1){
            JOptionPane.showMessageDialog(this,"Record has been successfully updated!!");
            clear();
            Fetch();
         LoadProductNo();
        }
    }catch (SQLException ex) {
    Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            String pid = txtSSN.getText();
            pst = con.prepareStatement("DELETE FROM emplooye  WHERE SSN=?");
            pst.setString(1,pid);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record has been successfully Deleted!!");
                clear();
            Fetch();
         LoadProductNo();
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to delete!!");

            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
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
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JComboBox<String> txtDnum;
    private JTextField txtSSN;
    private JTextField ShowDnum;
}
