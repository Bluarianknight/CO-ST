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

import costPackage.sortedExpense;

public class mainClass {

	LocalDate checkDate = LocalDate.now();
	
	costMonth current = new costMonth();
	int savings;
	
	public mainClass() {
		savings = 0;
		
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
	
	public double savingSetter() {
		double bal = current.getBalance();
		if (bal < savings && bal < current.getSetSavings() && bal > 0) {
			return savings - (current.getSetSavings() - bal);
		} else if (bal < savings && bal < current.getSetSavings() && bal < 0){
			return savings - bal - current.getSetSavings();
		} else {
			return bal;
		}
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
		
	}
	
	public void Load(String fileLocation) {
		
	}
}
