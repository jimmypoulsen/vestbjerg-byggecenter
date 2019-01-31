package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

import Controllers.*;
import Models.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JList;

public class EmployeesGUI extends JPanel {
	private static EmployeesGUI instance;
	private NewEmployeeGUI newEmployeeGUI;
	private EmployeeController employeesCtrl;
	private JTable employeesTable;
	private EmployeeTableModel employeeTableModel;
	
	public static EmployeesGUI getInstance() {
		if(instance == null)
			instance = new EmployeesGUI();
		return instance;
	}
	
	/**
	 * Create the panel.
	 */
	private EmployeesGUI() {
		setMinimumSize(new Dimension(350, 200));
		setLayout(new BorderLayout(0, 0));
		
		Container container = new Container();
		add(container, BorderLayout.CENTER);
		container.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		container.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnCreateEmployee = new JButton("Create employee");
		btnCreateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEmployee();
			}
		});
		GridBagConstraints gbc_btnCreateEmployee = new GridBagConstraints();
		gbc_btnCreateEmployee.gridwidth = 4;
		gbc_btnCreateEmployee.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateEmployee.gridx = 0;
		gbc_btnCreateEmployee.gridy = 1;
		panel.add(btnCreateEmployee, gbc_btnCreateEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(350, 125));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);
		
		employeesTable = new JTable();
		scrollPane.setViewportView(employeesTable);
		
		init();
	}
	
	private void init() {
		employeesCtrl = new EmployeeController();
		employeeTableModel = new EmployeeTableModel();
		employeesTable.setModel(employeeTableModel);
		
		TableRowSorter<EmployeeTableModel> sorter = new TableRowSorter<EmployeeTableModel>(employeeTableModel);
		employeesTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		displayEmployees();
	}
	
	public void displayEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>(employeesCtrl.getAllEmployees().values());
		employeeTableModel.setModelData(employees);
	}
	
	private void newEmployee() {
		newEmployeeGUI = new NewEmployeeGUI();
		newEmployeeGUI.setVisible(true);
	}
}
