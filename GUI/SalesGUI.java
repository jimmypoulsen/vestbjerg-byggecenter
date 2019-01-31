package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

import Controllers.*;
import Models.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
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

public class SalesGUI extends JPanel {
	private static SalesGUI instance;
	private NewSaleGUI newSalesGUI;
	private SaleController salesCtrl;
	private SaleTableModel saleTableModel;
	private JTable ordersTable;
	
	public static SalesGUI getInstance() {
		if(instance == null)
			instance = new SalesGUI();
		return instance;
	}
	
	/**
	 * Create the panel.
	 */
	private SalesGUI() {
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
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnCreateOrder = new JButton("Create sale");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newSale();
			}
		});
		GridBagConstraints gbc_btnCreateOrder = new GridBagConstraints();
		gbc_btnCreateOrder.gridwidth = 4;
		gbc_btnCreateOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateOrder.gridx = 0;
		gbc_btnCreateOrder.gridy = 1;
		panel.add(btnCreateOrder, gbc_btnCreateOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(350, 125));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);
		
		ordersTable = new JTable();
		scrollPane.setViewportView(ordersTable);
		
		addTestData();
		init();
	}
	
	private void init() {
		salesCtrl = new SaleController();
		saleTableModel = new SaleTableModel();
		ordersTable.setModel(saleTableModel);
		
		TableRowSorter<SaleTableModel> sorter = new TableRowSorter<SaleTableModel>(saleTableModel);
		ordersTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		displaySales();
	}
	
	private void newSale() {
		newSalesGUI = new NewSaleGUI();
		newSalesGUI.setVisible(true);
	}
	
	public void displaySales() {
		List<Sale> sales = new ArrayList<Sale>(salesCtrl.getSales().values());
		saleTableModel.setModelData(sales);
	}
	
	private void addTestData() {
		SaleController salesCtrl = new SaleController();
		ItemController itemCtrl = new ItemController();
		
		Sale s = salesCtrl.newSale();
		s.addSalesLine(new SalesLine(itemCtrl.getItem("1234"), 1));
		s.addSalesLine(new SalesLine(itemCtrl.getItem("123456"), 1));
		salesCtrl.createSale(s, PaymentType.CASH);
		
		Sale s1 = salesCtrl.newSale();
		s1.addSalesLine(new SalesLine(itemCtrl.getItem("12345678"), 1));
		s1.addSalesLine(new SalesLine(itemCtrl.getItem("123456"), 3));
		salesCtrl.createSale(s1, PaymentType.CREDITCARD);
	}
}
