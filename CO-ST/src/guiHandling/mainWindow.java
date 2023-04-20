package guiHandling;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import costPackage.sortedExpense;
public class mainWindow implements ActionListener {
	costYear newYear = new costYear();


	DefaultListModel<Object> listed = new DefaultListModel<Object>();
	DefaultListModel<Object> listedE = new DefaultListModel<Object>();
	DefaultListModel<Object> sortedList = new DefaultListModel<Object>();
	JList<Object> displayedList = new JList<Object>(listed);
	JList<Object> expenseDisplay = new JList<Object>((listedE));
	JList<Object> sortedDisplay = new JList<Object>(sortedList);
	JComboBox comboBox = new JComboBox();
	JLabel balTextValue;
	JLabel balTextValue_1;
	JLabel incomeTextValue;
	JLabel incomingIncomeTextValue;
	JLabel savingsValueText;
	JLabel ExpenseTextValue;
	private JFrame frmCostFinanceProgram;
	private static final Pattern DOUBLE_PATTERN = Pattern.compile(
		    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
		    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
		    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
		    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
	
	NumberFormat format = NumberFormat.getInstance();
	private JLabel currentSavingsValue;
  
	
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
		
		JMenuItem newMenuItemFiles = new JMenuItem("New");
		newMenuItemFiles.setHorizontalAlignment(SwingConstants.CENTER);
		newMenuItemFiles.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fileMenu.add(newMenuItemFiles);
		newMenuItemFiles.addActionListener(this);
		
		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fileMenu.add(saveMenu);
		saveMenu.addActionListener(this);
		
		JMenuItem loadMenu = new JMenuItem("Load");
		loadMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fileMenu.add(loadMenu);
		loadMenu.addActionListener(this);
		
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
		displayedList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
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
		Summary.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));
		
		JLabel balText = new JLabel("Balance:");
		balText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary.add(balText);
		
		balTextValue = new JLabel("$0.00");
		balTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary.add(balTextValue);
		
		JLabel lblNewLabel = new JLabel("  ");
		Summary.add(lblNewLabel);
		
		JLabel incomeText = new JLabel("Monthly Income:");
		incomeText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary.add(incomeText);
		
		incomeTextValue = new JLabel("$0.00");
		incomeTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary.add(incomeTextValue);
		
		JLabel lblNewLabel_1 = new JLabel("  ");
		Summary.add(lblNewLabel_1);
		
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
		
		JLabel savingsText = new JLabel("Savings Goal:");
		savingsText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		savingsText.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(savingsText);
		
		savingsValueText = new JLabel("$0.00");
		savingsValueText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(savingsValueText);
		panel_1.add(panel_2_1);
		
		JLabel currentSavingsText = new JLabel("Current Savings:");
		currentSavingsText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(currentSavingsText);
		
		currentSavingsValue = new JLabel("$0.00");
		currentSavingsValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(currentSavingsValue);
		
		JButton newSavingsButton = new JButton("Set Savings Goal");
		sl_panel_1.putConstraint(SpringLayout.WEST, newSavingsButton, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, newSavingsButton, -10, SpringLayout.SOUTH, panel_1);
		newSavingsButton.setPreferredSize(new Dimension(120, 40));
		newSavingsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(newSavingsButton);
		
		JButton refreshSavings = new JButton("Refresh");
		refreshSavings.addActionListener(this);
		sl_panel_1.putConstraint(SpringLayout.NORTH, refreshSavings, 0, SpringLayout.NORTH, newSavingsButton);
		sl_panel_1.putConstraint(SpringLayout.EAST, refreshSavings, -10, SpringLayout.EAST, panel_1);
		refreshSavings.setPreferredSize(new Dimension(120, 40));
		refreshSavings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(refreshSavings);
		newSavingsButton.addActionListener(this);
		
		JPanel Expenses = new JPanel();
		tabbedPane.addTab("Expenses", null, Expenses, null);
		Expenses.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setPreferredSize(new Dimension(400, 300));
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expenses.add(scrollPane_1, BorderLayout.EAST);
		
		
		expenseDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		expenseDisplay.setLayoutOrientation(JList.VERTICAL_WRAP);
		expenseDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1.setViewportView(expenseDisplay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 50));
		panel_3.setMinimumSize(new Dimension(100, 50));
		panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane_1.setColumnHeaderView(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton newExpenseButton = new JButton("New Expense");
		newExpenseButton.setPreferredSize(new Dimension(120, 40));
		newExpenseButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(newExpenseButton);
		newExpenseButton.addActionListener(this);
		
		JButton delExpenseButton = new JButton("Delete Expense");
		delExpenseButton.setPreferredSize(new Dimension(120, 40));
		delExpenseButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(delExpenseButton);
		delExpenseButton.addActionListener(this);
		
		JButton refreshExpenseButton = new JButton("Refresh Expense");
		refreshExpenseButton.setPreferredSize(new Dimension(120, 40));
		refreshExpenseButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(refreshExpenseButton);
		refreshExpenseButton.addActionListener(this);
		
		JPanel Summary_1 = new JPanel();
		Expenses.add(Summary_1, BorderLayout.SOUTH);
		Summary_1.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));
		
		JLabel balText_1 = new JLabel("Balance:");
		balText_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary_1.add(balText_1);
		
		balTextValue_1 = new JLabel("$0.00");
		balTextValue_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary_1.add(balTextValue_1);
		
		JLabel spacer3 = new JLabel("  ");
		Summary_1.add(spacer3);
		
		JLabel expenseText = new JLabel("Monthly Expenses:");
		expenseText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary_1.add(expenseText);
		
		ExpenseTextValue = new JLabel("$0.00");
		ExpenseTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary_1.add(ExpenseTextValue);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setPreferredSize(new Dimension(400, 300));
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expenses.add(scrollPane_1_1, BorderLayout.WEST);
		
		
		sortedDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sortedDisplay.setLayoutOrientation(JList.VERTICAL_WRAP);
		sortedDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1_1.setViewportView(sortedDisplay);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setPreferredSize(new Dimension(10, 50));
		panel_3_1.setMinimumSize(new Dimension(100, 50));
		panel_3_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane_1_1.setColumnHeaderView(panel_3_1);
		panel_3_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton sortExpensesButton = new JButton("Sort");
		sortExpensesButton.setPreferredSize(new Dimension(120, 40));
		sortExpensesButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3_1.add(sortExpensesButton);
		sortExpensesButton.addActionListener(this);
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"housing", "utilities", "groceries", "personal", "entertainment", "other"}));
		panel_3_1.add(comboBox);
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
		case "New Expense":
			addExpense();
			break;
		case "Refresh Expense":
			refreshExpense();
			break;
		case "Delete Expense":
			deleteExpense();
			break;
		case "Set Savings Goal":
			setSavings();
			break;
		case "Refresh":
			refreshSavings();
			break;
		case "New":
			newYear();
			break;
		case "Save":
			save();
			break;
		case "Load":
			load();
			break;
		case "Sort":
			sortExpense();
			break;
		}
		
		
	}
	
	public void newYear() {
		newYear = new costYear();
		refreshIncome();
		refreshBalance();
		refreshExpense();
		refreshSavings();
	}
	
	
	public void sortExpense() {
		String category = (String) comboBox.getSelectedItem();
		sortedList.clear();
		ArrayList<String> sorted = newYear.sortExpense(category);
		sortedList.ensureCapacity(sorted.size());
		sortedList.addAll(sorted);
		
	}
	
	public void load() {
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load File");   
		 
		int userSelection = fileChooser.showOpenDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    String fileLocation = fileToSave.getAbsolutePath();
		    newYear.Load(fileLocation);
	}
	}
	
	public void save() {
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save File");   
		 
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    String fileLocation = fileToSave.getAbsolutePath();
		    newYear.Save(fileLocation);
		}
	}
	
	public void refreshIncome() {
		listed.removeAllElements();
		listed.ensureCapacity(newYear.returnIncomeLength());
		listed.addAll(newYear.returnIncomeDisplayed());
		refreshBalance();
	}
	
	public void refreshExpense() {
		listedE.removeAllElements();
		listedE.ensureCapacity(newYear.returnExpenseLength());
		listedE.addAll(newYear.returnExpenseDisplayed());
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
	
	public String addExpenseName() {
		String newName = (String)JOptionPane.showInputDialog("Please enter the name of the expense.");
		return newName;
	}
	
	public Double addExpenseValue() {
		String newValue = JOptionPane.showInputDialog("What's the cost value of the expense?");
		if (newValue == null) return (double) 0;
		if (isDouble(newValue)) {
			return Double.parseDouble(newValue);
		} else {
			return addIncomeValue();
		}
	}
	
	public String addExpenseCategory() {
		String[] options = {"housing", "utilities", "groceries", "personal", "entertainment", "other"};
		int newCategory = JOptionPane.showOptionDialog(null, "What category is the expense?", "Expense", 0, 3, null, options, options[0]);
		
		
			return options[newCategory];
		
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
	
	public void addExpense() {
		String newName = addExpenseName();
		if (newName.length() == 0) return;
		Double newValue = addExpenseValue();
		String newCategory = addExpenseCategory();
		newYear.makeExpense(newName, newValue, newCategory);
		refreshExpense();
	}
	
	
	
	public void deleteIncome() {
		if (listed.size() != 0) {
			System.out.println("Delete");
			newYear.removeIncome(displayedList.getSelectedIndex());
			refreshIncome();
		}
	}
	
	public void deleteExpense() {
		if (listedE.size() != 0) {
			System.out.println("Delete");
			newYear.removeExpense(expenseDisplay.getSelectedIndex());
			refreshExpense();
		}
	}
	
	public void refreshBalance() {
		balTextValue.setText(newYear.getSetBalance());
		incomingIncomeTextValue.setText(newYear.calcIncomingIncome());
		balTextValue_1.setText(newYear.getSetBalance());
		ExpenseTextValue.setText("$" + newYear.returnExpenseTotal());
		refreshSavings();
		
	}
	
	public void refreshSavings() {
		savingsValueText.setText("$" + newYear.getSetSavings());
		currentSavingsValue.setText("$" + newYear.savingSetter());
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
