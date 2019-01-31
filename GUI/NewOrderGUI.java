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

public class NewOrderGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCustomerNo;
	private JTextField txtItemQuantity;
	private JLabel lblCustomerNo;
	private JLabel lblItemBarcode;
	private JTextField txtItemBarcode;
	private JLabel lblItemQuantity;
	private JButton btnAddToOrder;
	private CustomerController customerCtrl;
	private OrderController orderCtrl;
	private ItemController itemCtrl;
	private JScrollPane scrollPane;
	private JTable table;
	private OrderLineTableModel orderLineTableModel;
	private JButton okButton;
	private JTextPane txtpnTotal;
	private JTextPane txtpnTotalValue;

	/**
	 * Create the dialog.
	 */
	public NewOrderGUI() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				updateOrderTotal();
			}
		}, 0, 500);
		
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
		
		lblCustomerNo = new JLabel("Customer No");
		lblCustomerNo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCustomerNo = new GridBagConstraints();
		gbc_lblCustomerNo.anchor = GridBagConstraints.EAST;
		gbc_lblCustomerNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerNo.gridx = 0;
		gbc_lblCustomerNo.gridy = 0;
		contentPanel.add(lblCustomerNo, gbc_lblCustomerNo);
		
		txtCustomerNo = new JTextField();
		GridBagConstraints gbc_txtCustomerNo = new GridBagConstraints();
		gbc_txtCustomerNo.insets = new Insets(0, 0, 5, 0);
		gbc_txtCustomerNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerNo.gridx = 1;
		gbc_txtCustomerNo.gridy = 0;
		contentPanel.add(txtCustomerNo, gbc_txtCustomerNo);
		txtCustomerNo.setColumns(10);
		
		lblItemBarcode = new JLabel("Barcode");
		lblItemBarcode.setVisible(false);
		GridBagConstraints gbc_lblItemBarcode = new GridBagConstraints();
		gbc_lblItemBarcode.anchor = GridBagConstraints.EAST;
		gbc_lblItemBarcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemBarcode.gridx = 0;
		gbc_lblItemBarcode.gridy = 1;
		contentPanel.add(lblItemBarcode, gbc_lblItemBarcode);
		
		txtItemBarcode = new JTextField();
		txtItemBarcode.setVisible(false);
		txtItemBarcode.setToolTipText("Enter an item's barcode");
		GridBagConstraints gbc_txtItemBarcode = new GridBagConstraints();
		gbc_txtItemBarcode.insets = new Insets(0, 0, 5, 0);
		gbc_txtItemBarcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItemBarcode.gridx = 1;
		gbc_txtItemBarcode.gridy = 1;
		contentPanel.add(txtItemBarcode, gbc_txtItemBarcode);
		txtItemBarcode.setColumns(10);
		
		lblItemQuantity = new JLabel("Quantity");
		lblItemQuantity.setVisible(false);
		GridBagConstraints gbc_lblItemQuantity = new GridBagConstraints();
		gbc_lblItemQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblItemQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemQuantity.gridx = 0;
		gbc_lblItemQuantity.gridy = 2;
		contentPanel.add(lblItemQuantity, gbc_lblItemQuantity);
		
		txtItemQuantity = new JTextField();
		txtItemQuantity.setVisible(false);
		txtItemQuantity.setToolTipText("Enter quantity of item");
		GridBagConstraints gbc_txtItemQuantity = new GridBagConstraints();
		gbc_txtItemQuantity.insets = new Insets(0, 0, 5, 0);
		gbc_txtItemQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItemQuantity.gridx = 1;
		gbc_txtItemQuantity.gridy = 2;
		contentPanel.add(txtItemQuantity, gbc_txtItemQuantity);
		txtItemQuantity.setColumns(10);
		
		btnAddToOrder = new JButton("Add to order");
		btnAddToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addOrderLine();
			}
		});
		btnAddToOrder.setVisible(false);
		GridBagConstraints gbc_btnAddToOrder = new GridBagConstraints();
		gbc_btnAddToOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddToOrder.gridx = 1;
		gbc_btnAddToOrder.gridy = 3;
		contentPanel.add(btnAddToOrder, gbc_btnAddToOrder);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
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
				cancelOrder();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		okButton = new JButton("OK ...");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newOrder();
			}
		});
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		init();
	}
	
	private void init() {
		customerCtrl = new CustomerController();
		orderCtrl = new OrderController();
		itemCtrl = new ItemController();
		orderLineTableModel = new OrderLineTableModel();
		table.setModel(orderLineTableModel);
	}
	
	private void newOrder() {
		int customerNo = Integer.parseInt(txtCustomerNo.getText());
		Customer c = customerCtrl.getCustomer(customerNo);
		if(c == null) {
			JOptionPane.showMessageDialog(this, "Customer could not be found .. Try again!", "Error", JOptionPane.ERROR_MESSAGE);
			txtCustomerNo.setText("");
		} else {
			orderCtrl.newOrder(c);
			lblCustomerNo.setText("Customer: " + c.getFirstName());
			txtCustomerNo.setVisible(false);
			showOrderLineFields();
			okButton.setText("Finish order");
			
			for(ActionListener aL : okButton.getActionListeners()) {
				okButton.removeActionListener(aL);
			}
			
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createOrder();
				}
			});
		}
		
		Item i = itemCtrl.getItem("12345632132");
	}
	
	private void createOrder() {
		if(orderCtrl.getCurrentOrderLines().size() > 0) {
			Object options[] = {"Invoice", "Creditcard", "Cash"};
			int paymentTypeOption = JOptionPane.showOptionDialog(this, "How will the customer pay?", "Select payment type", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			PaymentType pt = PaymentType.INVOICE;
			switch(paymentTypeOption) {
				case 1: {
					pt = PaymentType.CREDITCARD;
					break;
				}
				case 2: {
					pt = PaymentType.CASH;
					break;
				}
			}
			if(orderCtrl.createOrder(pt) != null) {
				JOptionPane.showMessageDialog(this, "A new order was created!", "Order created", JOptionPane.INFORMATION_MESSAGE);
				OrdersGUI.getInstance().displayOrders();
			} else
				JOptionPane.showMessageDialog(this, "An error occurred .. Try again!", "Error", JOptionPane.ERROR_MESSAGE);
			
			this.setVisible(false);
		} else
			JOptionPane.showMessageDialog(this, "You need to add at least one order line, in order to create an order.", "No order lines", JOptionPane.ERROR_MESSAGE);
	}
	
	private void addOrderLine() {
		Item i = null;
		i = itemCtrl.getItem(txtItemBarcode.getText());
		if(i == null) {
			JOptionPane.showMessageDialog(this, "Item could not be found .. Try again!", "Error", JOptionPane.ERROR_MESSAGE);
			txtItemBarcode.setText("");
			txtItemQuantity.setText("");
		} else {
			try {
				orderCtrl.createOrderLine(i, Integer.parseInt(txtItemQuantity.getText()));
			} catch(InsufficientStockException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			txtItemBarcode.setText("");
			txtItemQuantity.setText("");
		}
		
		displayOrderLines();
	}
	
	private void cancelOrder() {
		for(OrderLine oL : orderCtrl.getCurrentOrderLines())
			oL.getItem().setStock(oL.getItem().getStock() + oL.getQuantity());
		this.setVisible(false);
	}
	
	private void updateOrderTotal() {
		if(orderCtrl.getCurrentOrder() != null) {
			double total = 0;
			Iterator<OrderLine> orderLineIterator = orderCtrl.getCurrentOrderLines().iterator();
			while(orderLineIterator.hasNext()) {
				total += orderLineIterator.next().getSubtotal();
			}
			txtpnTotalValue.setText(total + " kr.");
		}
	}
	
	private void displayOrderLines() {
		List<OrderLine> orderLines = new ArrayList<OrderLine>(orderCtrl.getCurrentOrderLines());
		orderLineTableModel.setModelData(orderLines);
		txtpnTotalValue.setText("" + orderCtrl.getCurrentOrder().getTotal() + " kr.");
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
}
