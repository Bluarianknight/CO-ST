package guiHandling;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import MainPackage.costYear;
import costPackage.Savings;

import javax.swing.*;

public class MainScreen extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int frameWidth = 1280;
	int frameLength = 720;
	costYear newYear = new costYear();
	JLabel testLabel = new JLabel(),
	topLabel = new JLabel(),
	rmmtop = new JLabel(),
	rmm1 = new JLabel(),
	rmm2 = new JLabel(),
	rmm3 = new JLabel(),
	rmm4 = new JLabel(),
	rmm5 = new JLabel();
	JComboBox category;
	int zed;
	boolean Check;
	
	JTextField tf1 = new JTextField(12),
	tf2 = new JTextField(12),
	tf3 = new JTextField(12),
	savings = new JTextField(12),
			if1 = new JTextField(12),
			if2 = new JTextField(12),
			if3 = new JTextField(12),
	testField = new JTextField(12);
	
	public MainScreen() {
		MainScreenStart();
		setSize(frameWidth, frameLength);
		this.setVisible(true);
		this.setTitle("CO-ST EXPENSE");
		
	}
	
	private void MainScreenStart() { 
		
		zed = 0;
		Check = true;
		
		JMenuBar mbar = new JMenuBar();
		JMenu file = new JMenu("Files");
		JMenu help = new JMenu("Help");
		mbar.add(file);
		mbar.add(help);
		JMenuItem file1 = new JMenuItem("Open");
		JMenuItem file2 = new JMenuItem("Save as");
		file.add(file1);
		file.add(file2);
		
		
		
		
		JPanel middlepanel = new JPanel();
		middlepanel.setLayout(new BorderLayout());
		// JLabel labelOne = new JLabel("For Testing");
		
		
		JButton tButton = new JButton("Make Expense");
		tButton.addActionListener(this);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		
		JButton iButton = new JButton("Make Income");
		iButton.addActionListener(this);
		
		JButton incButton = new JButton("See Incomes");
		incButton.addActionListener(this);
		
		JButton expButton = new JButton("See Expenses");
		expButton.addActionListener(this);
		
		JPanel leftMiddleP = new JPanel();
		leftMiddleP.setLayout(new FlowLayout());
		JPanel rightMiddleP = new JPanel();
		rightMiddleP.setLayout(new FlowLayout());
		
		JButton testButton = new JButton("Reset");
		testButton.addActionListener(this);
		
		
		
		
		
		JPanel topMiddleP = new JPanel();
		topLabel.setText("Welcome to CO-ST! This prototype provides a basic interface on how the basic project will work.");
		topMiddleP.add(topLabel);
		
		
		topMiddleP.add(topLabel);
		
		JPanel rightMiddleM = new JPanel();
		rightMiddleM.setLayout(new BoxLayout(rightMiddleM, BoxLayout.PAGE_AXIS));
		rmmtop.setText("List of Expenses");
		rmm1.setText("Empty");
		rmm2.setText("Empty");
		rmm3.setText("Empty");
		rmm4.setText("Empty");
		rmm5.setText("Empty");
		
		leftMiddleP.setLayout(new FlowLayout());
		rightMiddleP.setLayout(new GridLayout(4, 1));
		
		rightMiddleM.add(rmmtop);
		rightMiddleM.add(rmm1);
		rightMiddleM.add(rmm2);
		rightMiddleM.add(rmm3);
		rightMiddleM.add(rmm4);
		rightMiddleM.add(rmm5);
		
		tButton.setPreferredSize(new Dimension(120, 40));
		iButton.setPreferredSize(new Dimension(120, 40));
		
		String[] categoryList = {"housing", "utilities", "groceries", "personal", "entertainment", "other"};
		 category = new JComboBox(categoryList);
		
		leftMiddleP.add(tButton);
		leftMiddleP.add(tf1);
		leftMiddleP.add(tf2);
		leftMiddleP.add(category);
		
		JPanel Savings = new JPanel();
		JButton savingsButton = new JButton("Set Savings");
		savingsButton.addActionListener(this);
		JButton recieveButton = new JButton("Check Savings");
		recieveButton.addActionListener(this);
		
		Savings.add(savingsButton);
		Savings.add(recieveButton);
		Savings.add(savings);
		

		
		JPanel leftMiddleP2 = new JPanel();
		
		leftMiddleP2.add(iButton);
		leftMiddleP2.add(if1);
		leftMiddleP2.add(if2);
		leftMiddleP2.add(if3);
		
		JPanel RightTopM = new JPanel();
		RightTopM.add(backButton);
		RightTopM.add(testButton);
		RightTopM.add(nextButton);
		// RightTopM.add(testField);
		

		
		rightMiddleP.add(RightTopM);
		rightMiddleP.add(rightMiddleM);
		

		JPanel leftMiddleMain = new JPanel();
		leftMiddleMain.setLayout(new GridLayout(10, 1, 0, 1));
				
		leftMiddleMain.add(BorderLayout.EAST, leftMiddleP);
		leftMiddleMain.add(BorderLayout.EAST, leftMiddleP2);
		leftMiddleMain.add(Savings);
		
		leftMiddleMain.setPreferredSize(new Dimension(600, 300));
		rightMiddleP.setPreferredSize(new Dimension(300, 300));
		
		middlepanel.add(BorderLayout.WEST, leftMiddleMain);
		middlepanel.add(BorderLayout.EAST, rightMiddleP);
		middlepanel.add(BorderLayout.NORTH, topMiddleP);
		
		
		
		this.getContentPane().add(BorderLayout.CENTER, middlepanel);
		this.getContentPane().add(BorderLayout.NORTH, mbar);
		
		
	}
	
	public void setLabel(String e) {
		System.out.println(e);
		testLabel.setText(newYear.getExpense(e));
	}
	
	public void makeExpense() {
		
		newYear.makeExpense(String.valueOf(tf1.getText()), Double.parseDouble(tf2.getText()), String.valueOf(category.getSelectedItem()));
		// testLabel.setText(newYear.getExpense(tf1.getText()));
	}
	
	public void makeIncome() {
		newYear.makeIncome(if1.getText(), Double.parseDouble(if2.getText()), Double.parseDouble(if3.getText()));
		if1.setText("");
		if2.setText("");
		if3.setText("");
	}
	
	public void UpdateChart(boolean test) {
		System.out.println(tf1.getText());
		if (test == true) {
			rmmtop.setText("List of Expenses");
			if (newYear.returnExpenseLength() > 0 + zed) {
		rmm1.setText(newYear.getExpenseCount(0 + zed));
			} else {
				rmm1.setText("Empty");
			}
		System.out.println(newYear.returnExpenseLength());
		if (newYear.returnExpenseLength() > 1 + zed) {
			rmm2.setText(newYear.getExpenseCount(1 + zed));
		} else {
			rmm2.setText("Empty");
		}
		if (newYear.returnExpenseLength() > 2 + zed) {
		rmm3.setText(newYear.getExpenseCount(2 + zed));
		} else {
			rmm3.setText("Empty");
		}
		if (newYear.returnExpenseLength() > 3 + zed) {
		rmm4.setText(newYear.getExpenseCount(3 + zed));
		} else {
			rmm4.setText("Empty");
		}
		if (newYear.returnExpenseLength() > 4 + zed) {
		rmm5.setText(newYear.getExpenseCount(4 + zed));
		}
		else {
			rmm5.setText("Empty");
		}
		}
		if (test == false) {
			rmmtop.setText("List of Income");
			if (newYear.returnIncomeLength() > 0 + zed) {
			rmm1.setText(newYear.getIncomeCount(0 + zed));
			} else {
				rmm1.setText("Empty");
			}
			if (newYear.returnIncomeLength() > 1 + zed) {
				rmm2.setText(newYear.getIncomeCount(1 + zed));
			} else {
				rmm2.setText("Empty");
			}
			if (newYear.returnIncomeLength() > 2 + zed) {
			rmm3.setText(newYear.getIncomeCount(2 + zed));
			} else {
				rmm3.setText("Empty");
			}
			if (newYear.returnIncomeLength() > 3 + zed) {
			rmm4.setText(newYear.getIncomeCount(3 + zed));
			} else {
				rmm4.setText("Empty");
			}
			if (newYear.returnIncomeLength() > 4 + zed) {
			rmm5.setText(newYear.getIncomeCount(4 + zed));
			} else {
				rmm5.setText("Empty");
			}
		}
			
			
			
		}
		
		public void setSaving() {
			newYear.setSavings(Double.parseDouble(savings.getText()));
		}
		
		public void getSaving() {
			System.out.println(newYear.getSavings());
			savings.setText(String.valueOf(newYear.getSavings()));
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) 
		{
		case "Expense":
			String f = testField.getText();
			setLabel(f);
			
			break;
			
		case "Make Expense":
			makeExpense();
			UpdateChart(true);
			Check = true;
			break;
		case "Make Income":
			makeIncome();
			UpdateChart(false);
			Check = false;
			break;
		case "Reset":
			zed = 0;
			UpdateChart(Check);
			break;
		case "Next":
			zed = zed + 5;
			UpdateChart(Check);
			break;
		case "Back":
			if (zed > 4) {
				zed = zed - 5;
			}
			UpdateChart(Check);
			break;
		case "See Incomes":
			UpdateChart(false);
			break;
		case "See Expenses":
			UpdateChart(true);
			break;
		case "Set Savings":
			setSaving();
			break;
		case "Get Savings":
			getSaving();
			break;
			}
		
		}
		
	}


