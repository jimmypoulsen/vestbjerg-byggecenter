package GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controllers.*;
import Models.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class NewSaleGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Order order;
	private JTextField txtItemQuantity;
	private JLabel lblItemBarcode;
	private JTextField txtItemBarcode;
	private JLabel lblItemQuantity;
	private JButton btnAddToOrder;
	private SaleController salesCtrl;
	private ItemController itemCtrl;
	private JScrollPane scrollPane;
	private JTable table;
	private SalesLineTableModel salesLineTableModel;
	private JButton btnCreateOrder;
	private JTextPane txtpnTotal;
	private JTextPane txtpnTotalValue;
	private Sale sale;

	/**
	 * Create the dialog.
	 */
	public NewSaleGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{116, 83, 0};
		gbl_contentPanel.rowHeights = new int[]{26, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		lblItemBarcode = new JLabel("Barcode");
		lblItemBarcode.setVisible(true);
		GridBagConstraints gbc_lblItemBarcode = new GridBagConstraints();
		gbc_lblItemBarcode.anchor = GridBagConstraints.EAST;
		gbc_lblItemBarcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemBarcode.gridx = 0;
		gbc_lblItemBarcode.gridy = 0;
		contentPanel.add(lblItemBarcode, gbc_lblItemBarcode);
		
		lblItemQuantity = new JLabel("Quantity");
		lblItemQuantity.setVisible(true);
		
		txtItemBarcode = new JTextField();
		txtItemBarcode.setVisible(true);
		txtItemBarcode.setToolTipText("Enter an item's barcode");
		GridBagConstraints gbc_txtItemBarcode = new GridBagConstraints();
		gbc_txtItemBarcode.insets = new Insets(0, 0, 5, 0);
		gbc_txtItemBarcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItemBarcode.gridx = 1;
		gbc_txtItemBarcode.gridy = 0;
		contentPanel.add(txtItemBarcode, gbc_txtItemBarcode);
		txtItemBarcode.setColumns(10);
		GridBagConstraints gbc_lblItemQuantity = new GridBagConstraints();
		gbc_lblItemQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblItemQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemQuantity.gridx = 0;
		gbc_lblItemQuantity.gridy = 1;
		contentPanel.add(lblItemQuantity, gbc_lblItemQuantity);
		
		txtItemQuantity = new JTextField();
		txtItemQuantity.setVisible(true);
		txtItemQuantity.setToolTipText("Enter quantity of item");
		GridBagConstraints gbc_txtItemQuantity = new GridBagConstraints();
		gbc_txtItemQuantity.insets = new Insets(0, 0, 5, 0);
		gbc_txtItemQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItemQuantity.gridx = 1;
		gbc_txtItemQuantity.gridy = 1;
		contentPanel.add(txtItemQuantity, gbc_txtItemQuantity);
		txtItemQuantity.setColumns(10);
		
		btnAddToOrder = new JButton("Add to sale");
		btnAddToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSalesLine();
			}
		});
		btnAddToOrder.setVisible(true);
		GridBagConstraints gbc_btnAddToOrder = new GridBagConstraints();
		gbc_btnAddToOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddToOrder.gridx = 1;
		gbc_btnAddToOrder.gridy = 2;
		contentPanel.add(btnAddToOrder, gbc_btnAddToOrder);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		txtpnTotal = new JTextPane();
		txtpnTotal.setBackground(UIManager.getColor("Button.background"));
		txtpnTotal.setText("Total:");
		txtpnTotal.setVisible(false);
		buttonPane.add(txtpnTotal);
		
		txtpnTotalValue = new JTextPane();
		txtpnTotalValue.setBackground(UIManager.getColor("Button.background"));
		txtpnTotalValue.setText("0 kr.");
		txtpnTotalValue.setVisible(false);
		buttonPane.add(txtpnTotalValue);


		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		btnCreateOrder = new JButton("Create sale");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSale();
			}
		});
		
		btnCreateOrder.setActionCommand("OK");
		buttonPane.add(btnCreateOrder);
		getRootPane().setDefaultButton(btnCreateOrder);
		
		init();
	}
	
	private void init() {
		salesCtrl = new SaleController();
		itemCtrl = new ItemController();
		salesLineTableModel = new SalesLineTableModel();
		table.setModel(salesLineTableModel);
		newSale();
	}
	
	private void newSale() {
		this.sale = salesCtrl.newSale();
		System.out.println(sale.getSalesId());
	}
	
	private void createSale() {
		if(sale.getSalesLines().size() > 0) {
			Object options[] = {"Creditcard", "Cash"};
			int paymentTypeOption = JOptionPane.showOptionDialog(null, "How will the customer pay?", "Select payment type", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			PaymentType pt = PaymentType.CREDITCARD;
			switch(paymentTypeOption) {
				case 1: {
					pt = PaymentType.CASH;
					break;
				}
			}
			if(salesCtrl.createSale(sale, pt) != null) {
				JOptionPane.showMessageDialog(null, "A new sale was created!", "Sale created", JOptionPane.INFORMATION_MESSAGE);
				SalesGUI.getInstance().displaySales();
				newSale();
				salesLineTableModel.setRowCount(0);
				displaySalesLines();
			} else
				JOptionPane.showMessageDialog(null, "An error occurred .. Try again!", "Error", JOptionPane.ERROR_MESSAGE);
			
			HashMap<Integer, Sale> sales = new HashMap<Integer, Sale>(salesCtrl.getSales());
			sales.values().forEach(sale -> {
				System.out.println(sale);
			});
			//this.setVisible(false); // this one?
		} else
			JOptionPane.showMessageDialog(null, "You need to add at least one sales line, in order to create a sale.", "No sales lines", JOptionPane.ERROR_MESSAGE);
	}
	
	private void addSalesLine() {
		Item i = null;
		try {
			i = itemCtrl.getItem(txtItemBarcode.getText());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Item could not be found .. Try again!", "Error", JOptionPane.ERROR_MESSAGE);
			txtItemBarcode.setText("");
			txtItemQuantity.setText("");
		}
		
		if(i != null) {
			sale.addSalesLine(new SalesLine(i, Integer.parseInt(txtItemQuantity.getText())));
			txtItemBarcode.setText("");
			txtItemQuantity.setText("");
			System.out.println(sale);
		}
		
		displaySalesLines();
	}
	
	private void updateOrderTotal() {
		if(order != null) {
			double total = 0;
			Iterator<OrderLine> orderLineIterator = order.getOrderLines().iterator();
			while(orderLineIterator.hasNext()) {
				total += orderLineIterator.next().getSubtotal();
			}
			txtpnTotalValue.setText("" + total + " kr.");	
		}
	}
	
	private void displaySalesLines() {
		List<SalesLine> salesLines = new ArrayList<SalesLine>(sale.getSalesLines());
		salesLineTableModel.setModelData(salesLines);
		// txtpnTotalValue.setText("" + order.getTotal() + " kr.");
	}
	
	private void showOrderLineFields() {
		lblItemBarcode.setVisible(true);
		txtItemBarcode.setVisible(true);
		lblItemQuantity.setVisible(true);
		txtItemQuantity.setVisible(true);
		btnAddToOrder.setVisible(true);
		txtpnTotal.setVisible(true);
		txtpnTotalValue.setVisible(true);
	}
	
	private void exit() {
		this.setVisible(false);
	}

}
