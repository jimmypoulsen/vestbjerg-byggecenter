package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import Controllers.*;
import Models.Branch;
import Models.Company;
import Models.Customer;
import Models.Employee;
import Models.Item;
import Models.Location;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainMenuGUI extends JFrame {
	private EmployeeController eCtrl;
    private BranchController bCtrl;
    private LocationController lCtrl;
    private ItemController iCtrl;
    private SessionsController sCtrl;
	private JPanel contentPane;
	private OrdersGUI ordersGUI;
	private SalesGUI salesGUI;
	private ItemsGUI itemsGUI;
	private EmployeesGUI employeesGUI;
	private LoginGUI loginGUI;

	/**
	 * Create the frame.
	 */
	public MainMenuGUI() {
		ordersGUI = OrdersGUI.getInstance();
		salesGUI = SalesGUI.getInstance();
		itemsGUI = ItemsGUI.getInstance();
		employeesGUI = EmployeesGUI.getInstance();
		loginGUI = LoginGUI.getInstance();
		SessionsController sessionsCtrl = new SessionsController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out (" + sessionsCtrl.getCurrentLoggedInEmployee().getFirstName() + ")");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: handle log out
				performLogOut();
			}
		});
		mnFile.add(mntmLogOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		tabbedPane.addTab("Orders", null, ordersGUI, null);
		tabbedPane.addTab("Sales", null, salesGUI, null);
		tabbedPane.addTab("Items", null, itemsGUI, null);
		tabbedPane.addTab("Employees", null, employeesGUI, null);
		GridBagLayout gbl_ordersGUI = new GridBagLayout();
		gbl_ordersGUI.columnWidths = new int[]{419, 0};
		gbl_ordersGUI.rowHeights = new int[]{26, 0};
		gbl_ordersGUI.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_ordersGUI.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		ordersGUI.setLayout(gbl_ordersGUI);
		
		init();
	}
	
	private void init() {
		eCtrl = new EmployeeController();
		bCtrl = new BranchController();
		lCtrl = new LocationController();
		iCtrl = new ItemController();
		sCtrl = new SessionsController();
	}
	
	private void performLogOut() {
		sCtrl.logoutEmployee();
		this.setVisible(false);
		loginGUI.txtEmployeeNo.setText("");
		loginGUI.pwdEmployeePassword.setText("");
		loginGUI.setVisible(true);
	}
	
	private void exit() {
		System.exit(0);
	}
}
