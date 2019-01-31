package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Models.Employee;

public class EmployeeTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = { "Employee no", "Name", "Phone", "Title" };
	private List<Employee> employeeList;
	
	public EmployeeTableModel() {
		super();
		employeeList = new ArrayList<>();
	}
	
	public void setModelData(List<Employee> list) {
		this.employeeList = new ArrayList<>(list);
		super.fireTableDataChanged();
	}
	
	public Employee getValueAtRow(int ix) {
		return employeeList.get(ix);
	}
	
	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public int getRowCount() {
		int res = 0;
		if(employeeList != null) {
			res = employeeList.size();
		}
		return res;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee currEmployee = this.employeeList.get(rowIndex);
		String res = "<KEH?>";
		switch(columnIndex) {
			case 0:
				res = "" + currEmployee.getEmployeeNo();
				break;
			case 1:
				res = currEmployee.getFullName();
				break;
			case 2:
				res = currEmployee.getPhone();
				break;
			case 3:
				res = "" + currEmployee.getTitle();
				break;
		}
		return res;
	}
}