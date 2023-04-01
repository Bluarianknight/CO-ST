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

import javax.swing.*;

public class MainScreen extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int frameWidth = 800;
	int frameLength = 600;
	costYear newYear = new costYear();
	JLabel testLabel = new JLabel();
	JTextField tf1 = new JTextField(12),
	tf2 = new JTextField(12),
	tf3 = new JTextField(12),
	testField = new JTextField(12);
	
	public MainScreen() {
		MainScreenStart();
		setSize(frameWidth, frameLength);
		this.setVisible(true);
		this.setTitle("CO-ST EXPENSE");
		
	}
	
	private void MainScreenStart() { 
		
		
		
		
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
		
		JPanel leftMiddleP = new JPanel();
		leftMiddleP.setLayout(new FlowLayout());
		JPanel rightMiddleP = new JPanel();
		rightMiddleP.setLayout(new FlowLayout());
		
		JButton testButton = new JButton("Expense");
		testButton.addActionListener(this);
		testLabel.setText("Test");
		JTextField testField = new JTextField(12);
		
		leftMiddleP.add(tButton);
		leftMiddleP.add(tf1);
		leftMiddleP.add(tf2);
		leftMiddleP.add(tf3);
		
		rightMiddleP.add(testButton);
		rightMiddleP.add(testField);
		rightMiddleP.add(testLabel);
		
		middlepanel.add(BorderLayout.WEST, leftMiddleP);
		middlepanel.add(BorderLayout.EAST, rightMiddleP);
		
		
		
		this.getContentPane().add(BorderLayout.CENTER, middlepanel);
		this.getContentPane().add(BorderLayout.NORTH, mbar);
		
	}
	
	public void setLabel() {
		testLabel.setText(newYear.getExpense(testField.getText()));
	}
	
	public void makeExpense() {
		newYear.makeExpense(String.valueOf(tf1.getText()), Double.parseDouble(tf2.getText()), String.valueOf(tf3.getText()));
		// testLabel.setText(newYear.getExpense(tf1.getText()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) 
		{
		case "Expense":
			setLabel();
			break;
			
		case "Make Expense":
			makeExpense();
			break;
		}
		
	}

}
