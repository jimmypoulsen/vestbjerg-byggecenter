package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import Controllers.*;
import Models.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

public class ItemsGUI extends JPanel {
	private static ItemsGUI instance;
	private EditItemGUI editItemGUI;
	private NewItemGUI newItemGUI;
	private ItemController itemsCtrl;
	private JTextField txtItemName;
	private ItemTableModel itemTableModel;
	private JTable itemsTable;
	private JButton btnSearch;
	
	public static ItemsGUI getInstance() {
		if(instance == null)
			instance = new ItemsGUI();
		return instance;
	}
	
	/**
	 * Create the panel.
	 */
	private ItemsGUI() {
		setMinimumSize(new Dimension(350, 200));
		setLayout(new BorderLayout(0, 0));
		
		Container container = new Container();
		add(container, BorderLayout.CENTER);
		container.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		container.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 305, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnCreateItem = new JButton("Create item");
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newItem();
			}
		});
		GridBagConstraints gbc_btnCreateItem = new GridBagConstraints();
		gbc_btnCreateItem.gridwidth = 7;
		gbc_btnCreateItem.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateItem.gridx = 0;
		gbc_btnCreateItem.gridy = 1;
		panel.add(btnCreateItem, gbc_btnCreateItem);
		
		txtItemName = new JTextField();
		GridBagConstraints gbc_txtItemName = new GridBagConstraints();
		gbc_txtItemName.gridwidth = 4;
		gbc_txtItemName.insets = new Insets(0, 0, 5, 5);
		gbc_txtItemName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItemName.gridx = 0;
		gbc_txtItemName.gridy = 2;
		panel.add(txtItemName, gbc_txtItemName);
		txtItemName.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchForItem();
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.gridwidth = 3;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 2;
		panel.add(btnSearch, gbc_btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(350, 125));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		panel.add(scrollPane, gbc_scrollPane);
		
		itemsTable = new JTable();
		scrollPane.setViewportView(itemsTable);
		
		itemsTable.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            String barcode = itemsTable.getValueAt(table.getSelectedRow(), 0).toString();
		            try {
		            	Item i = itemsCtrl.getItem(barcode);
		            	editItemGUI = new EditItemGUI(i);
		            	editItemGUI.setVisible(true);
		            } catch(Exception e) {
		            	JOptionPane.showMessageDialog(instance, "Something went wrong ..", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});
		
		init();
	}
	
	private void init() {
		itemsCtrl = new ItemController();
		itemTableModel = new ItemTableModel();
		itemsTable.setModel(itemTableModel);
		
		TableRowSorter<ItemTableModel> sorter = new TableRowSorter<ItemTableModel>(itemTableModel);
		itemsTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		displayItems();
	}
	
	private void searchForItem() {
		if(txtItemName.getText().equals("")) {
			displayItems();
		} else if(!txtItemName.equals(null)) {
			String itemName = txtItemName.getText();
			try {
				ArrayList<Item> itemsFound = new ArrayList<Item>();
				Item item = itemsCtrl.getItemByName(Helper.uppercaseFirstCharacter(itemName));
				itemsFound.add(item);
				System.out.println(item.getBarcode());
				itemTableModel.setModelData(itemsFound);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(instance, "Item could not be found!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void newItem() {
		newItemGUI = new NewItemGUI();
		newItemGUI.setVisible(true);
	}
	
	public void displayItems() {
		itemTableModel.setModelData(itemsCtrl.getItems());
	}
}
