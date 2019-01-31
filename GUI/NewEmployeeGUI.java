package GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controllers.*;
import Models.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class NewEmployeeGUI extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private EmployeeController employeesCtrl;
	private BranchController branchesCtrl;
	private Employee employee;
	private JButton btnUpdate;
	private JLabel lblLastname;
	private JLabel lblCpr;
	private JLabel lblPhone;
	private JLabel lblPassword;
	private JLabel lblTitle;
	private JTextField txtLastname;
	private JTextField txtCpr;
	private JTextField txtPhone;
	private JTextField txtTitle;
	private JButton btnCancel;
	private JLabel lblFirstname;
	private JTextField txtFirstname;
	private JPasswordField pwdPassword;
	private DefaultListModel<String> listModel;
	private JList<String> branchList;
	private JLabel lblBranch;

	/**
	 * Create the dialog.
	 */
	public NewEmployeeGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{116, 83, 0};
		gbl_contentPanel.rowHeights = new int[]{26, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		lblFirstname = new JLabel("Firstname");
		GridBagConstraints gbc_lblFirstname = new GridBagConstraints();
		gbc_lblFirstname.anchor = GridBagConstraints.EAST;
		gbc_lblFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstname.gridx = 0;
		gbc_lblFirstname.gridy = 0;
		contentPanel.add(lblFirstname, gbc_lblFirstname);
		
		txtFirstname = new JTextField();
		GridBagConstraints gbc_txtFirstname = new GridBagConstraints();
		gbc_txtFirstname.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstname.gridx = 1;
		gbc_txtFirstname.gridy = 0;
		contentPanel.add(txtFirstname, gbc_txtFirstname);
		txtFirstname.setColumns(10);
		
		lblLastname = new JLabel("Lastname");
		GridBagConstraints gbc_lblLastname = new GridBagConstraints();
		gbc_lblLastname.anchor = GridBagConstraints.EAST;
		gbc_lblLastname.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastname.gridx = 0;
		gbc_lblLastname.gridy = 1;
		contentPanel.add(lblLastname, gbc_lblLastname);
		
		txtLastname = new JTextField();
		GridBagConstraints gbc_txtLastname = new GridBagConstraints();
		gbc_txtLastname.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastname.gridx = 1;
		gbc_txtLastname.gridy = 1;
		contentPanel.add(txtLastname, gbc_txtLastname);
		txtLastname.setColumns(10);
		
		lblCpr = new JLabel("CPR no");
		GridBagConstraints gbc_lblCpr = new GridBagConstraints();
		gbc_lblCpr.anchor = GridBagConstraints.EAST;
		gbc_lblCpr.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpr.gridx = 0;
		gbc_lblCpr.gridy = 2;
		contentPanel.add(lblCpr, gbc_lblCpr);
		
		txtCpr = new JTextField();
		GridBagConstraints gbc_txtCpr = new GridBagConstraints();
		gbc_txtCpr.insets = new Insets(0, 0, 5, 0);
		gbc_txtCpr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpr.gridx = 1;
		gbc_txtCpr.gridy = 2;
		contentPanel.add(txtCpr, gbc_txtCpr);
		txtCpr.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.EAST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 3;
		contentPanel.add(lblPhone, gbc_lblPhone);
		
		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.gridx = 1;
		gbc_txtPhone.gridy = 3;
		contentPanel.add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);
		
		lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 4;
		contentPanel.add(lblTitle, gbc_lblTitle);
		
		txtTitle = new JTextField();
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitle.gridx = 1;
		gbc_txtTitle.gridy = 4;
		contentPanel.add(txtTitle, gbc_txtTitle);
		txtTitle.setColumns(10);
		
		lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 5;
		contentPanel.add(lblPassword, gbc_lblPassword);
		
		pwdPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.gridx = 1;
		gbc_pwdPassword.gridy = 5;
		contentPanel.add(pwdPassword, gbc_pwdPassword);
		
		lblBranch = new JLabel("Branch");
		GridBagConstraints gbc_lblBranch = new GridBagConstraints();
		gbc_lblBranch.insets = new Insets(0, 0, 5, 5);
		gbc_lblBranch.gridx = 0;
		gbc_lblBranch.gridy = 6;
		contentPanel.add(lblBranch, gbc_lblBranch);
		
		listModel = new DefaultListModel<String>();
		branchList = new JList<String>(listModel);
		branchList.setVisibleRowCount(2);
		GridBagConstraints gbc_branchList = new GridBagConstraints();
		gbc_branchList.insets = new Insets(0, 0, 5, 0);
		gbc_branchList.fill = GridBagConstraints.BOTH;
		gbc_branchList.gridx = 1;
		gbc_branchList.gridy = 6;
		contentPanel.add(branchList, gbc_branchList);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		buttonPane.add(btnCancel);
		
		btnUpdate = new JButton("Create");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createEmployee();
			}
		});
		buttonPane.add(btnUpdate);
		
		init();
	}
	
	private void init() {
		employeesCtrl = new EmployeeController();
		branchesCtrl = new BranchController();
		displayBranches();
	}
	
	private void displayBranches() {
		for(Branch currBranch : branchesCtrl.getAllBranches())
			listModel.addElement(currBranch.getName());
	}
	
	private void createEmployee() {
		if(!txtFirstname.getText().equals("") && !txtLastname.getText().equals("") && !txtCpr.getText().equals("")
				&& !txtPhone.getText().equals("") && !txtTitle.getText().equals("") && !pwdPassword.getText().equals("") && !branchList.getSelectedValue().equals("")) {
			try {
				Employee employee = employeesCtrl.createEmployee(txtFirstname.getText(), txtLastname.getText(), txtCpr.getText(), txtPhone.getText(), "Hemmeligvej 1", 000, "Aalborg", pwdPassword.getText(), "Admin", txtTitle.getText());
				JOptionPane.showMessageDialog(this, "Employee created!", "Success", JOptionPane.INFORMATION_MESSAGE);
				EmployeesGUI.getInstance().displayEmployees();
				this.setVisible(false);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Something went wrong ...", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "You need to fill out all the text fields", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void exit() {
		this.setVisible(false);
	}
}
