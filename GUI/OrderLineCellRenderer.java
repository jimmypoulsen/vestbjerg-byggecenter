package GUI;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import Models.OrderLine;

public class OrderLineCellRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		OrderLine oL = (OrderLine)value;
		String text = oL.getItem().getName() + " (" + oL.getQuantity() + ")" + ": " + oL.getSubtotal() + " kr.";
		
		return super.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
	}

	
}
