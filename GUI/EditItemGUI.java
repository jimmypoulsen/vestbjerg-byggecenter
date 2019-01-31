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

public class EditItemGUI extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private ItemController itemsCtrl;
	private Item item;
	private JButton btnUpdate;
	private JLabel lblName;
	private JLabel lblPrice;
	private JLabel lblStock;
	private JLabel lblMinStock;
	private JLabel lblMaxStock;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtStock;
	private JTextField txtMinStock;
	private JTextField txtMaxStock;
	private JButton btnCancel;

	/**
	 * Create the dialog.
	 */
	public EditItemGUI(Item i) {
		item = i;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{116, 83, 0};
		gbl_contentPanel.rowHeights = new int[]{26, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		contentPanel.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		contentPanel.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.EAST;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 1;
		contentPanel.add(lblPrice, gbc_lblPrice);
		
		txtPrice = new JTextField();
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrice.gridx = 1;
		gbc_txtPrice.gridy = 1;
		contentPanel.add(txtPrice, gbc_txtPrice);
		txtPrice.setColumns(10);
		
		lblStock = new JLabel("Stock");
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.anchor = GridBagConstraints.EAST;
		gbc_lblStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblStock.gridx = 0;
		gbc_lblStock.gridy = 2;
		contentPanel.add(lblStock, gbc_lblStock);
		
		txtStock = new JTextField();
		GridBagConstraints gbc_txtStock = new GridBagConstraints();
		gbc_txtStock.insets = new Insets(0, 0, 5, 0);
		gbc_txtStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStock.gridx = 1;
		gbc_txtStock.gridy = 2;
		contentPanel.add(txtStock, gbc_txtStock);
		txtStock.setColumns(10);
		
		lblMinStock = new JLabel("Min. stock");
		GridBagConstraints gbc_lblMinStock = new GridBagConstraints();
		gbc_lblMinStock.anchor = GridBagConstraints.EAST;
		gbc_lblMinStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinStock.gridx = 0;
		gbc_lblMinStock.gridy = 3;
		contentPanel.add(lblMinStock, gbc_lblMinStock);
		
		txtMinStock = new JTextField();
		GridBagConstraints gbc_txtMinStock = new GridBagConstraints();
		gbc_txtMinStock.insets = new Insets(0, 0, 5, 0);
		gbc_txtMinStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMinStock.gridx = 1;
		gbc_txtMinStock.gridy = 3;
		contentPanel.add(txtMinStock, gbc_txtMinStock);
		txtMinStock.setColumns(10);
		
		lblMaxStock = new JLabel("Max. stock");
		GridBagConstraints gbc_lblMaxStock = new GridBagConstraints();
		gbc_lblMaxStock.anchor = GridBagConstraints.EAST;
		gbc_lblMaxStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxStock.gridx = 0;
		gbc_lblMaxStock.gridy = 4;
		contentPanel.add(lblMaxStock, gbc_lblMaxStock);
		
		txtMaxStock = new JTextField();
		GridBagConstraints gbc_txtMaxStock = new GridBagConstraints();
		gbc_txtMaxStock.insets = new Insets(0, 0, 5, 0);
		gbc_txtMaxStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaxStock.gridx = 1;
		gbc_txtMaxStock.gridy = 4;
		contentPanel.add(txtMaxStock, gbc_txtMaxStock);
		txtMaxStock.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		buttonPane.add(btnCancel);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateItem();
			}
		});
		buttonPane.add(btnUpdate);
		
		init();
	}
	
	private void init() {
		itemsCtrl = new ItemController();
		txtName.setText(item.getName());
		txtPrice.setText("" + item.getPrice());
		txtStock.setText("" + item.getStock());
		txtMinStock.setText("" + item.getMinStock());
		txtMaxStock.setText("" + item.getMaxStock());
	}
	
	private void updateItem() {
		if(!txtName.getText().equals(""))
			item.setName(txtName.getText());
		if(!txtPrice.getText().equals(""))
			item.setPrice(Double.parseDouble(txtPrice.getText()));
		if(!txtStock.getText().equals(""))
			item.setStock(Integer.parseInt(txtStock.getText()));
		if(!txtMinStock.getText().equals(""))
			item.setMinStock(Integer.parseInt(txtMinStock.getText()));
		if(!txtMaxStock.getText().equals(""))
			item.setMaxStock(Integer.parseInt(txtMaxStock.getText()));
		
		if(itemsCtrl.updateItem(item)) {
			ItemsGUI.getInstance().displayItems();
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(this, "Something went wrong ...", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void exit() {
		this.setVisible(false);
	}
}
