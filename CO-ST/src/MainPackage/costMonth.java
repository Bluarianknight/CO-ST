/*
 * This class is used to manage the income and expense classes. 
 */


package MainPackage;


import java.util.ArrayList;

import costPackage.Expense;
import costPackage.Income;
import costPackage.Savings;
import costPackage.sortedExpense;


public class costMonth {
	
	
	// The expense, income, and savings objects used for all functions.
	Expense monthExpenses = new Expense();
	Income monthIncome = new Income();
	Savings savings = new Savings();
	

	// Create a new expense in the monthExpenses object.
	public void newExpense(String newName, double newValue, String newCategory) {
		monthExpenses.newExpense(newName, newValue, newCategory);
	}
	
	// Creates a new income in the monthIncome object. 
	
	public void newIncome(String newName, double newValue, double newLap) {
		monthIncome.newIncome(newName, newValue, newLap);
	}
	
	
	// Finds the expense at index Number.
	public String findExpenseCount(int Number) {
		String returnExpenseName = monthExpenses.returnExpenseName(Number);
		double returnExpenseCost = monthExpenses.returnExpenseValue(Number);
		String returnExpenseCategory = monthExpenses.returnExpenseCategory(Number);
		String newString = Number + 1 + ": " + returnExpenseName + " $" + returnExpenseCost + ", Category: " + returnExpenseCategory + ". "; 
		return newString;
	}
	
	// Returns the length of the expenses arrays.
	public int findExpenseLength() {
		return monthExpenses.returnExpenseLength();
	}
	// Returns the length of the income arrays.
	public int findIncomeLength() {
		return monthIncome.returnIncomeLength();
	}

	
	// Returns the balance of income and expenses calculated together as a double.
	public double getBalance() {
		double balance = calcTotalIncome() - monthExpenses.returnTotalCost();
		return balance;
	}
	
	// Returns the total expenses value so far. 
	public double returnExpenseTotal() {
		return monthExpenses.returnTotalCost();
	}
	
	// Sets the setSavings value in the savings class.
	public void setSetSavings(double newSavings) {
		savings.setSavings(newSavings);
	}
	
	// Obtains the setSavings value in the savings class.
	public double getSetSavings() {
		return savings.getSavings();
	}
	
	// Returns the ArrayList<String> for the incomeDisplay value in the Income class.
	public ArrayList<String> incomeDisplay() {
		return monthIncome.returnDisplayedIncome();
	}
	
	// Returns the ArrayList<String> expenseDisplay for the Expense class.
	public ArrayList<String> expenseDisplay() {
		return monthExpenses.returnDisplayed();
	}
	
	// Removes income at index x in all of the income array lists.
	public void removeIncome(int x) {
		monthIncome.removeIncome(x);
	}
	
	// Removes expense at index x for all the expense array lists.
	public void removeExpense(int x){
		monthExpenses.expenseRemove(x);
	}
	
	// Returns the total calculated income value of all of the total income. Refer to the income method getTotal();
	public double calcTotalIncome() {
		int x = 0;
		
		for (int y = 0; y < monthIncome.returnLength(); y++) {
			x += monthIncome.getTotal(y);
		}
		
		return x;
	}
	
	
	// Used in the maainClass method sortExpense(). Takes all of the expenses equaling the category provided, and adds it to a sortedExpense, 
	// which is then added into a sortedExpense array list, that is returned to to the sortExpense() method.
	public ArrayList<sortedExpense> categorizedExpense(String category) {
		ArrayList<sortedExpense> sortedList = new ArrayList<sortedExpense>();
		for (int x = 0; x < monthExpenses.returnExpenseLength(); x++) {
			if (monthExpenses.returnExpenseCategory(x).equals(category)) {
				sortedExpense sortedE = new sortedExpense(monthExpenses.returnExpenseName(x), monthExpenses.returnExpenseValue(x), monthExpenses.returnDisplayed(x), monthExpenses.returnExpenseCategory(x));
				sortedList.add(sortedE);
				
			}
			
		}
		return sortedList;
	}
		
	// Gets the name of an expense at index x.
	public String getExpenseName(int x) {
		return monthExpenses.returnCostName(x);
	}
	
	// Gets the value of an expense at index x.
	public Double getExpenseValue(int x) {
		return monthExpenses.returnCostValue(x);
	}
	
	// Gets the category of an expense at index x.
	public String getExpenseCategory(int x) {
		return monthExpenses.returnExpenseCategory(x);
	}
	
	// Gets the name of an income at index x.
	public String getIncomeName(int x) {
		return monthIncome.returnCostName(x);
	}
	
	// Gets the value of an income at index x.
	public Double getIncomeValue(int x) {
		return monthIncome.returnIncomeValue(x);
	}
	
	// Gets the incomeLap of an income at index x.
	public Double getIncomeLap(int x) {
		return monthIncome.returnIncomeLap(x);
	}
	

	
	
	
	}
	

