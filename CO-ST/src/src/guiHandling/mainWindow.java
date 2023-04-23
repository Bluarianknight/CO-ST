


/*
 * This class is the main GUI interface, and the main class, for this program.
 * 
 * It handles all of the graphic interface variables, and is a hefty beast of programming. All of the GUI and action variables are done through here, leaving any non-GUI related functions
 * to remain in mainClass.java.
 * 
 */



// Imports the required java libraries. 
package src.guiHandling;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import MainPackage.mainClass;

import javax.swing.*;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;


public class mainWindow implements ActionListener {
	// Creates the newYear mainClass() to handle the expenses and income, the brains.
	mainClass newYear = new mainClass();

	// These DefaultModelLists and JLists below are initialized previously to be referred to in functions.
	DefaultListModel<Object> listed = new DefaultListModel<Object>();
	DefaultListModel<Object> listedE = new DefaultListModel<Object>();
	DefaultListModel<Object> sortedList = new DefaultListModel<Object>();
	
	
	JList<Object> displayedList = new JList<Object>(listed);
	JList<Object> expenseDisplay = new JList<Object>((listedE));
	JList<Object> sortedDisplay = new JList<Object>(sortedList);
	
	Calendar now = Calendar.getInstance();
	
	
	
	@SuppressWarnings("rawtypes")
	
	
	// Used to select a category for the sorted expenses list.
	JComboBox categoryComboBox = new JComboBox();
	
	// These JLabels are modified in functions, therefore must be created in the class itself.
	JLabel balTextValue;
	JLabel balTextValue_1;
	JLabel incomeTextValue;
	JLabel savingsValueText;
	JLabel ExpenseTextValue;
	JLabel currentSavingsValue;
	  
	
	private JFrame frmCostFinanceProgram;
	
	// This pattern is used to detect if something is a double or not. 
	private static final Pattern DOUBLE_PATTERN = Pattern.compile(
		    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
		    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
		    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
		    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
	
	
	
	
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		
		// Initialized the main window frame.
		frmCostFinanceProgram = new JFrame();
		frmCostFinanceProgram.setTitle("CO-ST Finance Program");
		frmCostFinanceProgram.setResizable(false);
		frmCostFinanceProgram.setBounds(100, 100, 450, 300);
		frmCostFinanceProgram.setSize(1090, 638);
		frmCostFinanceProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		// The menu bar for the help and file menus.
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(1, 0, 0, 0));
		menuBar.setBackground(SystemColor.menu);
		frmCostFinanceProgram.setJMenuBar(menuBar);
		
		// The fileMenu contains the menuItems to save, load, and to make a new year instance.
		JMenu fileMenu = new JMenu("Files");
		fileMenu.setBackground(SystemColor.control);
		menuBar.add(fileMenu);
		
		// Used to make a new year instance.
		JMenuItem newMenuItemFiles = new JMenuItem("New");
		newMenuItemFiles.setHorizontalAlignment(SwingConstants.CENTER);
		newMenuItemFiles.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fileMenu.add(newMenuItemFiles);
		newMenuItemFiles.addActionListener(this);
		
		// Used to save the data to a file. 
		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fileMenu.add(saveMenu);
		saveMenu.addActionListener(this);
		
		// Used to load from a file. 
		JMenuItem loadMenu = new JMenuItem("Load");
		loadMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fileMenu.add(loadMenu);
		
		// Contains the Manual menuItem.
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		// Used to access the tutorial manual.
		JMenuItem helpMenuItem = new JMenuItem("Show Manual");
		helpMenu.add(helpMenuItem);
		loadMenu.addActionListener(this);
		helpMenuItem.addActionListener(this);
		
		// Allows the user to switch between the income and expense panels.
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmCostFinanceProgram.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		// Holds all of the panels for income.
		JPanel Income = new JPanel();
		tabbedPane.addTab("Income", null, Income, null);
		Income.setLayout(new BorderLayout(0, 0));
		
		// Displays the income list, alongside the controls for it.
		JScrollPane incomeListScrollPane = new JScrollPane();
		incomeListScrollPane.setPreferredSize(new Dimension(400, 300));
		incomeListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		incomeListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Income.add(incomeListScrollPane, BorderLayout.EAST);
		displayedList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		displayedList.setLayoutOrientation(JList.VERTICAL_WRAP);
		displayedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		incomeListScrollPane.setViewportView(displayedList);
		
		// Contains the controls for the income list, via the three buttons below.
		JPanel incomeButtonPanel = new JPanel();
		incomeButtonPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		incomeButtonPanel.setPreferredSize(new Dimension(10, 50));
		incomeButtonPanel.setMinimumSize(new Dimension(100, 50));
		incomeListScrollPane.setColumnHeaderView(incomeButtonPanel);
		incomeButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// Used to activate addIncome();
		JButton newIncomeButton = new JButton("New Income");
		newIncomeButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newIncomeButton.addActionListener(this);
		newIncomeButton.setPreferredSize(new Dimension(120, 40));
		incomeButtonPanel.add(newIncomeButton);
		
		// Used to activate deleteIncome();
		JButton delIncomeButton = new JButton("Delete Income");
		delIncomeButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		delIncomeButton.setPreferredSize(new Dimension(120, 40));
		incomeButtonPanel.add(delIncomeButton);
		delIncomeButton.addActionListener(this);
		
		// Used to activate refreshIncome();
		JButton refreshIncomeButton = new JButton("Refresh Income");
		refreshIncomeButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refreshIncomeButton.setPreferredSize(new Dimension(120, 40));
		refreshIncomeButton.addActionListener(this);
		incomeButtonPanel.add(refreshIncomeButton);
		
		// This panel contains information relating to the balance, monthly income, and the pending income arriving later in the month.
		JPanel Summary = new JPanel();
		Income.add(Summary, BorderLayout.SOUTH);
		Summary.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));
		
		// Set before balTextValue, to show what the balTextValue displays.
		JLabel balText = new JLabel("Balance:");
		balText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary.add(balText);
		
		// Displays the current balance of the user.
		balTextValue = new JLabel("$0.00");
		balTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary.add(balTextValue);
		
		// Space between balTextValue and incomeText
		JLabel lblNewLabel = new JLabel("  ");
		Summary.add(lblNewLabel);
		
		// Set before incomeTextValue to show what incomeTextValue displays.
		JLabel incomeText = new JLabel("Monthly Income:");
		incomeText.setFont(new Font("Tahoma", Font.BOLD, 16));
		Summary.add(incomeText);
		
		// Displays the current total income of the user. 
		incomeTextValue = new JLabel("$0.00");
		incomeTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Summary.add(incomeTextValue);
		
		// Spacing between incomeTextValue and incomingIncomeText
		JLabel lblNewLabel_1 = new JLabel("  ");
		Summary.add(lblNewLabel_1);
		
		// contains three panels, savingsPanel, timePanel, and blankPanel. 
		JPanel OverviewPanel = new JPanel();
		OverviewPanel.setBackground(SystemColor.control);
		Income.add(OverviewPanel, BorderLayout.CENTER);
		SpringLayout sl_OverviewPanel = new SpringLayout();
		OverviewPanel.setLayout(sl_OverviewPanel);
		
		// This panel allows users to set their desired savings for the month, and to see their current savings and set savings variable. 
		JPanel savingsPanel = new JPanel();
		savingsPanel.setBackground(SystemColor.inactiveCaptionBorder);
		sl_OverviewPanel.putConstraint(SpringLayout.NORTH, savingsPanel, 10, SpringLayout.NORTH, OverviewPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.WEST, savingsPanel, 10, SpringLayout.WEST, OverviewPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.SOUTH, savingsPanel, 250, SpringLayout.NORTH, OverviewPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.EAST, savingsPanel, 311, SpringLayout.WEST, OverviewPanel);
		OverviewPanel.add(savingsPanel);
		SpringLayout sl_savingsPanel = new SpringLayout();
		savingsPanel.setLayout(sl_savingsPanel);
		
		// Title to show the user what the panel is for.
		JLabel SavingTitle = new JLabel("Savings");
		sl_savingsPanel.putConstraint(SpringLayout.NORTH, SavingTitle, 10, SpringLayout.NORTH, savingsPanel);
		sl_savingsPanel.putConstraint(SpringLayout.WEST, SavingTitle, 61, SpringLayout.WEST, savingsPanel);
		sl_savingsPanel.putConstraint(SpringLayout.SOUTH, SavingTitle, 40, SpringLayout.NORTH, savingsPanel);
		sl_savingsPanel.putConstraint(SpringLayout.EAST, SavingTitle, 214, SpringLayout.WEST, savingsPanel);
		SavingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		SavingTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		savingsPanel.add(SavingTitle);
		
		// Subpanel within savingsPanel for the savings goal value.
		JPanel savingsGoalPanel = new JPanel();
		savingsGoalPanel.setBackground(SystemColor.inactiveCaptionBorder);
		sl_savingsPanel.putConstraint(SpringLayout.NORTH, savingsGoalPanel, 3, SpringLayout.SOUTH, SavingTitle);
		sl_savingsPanel.putConstraint(SpringLayout.WEST, savingsGoalPanel, 10, SpringLayout.WEST, savingsPanel);
		sl_savingsPanel.putConstraint(SpringLayout.SOUTH, savingsGoalPanel, 33, SpringLayout.SOUTH, SavingTitle);
		sl_savingsPanel.putConstraint(SpringLayout.EAST, savingsGoalPanel, 264, SpringLayout.WEST, savingsPanel);
		savingsPanel.add(savingsGoalPanel);
		
		// Subpanel within savingsPanel for the current savings of the user.
		JPanel currentSavingsPanel = new JPanel();
		currentSavingsPanel.setBackground(SystemColor.inactiveCaptionBorder);
		sl_savingsPanel.putConstraint(SpringLayout.NORTH, currentSavingsPanel, 6, SpringLayout.SOUTH, savingsGoalPanel);
		sl_savingsPanel.putConstraint(SpringLayout.WEST, currentSavingsPanel, 10, SpringLayout.WEST, savingsPanel);
		sl_savingsPanel.putConstraint(SpringLayout.SOUTH, currentSavingsPanel, 36, SpringLayout.SOUTH, savingsGoalPanel);
		sl_savingsPanel.putConstraint(SpringLayout.EAST, currentSavingsPanel, 0, SpringLayout.EAST, savingsGoalPanel);
		
		/// This and savingsValueText goes together, to display the current saving goal.
		JLabel savingsText = new JLabel("Savings Goal:");
		savingsText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		savingsText.setHorizontalAlignment(SwingConstants.CENTER);
		savingsGoalPanel.add(savingsText);
		
		savingsValueText = new JLabel("$0.00");
		savingsValueText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		savingsGoalPanel.add(savingsValueText);
		savingsPanel.add(currentSavingsPanel);
		
		
		// This and currentSavingsValue display the current savings of the user.
		JLabel currentSavingsText = new JLabel("Current Savings:");
		currentSavingsText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		currentSavingsPanel.add(currentSavingsText);
		
		currentSavingsValue = new JLabel("$0.00");
		currentSavingsValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		currentSavingsPanel.add(currentSavingsValue);
		
		// Used to call setSavings(), creates a savings goal for the user.
		JButton newSavingsButton = new JButton("Set Savings Goal");
		newSavingsButton.setToolTipText("Sets the total savings you want by the end of the month. ");
		sl_savingsPanel.putConstraint(SpringLayout.WEST, newSavingsButton, 10, SpringLayout.WEST, savingsPanel);
		sl_savingsPanel.putConstraint(SpringLayout.SOUTH, newSavingsButton, -10, SpringLayout.SOUTH, savingsPanel);
		newSavingsButton.setPreferredSize(new Dimension(120, 40));
		newSavingsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		savingsPanel.add(newSavingsButton);
		
		// Used to call refreshSavings() for the user.
		JButton refreshSavings = new JButton("Refresh");
		refreshSavings.addActionListener(this);
		sl_savingsPanel.putConstraint(SpringLayout.NORTH, refreshSavings, 0, SpringLayout.NORTH, newSavingsButton);
		sl_savingsPanel.putConstraint(SpringLayout.EAST, refreshSavings, -10, SpringLayout.EAST, savingsPanel);
		refreshSavings.setPreferredSize(new Dimension(120, 40));
		refreshSavings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		savingsPanel.add(refreshSavings);
		
		
		// This panel displays the current date of the user, and allows users to move to the next month. 
		JPanel timePanel = new JPanel();
		timePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sl_OverviewPanel.putConstraint(SpringLayout.NORTH, timePanel, 0, SpringLayout.NORTH, savingsPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.WEST, timePanel, 6, SpringLayout.EAST, savingsPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.SOUTH, timePanel, 0, SpringLayout.SOUTH, savingsPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.EAST, timePanel, 350, SpringLayout.EAST, savingsPanel);
		timePanel.setBackground(SystemColor.menu);
		OverviewPanel.add(timePanel);
		SpringLayout sl_timePanel = new SpringLayout();
		timePanel.setLayout(sl_timePanel);
		
		// Provides the label for dateDisplay to show what it's for. 
		JLabel timeLabel = new JLabel("Date:");
		sl_timePanel.putConstraint(SpringLayout.NORTH, timeLabel, 72, SpringLayout.NORTH, timePanel);
		sl_timePanel.putConstraint(SpringLayout.WEST, timeLabel, 10, SpringLayout.WEST, timePanel);
		sl_timePanel.putConstraint(SpringLayout.SOUTH, timeLabel, -116, SpringLayout.SOUTH, timePanel);
		sl_timePanel.putConstraint(SpringLayout.EAST, timeLabel, -284, SpringLayout.EAST, timePanel);
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		timePanel.add(timeLabel);
		
		
		// Displays the current date.
		JLabel dateDisplay = new JLabel(Calendar.MONTH + "/" + Calendar.DATE + "/" + Year.now());
		sl_timePanel.putConstraint(SpringLayout.NORTH, dateDisplay, 15, SpringLayout.NORTH, timeLabel);
		sl_timePanel.putConstraint(SpringLayout.WEST, dateDisplay, 6, SpringLayout.EAST, timeLabel);
		sl_timePanel.putConstraint(SpringLayout.EAST, dateDisplay, 86, SpringLayout.EAST, timeLabel);
		dateDisplay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		timePanel.add(dateDisplay);
		
		// Starts a new month - explained below in functions.
		JButton newMonthBtn = new JButton("New Month");
		newMonthBtn.setToolTipText("Press this to move to the next month.\r\nThis will remove all expenses and income values - leaving only the set savings and current savings. \r\n\r\nUse when you've moved to the next month.");
		sl_timePanel.putConstraint(SpringLayout.NORTH, newMonthBtn, 16, SpringLayout.NORTH, timePanel);
		sl_timePanel.putConstraint(SpringLayout.EAST, newMonthBtn, -10, SpringLayout.EAST, timePanel);
		newMonthBtn.setPreferredSize(new Dimension(120, 40));
		newMonthBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		timePanel.add(newMonthBtn);
		
		// Title for the timePanel.
		JLabel monthTitle = new JLabel("Month Controls");
		sl_timePanel.putConstraint(SpringLayout.NORTH, monthTitle, 0, SpringLayout.NORTH, newMonthBtn);
		sl_timePanel.putConstraint(SpringLayout.WEST, monthTitle, 10, SpringLayout.WEST, timePanel);
		sl_timePanel.putConstraint(SpringLayout.EAST, monthTitle, 160, SpringLayout.WEST, timePanel);
		monthTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		timePanel.add(monthTitle);
		newMonthBtn.addActionListener(this);
		
		// This panel is only used to start the demo with demoButton.
		JPanel blankPanel = new JPanel();
		sl_OverviewPanel.putConstraint(SpringLayout.NORTH, blankPanel, 6, SpringLayout.SOUTH, savingsPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.WEST, blankPanel, 0, SpringLayout.WEST, savingsPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.SOUTH, blankPanel, 257, SpringLayout.SOUTH, savingsPanel);
		sl_OverviewPanel.putConstraint(SpringLayout.EAST, blankPanel, 0, SpringLayout.EAST, timePanel);
		
		blankPanel.setBackground(Color.WHITE);
		OverviewPanel.add(blankPanel);
		SpringLayout sl_blankPanel = new SpringLayout();
		blankPanel.setLayout(sl_blankPanel);
		
		// Starts the demo function.
		JButton demoButton = new JButton("Start Demo");
		demoButton.setToolTipText("Starts the demo by providing example values.");
		demoButton.setPreferredSize(new Dimension(120, 40));
		demoButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		blankPanel.add(demoButton);
		demoButton.addActionListener(this);
		
		// Title for blankPanel.
		JLabel DemoTitle = new JLabel("Demo");
		sl_blankPanel.putConstraint(SpringLayout.SOUTH, DemoTitle, -194, SpringLayout.SOUTH, blankPanel);
		sl_blankPanel.putConstraint(SpringLayout.NORTH, demoButton, -7, SpringLayout.NORTH, DemoTitle);
		sl_blankPanel.putConstraint(SpringLayout.WEST, demoButton, 6, SpringLayout.EAST, DemoTitle);
		sl_blankPanel.putConstraint(SpringLayout.WEST, DemoTitle, 10, SpringLayout.WEST, blankPanel);
		DemoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		DemoTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		blankPanel.add(DemoTitle);
		newSavingsButton.addActionListener(this);
		
		// The Expense panel, holds all the panels for expenses. Parent is the tabbedPanel.
		JPanel Expenses = new JPanel();
		tabbedPane.addTab("Expenses", null, Expenses, null);
		Expenses.setLayout(new BorderLayout(0, 0));
		
		// This panel handles the main expense list, and it's controls.
		JScrollPane expenseListPane = new JScrollPane();
		expenseListPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		expenseListPane.setPreferredSize(new Dimension(400, 300));
		expenseListPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expenses.add(expenseListPane, BorderLayout.EAST);
		
		
		expenseDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		expenseDisplay.setLayoutOrientation(JList.VERTICAL_WRAP);
		expenseDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		expenseListPane.setViewportView(expenseDisplay);
		
		// The controls for the main expense list is within this panel.
		JPanel expenseButtonPanel = new JPanel();
		expenseButtonPanel.setPreferredSize(new Dimension(10, 50));
		expenseButtonPanel.setMinimumSize(new Dimension(100, 50));
		expenseButtonPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		expenseListPane.setColumnHeaderView(expenseButtonPanel);
		expenseButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		// This button creates new expenses.
		JButton newExpenseButton = new JButton("New Expense");
		newExpenseButton.setPreferredSize(new Dimension(120, 40));
		newExpenseButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		expenseButtonPanel.add(newExpenseButton);
		newExpenseButton.addActionListener(this);
		
		// This button deletes selected expenses within the expenseListPane.
		JButton delExpenseButton = new JButton("Delete Expense");
		delExpenseButton.setPreferredSize(new Dimension(120, 40));
		delExpenseButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		expenseButtonPanel.add(delExpenseButton);
		delExpenseButton.addActionListener(this);
		
		// This button refreshes expenses within expenseListPane..
		JButton refreshExpenseButton = new JButton("Refresh Expense");
		refreshExpenseButton.setPreferredSize(new Dimension(120, 40));
		refreshExpenseButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		expenseButtonPanel.add(refreshExpenseButton);
		refreshExpenseButton.addActionListener(this);
		
		// This is similar to the Summary pane in the Income panel.
		JPanel summaryExpense = new JPanel();
		Expenses.add(summaryExpense, BorderLayout.SOUTH);
		summaryExpense.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));
		
		// This and balTextValue_1 displays the current balance. 
		JLabel balText_1 = new JLabel("Balance:");
		balText_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		summaryExpense.add(balText_1);
		
		balTextValue_1 = new JLabel("$0.00");
		balTextValue_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		summaryExpense.add(balTextValue_1);
		
		// Spacer for balTextValue_1 and expenseText.
		JLabel spacer3 = new JLabel("  ");
		summaryExpense.add(spacer3);
		
		// This and ExpenseTextValue displays the monthly expenses.
		JLabel expenseText = new JLabel("Monthly Expenses:");
		expenseText.setFont(new Font("Tahoma", Font.BOLD, 16));
		summaryExpense.add(expenseText);
		
		ExpenseTextValue = new JLabel("$0.00");
		ExpenseTextValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		summaryExpense.add(ExpenseTextValue);
		
		// This scrollPane is used for the 'sort expenses' list.
		JScrollPane sortPane = new JScrollPane();
		sortPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sortPane.setPreferredSize(new Dimension(400, 300));
		sortPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expenses.add(sortPane, BorderLayout.WEST);
		
		
		sortedDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sortedDisplay.setLayoutOrientation(JList.VERTICAL_WRAP);
		sortedDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortPane.setViewportView(sortedDisplay);
		
		// The panel to contain the controls for sortPane.
		JPanel sortPaneButtons = new JPanel();
		sortPaneButtons.setPreferredSize(new Dimension(10, 50));
		sortPaneButtons.setMinimumSize(new Dimension(100, 50));
		sortPaneButtons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		sortPane.setColumnHeaderView(sortPaneButtons);
		sortPaneButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// The title for sortPaneButtons.
		JLabel sortExpenses = new JLabel("Sort Expenses");
		sortExpenses.setFont(new Font("Tahoma", Font.BOLD, 14));
		sortPaneButtons.add(sortExpenses);
		
		// Used to sort the sortPane expenses, discussed below in sortExpense();
		JButton sortExpensesButton = new JButton("Sort");
		sortExpensesButton.setToolTipText("Sort your current expenses by a specific category. It will be rated from most to least expensive!");
		sortExpensesButton.setPreferredSize(new Dimension(120, 40));
		sortExpensesButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortPaneButtons.add(sortExpensesButton);
		sortExpensesButton.addActionListener(this);
		
		
		categoryComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoryComboBox.setModel(new DefaultComboBoxModel(new String[] {"housing", "utilities", "groceries", "personal", "entertainment", "other"}));
		sortPaneButtons.add(categoryComboBox);
		
		// The center pane, used for month controls.
		JPanel centerExpensePanel = new JPanel();
		Expenses.add(centerExpensePanel, BorderLayout.CENTER);
		SpringLayout sl_centerExpensePanel = new SpringLayout();
		centerExpensePanel.setLayout(sl_centerExpensePanel);
		
		// This and dateDisplay_1 displays the month.
		JLabel timeLabel_2 = new JLabel("Date:");
		sl_centerExpensePanel.putConstraint(SpringLayout.NORTH, timeLabel_2, 80, SpringLayout.NORTH, centerExpensePanel);
		sl_centerExpensePanel.putConstraint(SpringLayout.WEST, timeLabel_2, 10, SpringLayout.WEST, centerExpensePanel);
		timeLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		centerExpensePanel.add(timeLabel_2);
		
		JLabel dateDisplay_1 = new JLabel(Calendar.MONTH + "/" + Calendar.DATE + "/" + Year.now());
		sl_centerExpensePanel.putConstraint(SpringLayout.NORTH, dateDisplay_1, 0, SpringLayout.NORTH, timeLabel_2);
		sl_centerExpensePanel.putConstraint(SpringLayout.WEST, dateDisplay_1, 6, SpringLayout.EAST, timeLabel_2);
		dateDisplay_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		centerExpensePanel.add(dateDisplay_1);
		
		// This is the title for centerExpensePanel.
		JLabel timeLabel_1_1 = new JLabel("Month Controls");
		sl_centerExpensePanel.putConstraint(SpringLayout.NORTH, timeLabel_1_1, 20, SpringLayout.NORTH, centerExpensePanel);
		sl_centerExpensePanel.putConstraint(SpringLayout.WEST, timeLabel_1_1, 10, SpringLayout.WEST, centerExpensePanel);
		timeLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		centerExpensePanel.add(timeLabel_1_1);
		
		// Similar to newMonthBtn, makes a new month. Check the actionPerformed for more.
		JButton newMonthBtn_1 = new JButton("New Month");
		newMonthBtn_1.setToolTipText("Press this to move to the next month.\r\nThis will remove all expenses and income values - leaving only the set savings and current savings. \r\n\r\nUse when you've moved to the next month.");
		sl_centerExpensePanel.putConstraint(SpringLayout.NORTH, newMonthBtn_1, -9, SpringLayout.NORTH, timeLabel_2);
		sl_centerExpensePanel.putConstraint(SpringLayout.EAST, newMonthBtn_1, -10, SpringLayout.EAST, centerExpensePanel);
		newMonthBtn_1.setPreferredSize(new Dimension(120, 40));
		newMonthBtn_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		centerExpensePanel.add(newMonthBtn_1);
		newMonthBtn_1.addActionListener(this);
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
		case "New Month":
			// Check mainClass.java, creates a new month, but keeps the savings values.
			newYear.newMonth();
			refreshIncome();
			refreshBalance();
			refreshExpense();
			refreshSavings();
			break;
		case "Show Manual":
			showManual();
			break;
		case "Start Demo":
			startDemo();
			break;
		
		}
	}
		
	// Combines all of the refresh functions in one. 
	public void Refresh() {
		refreshIncome();
		refreshBalance();
		refreshExpense();
		refreshSavings();
	}
	
	// Starts the Demo function in mainClass.java.
	public void startDemo() {
		newYear.Demo();
		Refresh();
	}
	
	// Provides a few JOptionPane dialogues to provide a small guide. 
	public void showManual() {
		JOptionPane.showMessageDialog(null, "This program is designed to assist users in managing their finances. In the Income tab, you can Set a savings value to aim towards, check your current savings, and create, delete, or refresh the income screen. ");
		JOptionPane.showMessageDialog(null, "In the expense tab, you can create create, delete, and refresh a list of expenses, as well as sort them by category. ");
		JOptionPane.showMessageDialog(null, "If you're ever confused on what a button does, hover over it! The tooltip will help you.");
	}
	
	// Resets all values and refreshes the GUI, starting a new project.
	public void newYear() {
		int check = JOptionPane.showConfirmDialog(null, "Are you sure you want to make a new file? Your unsaved data will be lost!", "Warning", JOptionPane.YES_NO_OPTION);
		if (check == JOptionPane.YES_OPTION) {
		newYear = new mainClass();
		Refresh();
		} 
	}
	
	// Takes the category selected in 
	public void sortExpense() {
		String category = (String) categoryComboBox.getSelectedItem();
		sortedList.clear();
		ArrayList<String> sorted = newYear.sortExpense(category);
		sortedList.ensureCapacity(sorted.size());
		sortedList.addAll(sorted);
		
	}
	
	// Opens a JFileChooser to select a file from the directory, then sends that as a File to the mainClass function Load();
	// Afterwards, it refreshes all variables once mainClass.Load() occurs.
	public void load() {
		
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load File");   
		 
		int userSelection = fileChooser.showOpenDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			newYear();
		    File fileToSave = fileChooser.getSelectedFile();
		    newYear.Load(fileToSave);
		    
		    Refresh();
	}
	}
	
	// Selects a file location via the JFileChooser, then pushes that as a file to the mainClass.Save() function. Refer to that for more. 
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
	
	// Refreshes the income list, by removing all of the variables then adding them, ensuring capacity.
	public void refreshIncome() {
		listed.removeAllElements();
		listed.ensureCapacity(newYear.returnIncomeLength());
		listed.addAll(newYear.returnIncomeDisplayed());
		refreshBalance();
	}
	
	// Same as refreshIncome() but for expenses.
	public void refreshExpense() {
		listedE.removeAllElements();
		listedE.ensureCapacity(newYear.returnExpenseLength());
		listedE.addAll(newYear.returnExpenseDisplayed());
		refreshBalance();
	}
	
	// Used in addIncome(), makes a JOptionPane to recieve the name of the income.
	public String addIncomeName() {
		String newName = (String)JOptionPane.showInputDialog("Please enter the name of the income.");
		return newName;
	}
	
	// Used in addIncome(), recieves a value. If the value is a negative, above 9999999, or isn't a double, the function repeats. 
	public Double addIncomeValue() {
		String newValue = JOptionPane.showInputDialog("What's the value of the income? (Please input between 1 and 9999999)");
		if (newValue == null) return (double) 0;
		if (isDouble(newValue)) {
			if (Double.valueOf(newValue) < 0 || newValue.length() > 7) return addIncomeValue();
			}
		
		if (isDouble(newValue)) {
			return Double.parseDouble(newValue);
		} else {
			return addIncomeValue();
		}
	}
	
	// Same for addIncomeValue, but for income laps, and prevents the user from inputting anything but a double integet between 1 and 30.
	public Double addIncomeLap() {
		String newLap = JOptionPane.showInputDialog("How many days are between your pay periods? (Please input a number between 1 and 30).");
		if (newLap == null) return (double) 0;
		if (isDouble(newLap)) {
			if (Double.valueOf(newLap) < 1 || newLap.length() > 30) return addIncomeLap();
			}
		if (isDouble(newLap)) {
			return Double.parseDouble(newLap);
		} else {
			return addIncomeLap();
		}
	}
	
	
	// Similar to addIncomeName() but for expenses. 
	public String addExpenseName() {
		String newName = (String)JOptionPane.showInputDialog("Please enter the name of the expense.");
		return newName;
	}
	
	// Same as addIncomeValue() but for the addExpense() function.
	public Double addExpenseValue() {
		String newValue = JOptionPane.showInputDialog("What's the cost value of the expense? (Please input between 1 and 9999999)");
		if (newValue == null) return (double) 0;
		if (isDouble(newValue)) {
		if (Double.valueOf(newValue) < 0 || newValue.length() > 7) return addExpenseValue();
		}
		if (isDouble(newValue)) {
			return Double.parseDouble(newValue);
		} else {
			return addExpenseValue();
		}
	}
	
	// Has the user select between the offered expense categories, then returns that to the addExpense() function.
	public String addExpenseCategory() {
		String[] options = {"housing", "utilities", "groceries", "personal", "entertainment", "other"};
		int newCategory = JOptionPane.showOptionDialog(null, "What category is the expense?", "Expense", 0, 3, null, options, options[0]);
		
		
			return options[newCategory];
		
	}
	

	// Checks if the string is a Double. Used to check in addExpenseValue(), addIncomeValue(), and addIncomeLap();
	public static boolean isDouble(String s)
	{
	    return DOUBLE_PATTERN.matcher(s).matches();
	}
	
	
	// Creates an income in the mainClass newYear by using the addIncomeName(), addIncomeValue(), and addIncomeLap() to get the three required variables, then creating the income.
	// Refreshes the income list after to allow the user to see it.
	public void addIncome() {
		String newName = addIncomeName();
		if (newName == null) return;
		Double newValue = addIncomeValue();
		if (newValue == 0) return;
		Double newLap = addIncomeLap();
		if (newLap == 0) return;
		newYear.makeIncome(newName, newValue, newLap);
		refreshIncome();
		
				
	}
	
	// The exact same thing as addIncome() but to create an expense, with addExpenseName(), addExpenseValue(), and addExpenseCategory() used to get the variables.
	public void addExpense() {
		String newName = addExpenseName();
		if (newName == null) return;
		Double newValue = addExpenseValue();
		String newCategory = addExpenseCategory();
		newYear.makeExpense(newName, newValue, newCategory);
		refreshExpense();
	}
	
	
	// Deletes the selected variable in the listed list, which is held in displayedList. Takes the indexed variable, then calls the mainClass function removeIncome();
	public void deleteIncome() {
		if (listed.size() != 0) {
			System.out.println("Delete");
			newYear.removeIncome(displayedList.getSelectedIndex());
			refreshIncome();
		}
	}
	
	// The same as deleteIncome but for expenses, in the listedE list, which is held in 
	public void deleteExpense() {
		if (listedE.size() != 0) {
			System.out.println("Delete");
			newYear.removeExpense(expenseDisplay.getSelectedIndex());
			refreshExpense();
		}
	}
	
	public void refreshBalance() {
		balTextValue.setText(newYear.getSetBalance());
		incomeTextValue.setText(newYear.calcTotalIncome());
		balTextValue_1.setText(newYear.getSetBalance());
		ExpenseTextValue.setText("$" + newYear.returnExpenseTotal());
		refreshSavings();
		
	}
	
	public void refreshSavings() {
		savingsValueText.setText("$" + newYear.getSetSavings());
		currentSavingsValue.setText(newYear.savingSetter());
	}
	
	public void setSavings() {
		String newSavings = JOptionPane.showInputDialog("What's your current goal?");
		if( newSavings.length() == 0 ) return;
		
		if (isDouble(newSavings)) {
			if (Double.valueOf(newSavings) < 0 || newSavings.length() > 7) {
				setSavings();
			}
			newYear.setSavings(Double.parseDouble(newSavings));
			refreshSavings();
		} else {
			setSavings();
	}
	}
}
