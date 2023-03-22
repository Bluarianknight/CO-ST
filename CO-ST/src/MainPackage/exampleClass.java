package MainPackage;
import javax.swing.JFrame;

import guiHandling.mainFrameSetter;

// Attempting to test Expenses.
public class exampleClass {

	public static void main(String[] Args) {
		// Sets up a new calculations for calculating expenses, and sets two expenses to return the total expense. Works.
		// costMonth newMonth = new costMonth();
		JFrame frame = new mainFrameSetter();
		frame.setTitle("Co-ST");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		/*
		newMonth.newExpense("Cat", 25.00, "Housing");
		newMonth.newExpense("Car", 550.00, "Personal");
		
		newMonth.newIncome("Doordash", 55, 7);
		
		newMonth.findExpense("Car");
		newMonth.showBalance();
		newMonth.showDate();
		*/
	}
	
	
	


}
