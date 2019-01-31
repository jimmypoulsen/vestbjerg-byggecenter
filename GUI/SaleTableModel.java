package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Models.Sale;

public class SaleTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = { "ID", "Total", "State" };
	private List<Sale> salesList;
	
	public SaleTableModel() {
		super();
		salesList = new ArrayList<>();
	}
	
	public void setModelData(List<Sale> list) {
		this.salesList = new ArrayList<>(list);
		super.fireTableDataChanged();
	}
	
	public Sale getValueAtRow(int ix) {
		return salesList.get(ix);
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
		if(salesList != null) {
			res = salesList.size();
		}
		return res;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sale currSale = this.salesList.get(rowIndex);
		String res = "<KEH?>";
		switch(columnIndex) {
			case 0: 
				res = "" + currSale.getSalesId(); 
				break;
			case 1: 
				res = "" + currSale.getTotal() + " kr.";
				break;
			case 2:
				res = "" + currSale.getState();
		}
		return res;
	}
}