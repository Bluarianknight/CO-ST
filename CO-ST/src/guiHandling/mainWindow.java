package guiHandling;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import MainPackage.costYear;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.ComponentOrientation;

public class mainWindow implements ActionListener {
	costYear newYear = new costYear();


	DefaultListModel<Object> listed = new DefaultListModel<Object>();
	JList<Object> displayedList = new JList<Object>(listed);
	JLabel balTextValue;
	JLabel incomeTextValue;
	JLabel incomingIncomeTextValue;
	JLabel savingsValueText;
	private JFrame frmCostFinanceProgram;
	private static final Pattern DOUBLE_PATTERN = Pattern.compile(
		    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
		    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
		    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
		    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
	
	NumberFormat format = NumberFormat.getInstance();
  
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frmCostFinanceProgram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCostFinanceProgram = new JFrame();
		frmCostFinanceProgram.setTitle("CO-ST Finance Program");
		frmCostFinanceProgram.setResizable(false);
		frmCostFinanceProgram.setBounds(100, 100, 450, 300);
		frmCostFinanceProgram.setSize(1090, 638);
		frmCostFinanceProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(1, 0, 0, 0));
		menuBar.setBackground(SystemColor.menu);
		frmCostFinanceProgram.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("Files");
		fileMenu.setBackground(SystemColor.control);
		menuBar.add(fileMenu);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmCostFinanceProgram.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Income = new JPanel();
		tabbedPane.addTab("Income", null, Income, null);
		Income.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 300));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Income.add(scrollPane, BorderLayout.EAST);
		displayedList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		displayedList.setLayoutOrientation(JList.VERTICAL_WRAP);
		displayedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(displayedList);
		
		JPanel panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setPreferredSize(new Dimension(10, 50));
		panel.setMinimumSize(new Dimension(100, 50));
		scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton backButton = new JButton("New Income");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		backButton.addActionListener(this);
		backButton.setPreferredSize(new Dimension(120, 40));
		panel.add(backButton);
		
		JButton delButton = new JButton("Delete Income");
		delButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		delButton.setPreferredSize(new Dimension(120, 40));
		panel.add(delButton);
		delButton.addActionListener(this);
		
		JButton refreshButton = new JButton("Refresh Income");
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refreshButton.setPreferredSize(new Dimension(120, 40));
		refreshButton.addActionListener(this);
		panel.add(refreshButton);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		Income.add(tabbedPane_1, BorderLayout.NORTH);
		
		JPanel Summary = new JPanel();
		Income.add(Summary, BorderLayout.SOUTH);
		Summary.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel balText = new JLabel("Balance:");
		balText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary.add(balText);
		
		balTextValue = new JLabel("$0.00");
		balTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary.add(balTextValue);
		
		JLabel incomeText = new JLabel("Monthly Income:");
		incomeText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary.add(incomeText);
		
		incomeTextValue = new JLabel("$0.00");
		incomeTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary.add(incomeTextValue);
		
		JLabel incomingIncomeText = new JLabel("Income to Arrive:");
		incomingIncomeText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary.add(incomingIncomeText);
		
		incomingIncomeTextValue = new JLabel("$0.00");
		incomingIncomeTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary.add(incomingIncomeTextValue);
		
		JPanel OverviewPanel = new JPanel();
		OverviewPanel.setBackground(SystemColor.control);
		Income.add(OverviewPanel, BorderLayout.CENTER);
		SpringLayout sl_OverviewPanel = new SpringLayout();
		OverviewPanel.setLayout(sl_OverviewPanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		sl_OverviewPanel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, OverviewPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, OverviewPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.SOUTH, panel_1, 250, SpringLayout.NORTH, OverviewPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.EAST, panel_1, 311, SpringLayout.WEST, OverviewPanel);
		OverviewPanel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel SavingTitle = new JLabel("Savings");
		sl_panel_1.putConstraint(SpringLayout.NORTH, SavingTitle, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, SavingTitle, 61, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, SavingTitle, 40, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, SavingTitle, 214, SpringLayout.WEST, panel_1);
		SavingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		SavingTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(SavingTitle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 3, SpringLayout.SOUTH, SavingTitle);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 33, SpringLayout.SOUTH, SavingTitle);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 264, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(SystemColor.inactiveCaptionBorder);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2_1, 6, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2_1, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2_1, 36, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2_1, 0, SpringLayout.EAST, panel_2);
		
		JLabel savingsText = new JLabel("Savings:");
		savingsText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		savingsText.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(savingsText);
		
		savingsValueText = new JLabel("$0.00");
		savingsValueText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(savingsValueText);
		panel_1.add(panel_2_1);
		
		JButton newSavingsButton = new JButton("Set Savings Goal");
		sl_panel_1.putConstraint(SpringLayout.WEST, newSavingsButton, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, newSavingsButton, -10, SpringLayout.SOUTH, panel_1);
		newSavingsButton.setPreferredSize(new Dimension(120, 40));
		newSavingsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(newSavingsButton);
		newSavingsButton.addActionListener(this);
		
		JPanel Expenses = new JPanel();
		tabbedPane.addTab("Expenses", null, Expenses, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) 
		{
		case "Refresh Income":
			refreshIncome();
			break;
		case "New Income":
			addIncome();
			break;
		case "Delete Income":
			deleteIncome();
			break;
		case "Set Savings Goal":
			setSavings();
		}
		
	}
	
	public void refreshIncome() {
		listed.removeAllElements();
		listed.ensureCapacity(newYear.returnIncomeLength());
		listed.addAll(newYear.returnIncomeDisplayed());
		refreshBalance();
	}
	
	public String addIncomeName() {
		String newName = (String)JOptionPane.showInputDialog("Please enter the name of the income.");
		return newName;
	}
	
	public Double addIncomeValue() {
		String newValue = JOptionPane.showInputDialog("What's the value of the income?");
		if (newValue == null) return (double) 0;
		if (isDouble(newValue)) {
			return Double.parseDouble(newValue);
		} else {
			return addIncomeValue();
		}
	}
	
	public Double addIncomeLap() {
		String newLap = JOptionPane.showInputDialog("How many days are between your pay periods?");
		if (newLap == null) return (double) 0;
		if (isDouble(newLap)) {
			return Double.parseDouble(newLap);
		} else {
			return addIncomeLap();
		}
	}
	

	public static boolean isDouble(String s)
	{
	    return DOUBLE_PATTERN.matcher(s).matches();
	}
	
	public void addIncome() {
		String newName = addIncomeName();
		if (newName.length() == 0) return;
		Double newValue = addIncomeValue();
		Double newLap = addIncomeLap();
		newYear.makeIncome(newName, newValue, newLap);
		refreshIncome();
		
				
	}
	
	public void deleteIncome() {
		if (listed.size() != 0) {
			System.out.println("Delete");
			newYear.removeIncome(displayedList.getSelectedIndex());
			refreshIncome();
		}
	}
	
	public void refreshBalance() {
		balTextValue.setText(newYear.getBalance());
		incomingIncomeTextValue.setText(newYear.calcIncomingIncome());
		
	}
	
	public void refreshSavings() {
		savingsValueText.setText("$" + newYear.getSavings());
	}
	
	public void setSavings() {
		String newSavings = JOptionPane.showInputDialog("What's your current goal?");
		if( newSavings.length() == 0 ) return;
		if (isDouble(newSavings)) {
			newYear.setSavings(Double.parseDouble(newSavings));
			refreshSavings();
		} else {
			setSavings();
	}
	}
}
