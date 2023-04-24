/*
 * This class manages between the newMonth class, which handles the expenses and income, and the MainWindow class. It's used to contain the current savings value, and
 * also handles the saving and loading process. 
 */


package MainPackage;


import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import costPackage.sortedExpense;


public class mainClass {

	
	// costMonth is used to manage expenses and income - anything that needs to be used in mainWindow is made into a function here.
	costMonth current = new costMonth();
	double savings;
	
	public mainClass() {
		// When a new mainClass is made, the savings are set to 0.
		savings = 0;
		
	}
			  
	// This resets the costMonth class current, but brings over the setSavings variable to keep track. The current balance is moved over as the new savings. 
	public void newMonth() {
		savings += current.getBalance();
		double SetSavings = current.getSetSavings();
		current = new costMonth();
		current.setSetSavings(SetSavings);
		
	}
		
	// Creates an expense, using the costMonth newExpense() function.
	public void makeExpense(String newName, double newValue, String newCat) {
		current.newExpense(newName, newValue, newCat);
	}
	

	// Creates an income using the costMonth newIncome() function. 
	public void makeIncome(String newName, double newValue, double rot) {
		current.newIncome(newName, newValue, rot);
	}
	

	// Gets an expense at index Num. Refer to costMonth findExpenseCount();
	public String getExpenseCount(int Num) {
		return current.findExpenseCount(Num);
	}
	

	
	// Returns the current length of the expense arrays. 
	public int returnExpenseLength() {
		return current.findExpenseLength();
	}
	
	// Returns the current length of the income arrays.
	public int returnIncomeLength() {
		return current.findIncomeLength();
	}
	
	// Returns the current set savings.
	public double getSetSavings() {
		return current.getSetSavings();
	}
	
	// Set the set savings variable. 
	public void setSavings(double Savings) {
		current.setSetSavings(Savings);
	}
	
	// Returns the current balance as a string for display.
	public String getSetBalance() {
		if (current.getBalance() > -1) {
		return "$" + current.getBalance();
		} else {
			return "-$" + current.getBalance() * -1;
		}
	}
	
	// Provides the incomeDisplay arraylist from the Income class. 
	public ArrayList<String> returnIncomeDisplayed() {
		return current.incomeDisplay();
	}
	
	// Provides the expenseDisplay arraylist from the Expense class.
	public ArrayList<String> returnExpenseDisplayed() {
		return current.expenseDisplay();
	}
	
	// Removes an expense at index x.
	public void removeExpense(int x) {
		current.removeExpense(x);
	}
	
	// Removes an income at index x.
	public void removeIncome(int x) {
		current.removeIncome(x);
	}

	
	// Returns the returnExpenseTotal() function from costMonth. Refer to returnExpenseTotal() in costMonth.
	public double returnExpenseTotal() {
		return current.returnExpenseTotal();
	}
	
	// Returns the calcTotalIncome() function as a String for GUI. Refer to calcTotalIncome() in costmonth. 
	public String calcTotalIncome() {
		return "$" + current.calcTotalIncome();
	}
	
	// Returns a string to display the current savings value - if the savings + current balance is above 0 + is above the set savings goal, it is displayed. Otherwise, the current savings
	// are displayed.
	public String savingSetter() {
		double newSaving = savings + current.getBalance();
		double bal = current.getBalance() - this.getSetSavings();
		if (bal > 0 && newSaving > this.getSetSavings()) {
			return String.valueOf("$" +  Double.valueOf(newSaving));
		}
		return String.valueOf("$" + savings);
		
	}
	
		/*This function returns an array list of all the expenses with the category 'category', sorted from most to least expensive.
		 * It uses an array list of sortedExpense, creating sortedExpenses foe each expense of category 'category' then outputs it
		 * into the returned array list.
		 */
	public ArrayList<String> sortExpense(String category) {
		ArrayList <sortedExpense> sorted = current.categorizedExpense(category);
		ArrayList <String> newSorted = new ArrayList<String>();
		Collections.sort(sorted, Collections.reverseOrder());
		for (int i = 0;  i < sorted.size(); i++) {
			sortedExpense counted = sorted.get(i);
			counted.sortDisplay(i + 1);
			newSorted.add(counted.returnDisplay());
		}
		return newSorted;
	}
	
	
/*
 * Creates a file at String fileLocation, which is a set location from mainWindow. 
 * It then saves the file in a format that goes expenses, income, then the savings variable.
 * This format is then used to load the files in the Load() function.
 */
	public void Save(String fileLocation) {
		File newFile;
		if (fileLocation.contains(".txt")) {
			newFile = new File(fileLocation);
		} else {
			newFile = new File(fileLocation + ".txt");	
		}
	
		try {
			FileWriter fileWriter = new FileWriter(newFile);
			BufferedWriter newWriter = new BufferedWriter(fileWriter);
			
			
			
			newWriter.write("EXPENSE");
			newWriter.newLine();
			for (int i = 0; i < current.findExpenseLength(); i++) {
				newWriter.write(current.getExpenseName(i).replace(" ", "_") + " " + current.getExpenseValue(i) + " " + current.getExpenseCategory(i));
				newWriter.newLine();
			}
			newWriter.write("INCOME");
			newWriter.newLine();
			for (int j = 0; j < current.findIncomeLength(); j++) {
				newWriter.write(current.getIncomeName(j).replace(" ", "_") + " " + current.getIncomeValue(j) + " " + current.getIncomeLap(j));
				newWriter.newLine();
			}
			newWriter.write("SAVING");
			newWriter.newLine();
			newWriter.write(String.valueOf(current.getSetSavings()));
			newWriter.newLine();
			newWriter.write(String.valueOf(savings));
			newWriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	/*
	 * Loads a file from the selected file fileToSave, obtained from the mainWindow load() function.
	 * It checks to see if the file is formatted like the Save method. If it isn't, it outputs an error message.
	 */

	public void Load(File fileToSave) {
		File loadFile = fileToSave; 
		Scanner loadReader = null;
		int i = 0;
		try {
			loadReader = new Scanner(loadFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error has occured. Please check to see if you've selected the correct file.");
			e.printStackTrace();
		}
		while (loadReader.hasNextLine()) {
			String read = loadReader.next();
			if (read.equals("EXPENSE")) {
				i = 1;
			}else if (read.equals("INCOME")) {
				i = 2;
			} else if (read.equals("SAVING")) {
				i = 3;
			} else {
			
			switch (i) {
			case 1:
				String newNameExpense = read.replace("_", " ");
				double newExpenseValue = Double.valueOf(loadReader.next());
				String newCategory = loadReader.next();
				
				makeExpense(newNameExpense, newExpenseValue, newCategory);
				break;
			case 2:
				String newIncomeName = read.replace("_", " ");
				double newIncomeValue = Double.valueOf(loadReader.next());
				double newIncomeLap = Double.valueOf(loadReader.next());
				makeIncome(newIncomeName, newIncomeValue, newIncomeLap);
				break;
			case 3:
				current.setSetSavings(Double.valueOf(read));
				savings = Double.valueOf(loadReader.next());
				break;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "An error has occured. Please check to see if you've selected the correct file.");
				break;
			}
			}
		}
	}
	
	// Creates a few expenses, income and provides a setSavings and savings value already for demonstration.
	public void Demo() {
		this.makeExpense("Car", 50000, "other");
		this.makeExpense("Cat", 2000, "housing");
		this.makeIncome("New Car Driving", 4000, 5);
		this.makeIncome("Cat Shows", 10000, 1);
		this.setSavings(5000);
		savings = 4000;
	}
}
