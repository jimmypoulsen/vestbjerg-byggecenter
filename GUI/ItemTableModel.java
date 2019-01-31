package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Models.Item;

public class ItemTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = { "Barcode", "Name", "Price", "Stock" };
	private List<Item> itemList;
	
	public ItemTableModel() {
		super();
		itemList = new ArrayList<>();
	}
	
	public void setModelData(List<Item> list) {
		this.itemList = new ArrayList<>(list);
		super.fireTableDataChanged();
	}
	
	public Item getValueAtRow(int ix) {
		return itemList.get(ix);
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
		if(itemList != null) {
			res = itemList.size();
		}
		return res;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Item currItem = this.itemList.get(rowIndex);
		String res = "<KEH?>";
		switch(columnIndex) {
			case 0:
				res = "" + currItem.getBarcode();
				break;
			case 1:
				res = currItem.getName();
				break;
			case 2:
				res = currItem.getPrice() + " kr.";
				break;
			case 3:
				res = "" + currItem.getStock();
				break;
		}
		return res;
	}
}