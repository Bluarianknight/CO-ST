package MainPackage;
/*
 * This class is the main controller, with it's intended purpose to save data continuously - switching between months automatically, with 'current' saving and loading
 * features not implemented fully. Right now, it simply acts as a buffer.
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.Scanner;

import costPackage.Expense;
import costPackage.Income;
import costPackage.sortedExpense;


public class mainClass {

	LocalDate checkDate = LocalDate.now();
	
	costMonth current = new costMonth();
	double savings;
	
	public mainClass() {
		savings = 0;
		
	}
			  
	public void newMonth() {
		savings += current.getBalance();
		double SetSavings = current.getSetSavings();
		current = new costMonth();
		current.setSetSavings(SetSavings);
		
	}
		
	public void makeExpense(String newName, double newValue, String newCat) {
		current.newExpense(newName, newValue, newCat);
	}
	
	public String getExpense(String newExpense) {
		return current.findExpense(newExpense);
	}
	
	public void makeIncome(String newName, double newValue, double rot) {
		current.newIncome(newName, newValue, rot);
	}
	
	public String getIncome(String newIncome) {
		return current.findIncome(newIncome);
	}
	
	public String getExpenseCount(int Num) {
		return current.findExpenseCount(Num);
	}
	
	public String getIncomeCount(int Num) {
		return current.findIncomeCount(Num);
	}
	
	public int returnExpenseLength() {
		return current.findExpenseLength();
	}
	
	public int returnIncomeLength() {
		return current.findIncomeLength();
	}
	public double getSetSavings() {
		return current.getSetSavings();
	}
	public void setSavings(double Savings) {
		current.setSetSavings(Savings);
	}
	
	public String getSetBalance() {
		if (current.getBalance() > -1) {
		return "$" + current.getBalance();
		} else {
			return "-$" + current.getBalance() * -1;
		}
	}
	
	public ArrayList<String> returnIncomeDisplayed() {
		return current.incomeDisplay();
	}
	
	public ArrayList<String> returnExpenseDisplayed() {
		return current.expenseDisplay();
	}
	
	public void removeExpense(int x) {
		current.removeExpense(x);
	}
	
	public void removeIncome(int x) {
		current.removeIncome(x);
	}
	
	
	
	public double returnExpenseTotal() {
		return current.returnExpenseTotal();
	}
	
	public String calcIncomingIncome() {
		return "$" + current.calcIncomingIncome();
	}
	
	public String savingSetter() {
		double newSaving = savings + current.getBalance();
		double bal = current.getBalance() - this.getSetSavings();
		if (bal > 0 && newSaving > this.getSetSavings()) {
			return String.valueOf("$" +  Double.valueOf(newSaving));
		} else if (bal < 0 && newSaving > this.getSetSavings()) {
			return String.valueOf("$" +  Double.valueOf(newSaving));
		}
		return String.valueOf("$" + savings);
		
	}
	
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
	
	

	public void Save(String fileLocation) {
		File newFile = new File(fileLocation + ".txt");
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
	

	public void Load(File fileToSave) {
		File loadFile = fileToSave; 
		Scanner loadReader = null;
		int i = 0;
		try {
			loadReader = new Scanner(loadFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
				System.out.println("ERROR");
				break;
			}
			}
		}
	}
	
	
	public void Demo() {
		this.makeExpense("Car", 50000, "other");
		this.makeExpense("Cat", 2000, "housing");
		this.makeIncome("New Car Driving", 4000, 5);
		this.makeIncome("Cat Shows", 10000, 1);
		this.setSavings(5000);
		savings = 4000;
	}
}
