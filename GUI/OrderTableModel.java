package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Models.Order;

public class OrderTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = { "ID", "Total", "Customer", "State" };
	private List<Order> orderList;
	
	public OrderTableModel() {
		super();
		orderList = new ArrayList<>();
	}
	
	public void setModelData(List<Order> list) {
		this.orderList = new ArrayList<>(list);
		super.fireTableDataChanged();
	}
	
	public Order getValueAtRow(int ix) {
		return orderList.get(ix);
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
		if(orderList != null) {
			res = orderList.size();
		}
		return res;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order currOrder = this.orderList.get(rowIndex);
		String res = "<KEH?>";
		switch(columnIndex) {
			case 0: 
				res = "" + currOrder.getOrderId(); 
				break;
			case 1: 
				res = "" + currOrder.getTotal() + " kr.";
				break;
			case 2:
				res = currOrder.getCustomer().getCompany().getName() + ": " + currOrder.getCustomer().getFirstName();
				break;
			case 3:
				res = "" + currOrder.getState();
				break;
		}
		return res;
	}
}