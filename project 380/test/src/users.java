import java.awt.EventQueue;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.EventQueue;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Button;
import java.awt.EventQueue;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
public class users {
 
	private JFrame frmCurdOperationSwing;
	private JTextField txtSSN;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtDnum;
	private JTable table;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					users window = new users();
					window.frmCurdOperationSwing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the application.
	 */
	public users() {
		initialize();
		 Connect();
		 loadData();
		 loadDepT() ;
		 loadWT();
		 loadproject();
	}
 
 
	//Database Connection
	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtSalary;
	private JTable DepT;
	private JTable WT;
	private JTable PT;
 
	public void Connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/company", "root", "123456");
		} catch (Exception ex) {
			 JOptionPane.showMessageDialog(null,"Wrong!");
			ex.printStackTrace();
		}
	}
 
	// Clear All
		public void clear() {
			txtSSN.setText("");
			txtName.setText("");
			txtAge.setText("");
			txtDnum.setText("");
			txtSalary.setText("");
			txtName.requestFocus();
		}
		
		
		
		
		
 
		// Load Table
		public void loadData() {
			try {
				pst = con.prepareStatement("Select * from emplooye");
				rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		public void loadDepT() {
			try {
				pst = con.prepareStatement("Select * from department ");
				rs = pst.executeQuery();
				DepT.setModel(DbUtils.resultSetToTableModel(rs));
 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public void loadWT() {
			try {
				pst = con.prepareStatement("Select * from works_on ");
				rs = pst.executeQuery();
				WT.setModel(DbUtils.resultSetToTableModel(rs));
 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		public void loadproject() {
			try {
				pst = con.prepareStatement("Select * from project ");
				rs = pst.executeQuery();
				PT.setModel(DbUtils.resultSetToTableModel(rs));
 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurdOperationSwing = new JFrame();
		frmCurdOperationSwing.setTitle("CURD Operation Swing MySQL");
		frmCurdOperationSwing.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmCurdOperationSwing.getContentPane().setLayout(null);
 
		JLabel lblNewLabel = new JLabel("Company Management System");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 259, 60);
		frmCurdOperationSwing.getContentPane().add(lblNewLabel);
 
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(20, 71, 433, 284);
		frmCurdOperationSwing.getContentPane().add(panel);
		panel.setLayout(null);
 
		JLabel lblNewLabel_1 = new JLabel("SSN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 46, 46, 24);
		panel.add(lblNewLabel_1);
 
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(21, 81, 46, 24);
		panel.add(lblNewLabel_1_1);
 
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(21, 120, 46, 24);
		panel.add(lblNewLabel_1_2);
 
		JLabel lblNewLabel_1_3 = new JLabel("Department Number");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 154, 137, 24);
		panel.add(lblNewLabel_1_3);
 
		txtSSN = new JTextField();
		txtSSN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSSN.setBounds(78, 46, 287, 24);
		panel.add(txtSSN);
		txtSSN.setColumns(10);
 
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(78, 81, 287, 24);
		panel.add(txtName);
 
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(78, 120, 287, 24);
		panel.add(txtAge);
 
		txtDnum = new JTextField();
		txtDnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDnum.setColumns(10);
		txtDnum.setBounds(147, 155, 218, 24);
		panel.add(txtDnum);
 
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String id = txtSSN.getText();
				String name = txtName.getText();
				String age = txtAge.getText();
				String Dnum = txtDnum.getText();
				String ESalary=txtSalary.getText();
	            pst = con.prepareStatement("Insert INTO emplooye(SSN,Age,Salary,Name,Department_Dep_num)VALUES(?,?,?,?,?)");
	            pst.setString(4, name);
	             pst.setString(1   , id);
	              pst.setString(2, age);
	               pst.setString(3, ESalary);
	                pst.setString(5, Dnum);
	                int k = pst.executeUpdate();
	                if(k== 1){
	                    JOptionPane.showMessageDialog(null,"Record Added!! Successfully!");
	            //		JOptionPane.showMessageDialog(this, "Record Added!! Successfully!");
	                	clear();
						loadData();
	                }
	                else{
	                    JOptionPane.showMessageDialog(null,"Record Failed to save!!");
	                }
	               
	        } catch (SQLException ex) {
	            Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
	            //JOptionPane.showMessageDialog(this,"there is Wrong!");
	        
	        }
 
 
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(10, 251, 89, 23);
		panel.add(btnSave);
 
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				// Update Details
				String id = txtSSN.getText();
				String name = txtName.getText();
				String age = txtAge.getText();
				String Dnum = txtDnum.getText();
				String ESalary=txtSalary.getText();
						pst = con.prepareStatement("UPDATE emplooye SET Age=?,Salary=?,Name=?,Department_Dep_num=? WHERE SSN=?");
			            pst.setString(5, id);    
			            pst.setString(1, age);
			            pst.setString(2, ESalary);
			            pst.setString(3, name);
			            pst.setString(4, Dnum);
			                pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Update Success");
						clear();
						loadData();
 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		
		
		
		
	);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(109, 251, 89, 23);
		panel.add(btnUpdate);
 
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete Details
				String id = txtSSN.getText();
				if (!txtSSN.getText().isEmpty()) {
 
					int result = JOptionPane.showConfirmDialog(null, "Sure? You want to Delete?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
 
					if (result == JOptionPane.YES_OPTION) {
						try {
							String sql = "DELETE FROM emplooye  WHERE SSN=?";
							pst = con.prepareStatement(sql);
							pst.setString(1, id);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Data Deleted Success");
							clear();
							loadData();
 
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
 
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(208, 251, 89, 23);
		panel.add(btnDelete);
		
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalary.setColumns(10);
		txtSalary.setBounds(147, 188, 218, 24);
		panel.add(txtSalary);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Salary");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(10, 188, 137, 24);
		panel.add(lblNewLabel_1_3_1);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
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
		         txtSalary.setText(rs.getString(3));
		         txtName.setText(rs.getString(4));
		         txtDnum.setText(rs.getString(5));;

		         
		        }else {
		         JOptionPane.showMessageDialog(null,"No record found!!");
		     }
		        } catch (SQLException ex) {
		    Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);

		    }
				
				
				
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelect.setBounds(307, 250, 89, 24);
		panel.add(btnSelect);
 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(463, 71, 839, 747);
		frmCurdOperationSwing.getContentPane().add(scrollPane);
 
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
 
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				// ID NAME AGE CITY
				txtSSN.setText(model.getValueAt(index, 0).toString());
				txtAge.setText(model.getValueAt(index, 1).toString());
				txtSalary.setText(model.getValueAt(index, 2).toString());
				txtName.setText(model.getValueAt(index, 3).toString());
				
				txtDnum.setText(model.getValueAt(index, 4).toString());
				
				
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 365, 416, 455);
		frmCurdOperationSwing.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Department", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 391, 119);
		panel_1.add(scrollPane_1);
		
		DepT = new JTable();
		DepT.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Dep_num", "Location", "Dep_name", "Emplooye_SSN", "Date_of_Mng"
			}
		));
		scrollPane_1.setViewportView(DepT);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Works On", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 10, 391, 119);
		panel_2.add(scrollPane_1_1);
		
		WT = new JTable();
		WT.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Emplooye_SSN", "Project_Project_num", "Hours"
			}
		));
		scrollPane_1_1.setViewportView(WT);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Project", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(10, 10, 391, 119);
		panel_3.add(scrollPane_1_1_1);
		
		PT = new JTable();
		PT.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Project_num", "Project_name", "Department_Dep_num"
			}
		));
		scrollPane_1_1_1.setViewportView(PT);
		frmCurdOperationSwing.setBounds(100, 100, 1401, 923);
		frmCurdOperationSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
