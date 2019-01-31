package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Models.SalesLine;

public class SalesLineTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = { "Item", "Quantity", "Price", "Subtotal" };
	private List<SalesLine> salesLineList;
	
	public SalesLineTableModel() {
		super();
		salesLineList = new ArrayList<>();
	}
	
	public void setModelData(List<SalesLine> list) {
		this.salesLineList = new ArrayList<>(list);
		super.fireTableDataChanged();
	}
	
	public SalesLine getValueAtRow(int ix) {
		return salesLineList.get(ix);
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
		if(salesLineList != null) {
			res = salesLineList.size();
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
		SalesLine currSalesLine = this.salesLineList.get(rowIndex);
		String res = "<KEH?>";
		switch(columnIndex) {
			case 0: 
				res = currSalesLine.getItem().getName(); 
				break;
			case 1: 
				res = "" + currSalesLine.getQuantity();
				break;
			case 2:
				res = "" + currSalesLine.getItem().getPrice() + " kr.";
				break;
			case 3:
				res = currSalesLine.getSubtotal() + " kr.";
		}
		return res;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		SalesLine row = salesLineList.get(rowIndex);
		
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