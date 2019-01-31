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

public class OrdersGUI extends JPanel {
	private static OrdersGUI instance;
	private NewOrderGUI newOrderGUI;
	private OrderController orderCtrl;
	private OrderTableModel orderTableModel;
	private JTable ordersTable;
	
	public static OrdersGUI getInstance() {
		if(instance == null)
			instance = new OrdersGUI();
		return instance;
	}
	
	/**
	 * Create the panel.
	 */
	private OrdersGUI() {
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
		
		JButton btnCreateOrder = new JButton("Create order");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newOrder();
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
		
		init();
	}
	
	private void init() {
		orderCtrl = new OrderController();
		orderTableModel = new OrderTableModel();
		ordersTable.setModel(orderTableModel);
		
		TableRowSorter<OrderTableModel> sorter = new TableRowSorter<OrderTableModel>(orderTableModel);
		ordersTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		displayOrders();
	}
	
	private void newOrder() {
		newOrderGUI = new NewOrderGUI();
		newOrderGUI.setVisible(true);
	}
	
	public void displayOrders() {
		List<Order> orders = new ArrayList<Order>(orderCtrl.getOrders().values());
		orderTableModel.setModelData(orders);
	}
}
