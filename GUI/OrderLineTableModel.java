package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Models.OrderLine;

public class OrderLineTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = { "Item", "Quantity", "Price", "Subtotal" };
	private List<OrderLine> orderLineList;
	
	public OrderLineTableModel() {
		super();
		orderLineList = new ArrayList<>();
	}
	
	public void setModelData(List<OrderLine> list) {
		this.orderLineList = new ArrayList<>(list);
		super.fireTableDataChanged();
	}
	
	public OrderLine getValueAtRow(int ix) {
		return orderLineList.get(ix);
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
		if(orderLineList != null) {
			res = orderLineList.size();
		}
		return res;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		boolean res = false;
		switch(columnIndex) {
			case 1:
				res = true;
				break;
			case 2:
				res = true;
				break;
		}
		return res;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderLine currentOrderLine = this.orderLineList.get(rowIndex);
		String res = "<KEH?>";
		switch(columnIndex) {
			case 0: 
				res = currentOrderLine.getItem().getName(); 
				break;
			case 1: 
				res = "" + currentOrderLine.getQuantity();
				break;
			case 2:
				res = "" + currentOrderLine.getItem().getPrice() + " kr.";
				break;
			case 3:
				res = currentOrderLine.getSubtotal() + " kr.";
		}
		return res;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		OrderLine row = orderLineList.get(rowIndex);
		
		switch(columnIndex) {
			case 0:
				System.out.println("Not possible!");
				break;
			case 1:
				row.setQuantity(Integer.parseInt((String) aValue));
				row.setSubtotal(row.getSubtotal());
				break;
			case 2:
				try {
					row.getItem().setPrice((Double.parseDouble((String) aValue)));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Only numbers!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				row.setSubtotal(row.getSubtotal());
				break;
			case 3:
				System.out.println("Not possible!");
				break;
		}
	}
	
}