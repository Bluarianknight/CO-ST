package MainPackage;
// LocalDate and Month will be used to help keep track of the current date - useful for income calculations, and knowing what month it is in general. 

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import costPackage.Expense;
import costPackage.Income;
import costPackage.Savings;
import costPackage.sortedExpense;


public class costMonth {
	
	
	// The Expense, Income, and theDate objects required to make costMonth work. Refer to classes for how they work.
	Expense monthExpenses = new Expense();
	Income monthIncome = new Income();
	costDate theDate = new costDate();
	Savings savings = new Savings();
	// Set values for use in dates.
	LocalDate setDate;
	LocalTime setTime = LocalTime.now();
	int setDay;
	Month setMonth;
	int setYear;
	
	int dateCheck;
	
	// To be used to calculate income - not in use yet.
	LocalDate lastCheckDate;
	
	// Sets the date to the current day when the month is created. 
	public costMonth() {
		setDate = theDate.returnDate();
		setDay = theDate.returnDay();
		setMonth = theDate.returnMonth();
		setYear = theDate.returnYear();
		lastCheckDate = theDate.returnDate();
		
	}
	
	
	public void saveAt(String fileLocation, int savings) {
		// Add category save load here.
		
	}
	
	public void loadAt(String fileLocation) {
		// add loading in category here.
	}
	
	// Used for automated checking if this date has already been used. Will be used in costYear.
	public void setCheck() {
		dateCheck++;
	}
	// Used for checking if this month has been used. 
	public int returnCheck() {
		return dateCheck;
	}
	
	
	// Create a new expense in the monthExpenses object.
	public void newExpense(String newName, double newValue, String newCategory) {
		monthExpenses.newExpense(newName, newValue, newCategory);
	}
	
	// Creates a new income in the monthIncome object. 
	
	public void newIncome(String newName, double newValue, double newLap) {
		monthIncome.newIncome(newName, newValue, newLap);
	}
	
	// Prints out an expense based on the string entered.
	public String findExpense(String Expense) {
		String returnExpenseName = monthExpenses.findExpenseNames(Expense);
		double returnExpenseCost = monthExpenses.findExpenseCost(Expense);
		String returnExpenseCategory = monthExpenses.findExpenseCategory(Expense);
		String newString = "The Expense is: " + returnExpenseName + " and the cost is " + returnExpenseCost + ", and the category is " + returnExpenseCategory + ". "; 
		return newString;
	}
	
	public String findExpenseCount(int Number) {
		String returnExpenseName = monthExpenses.returnExpenseName(Number);
		double returnExpenseCost = monthExpenses.returnExpenseValue(Number);
		String returnExpenseCategory = monthExpenses.returnExpenseCategory(Number);
		String newString = Number + 1 + ": " + returnExpenseName + " $" + returnExpenseCost + ", Category: " + returnExpenseCategory + ". "; 
		return newString;
	}
	public int findExpenseLength() {
		return monthExpenses.returnExpenseLength();
	}
	public int findIncomeLength() {
		return monthIncome.returnIncomeLength();
	}

	
	public String findIncome(String Income) {
		String returnIncomeName = monthIncome.findIncomeNames(Income);
		double returnIncomeValue = monthIncome.findIncomeCost(Income);
		double returnIncomeCycle = monthIncome.findIncomeLap(Income);
		String newString = returnIncomeName + " $" + returnIncomeValue + " and it pays out every " + returnIncomeCycle + " days.";
		return newString;
	}
	
	public String findIncomeCount(int Num) {
		String returnIncomeName = monthIncome.returnIncomeName(Num);
		double returnIncomeValue = monthIncome.returnIncomeValue(Num);
		double returnIncomeCycle = monthIncome.returnIncomeLap(Num);
		String newString = Num + 1 + ": " + returnIncomeName + " $" + returnIncomeValue + ", Cycle: " + returnIncomeCycle + " days.";
		return newString;
	}
	
	// Returns the balance of income and expenses calculated together as a double.
	public double getBalance() {
		double balance = monthIncome.returnTotalCost() - monthExpenses.returnTotalCost();
		return balance;
	}
	
	public double returnIncomeTotal() {
		return monthIncome.returnTotalCost();
	}
	
	public double returnExpenseTotal() {
		return monthExpenses.returnTotalCost();
	}
	
	
	public void setSetSavings(double newSavings) {
		savings.setSavings(newSavings);
	}
	
	public double getSetSavings() {
		return savings.getSavings();
	}
	

	
	public double checkSavings(Savings saving) {
		double save = saving.getSavings();
		double balance = getBalance();
		if (balance + save < 0) {
			return save + balance;
		} else if (balance < 0) {
			return save + balance;
		} else {
			return save;
		}
		
	}
	
	public Expense returnExpense() {
		return monthExpenses;
	}
	
	public Income returnIncome() {
		return monthIncome;
	}
	
	public ArrayList<String> incomeDisplay() {
		return monthIncome.returnDisplayedIncome();
	}
	
	public ArrayList<String> expenseDisplay() {
		return monthExpenses.returnDisplayed();
	}
	
	public void removeIncome(int x) {
		monthIncome.removeIncome(x);
	}
	
	public void removeExpense(int x){
		monthExpenses.expenseRemove(x);
	}
	
	public double calcSingleIncomingIncome(int a) {
		int x = 0;
		for (double z = theDate.remainderDays(); z > monthIncome.returnIncomeLap(a); z = z - monthIncome.returnIncomeLap(a)) {
			x += monthIncome.returnCostValue(a);
		}
		return x;
	}
	
	public double calcIncomingIncome() {
		int x = 0;
		
		for (int y = 0; y < monthIncome.returnIncomeLength(); y++) {
			x += calcSingleIncomingIncome(y);
		}
		
		return x;
	}
	
	
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
	
	public Expense getExpense() {
		return monthExpenses;
	}
	public Income getIncome() {
		return monthIncome;
	}
	
	public Savings getSaving() {
		return savings;
	}
	
	public void setExpense(Expense newExpense) {
		monthExpenses = newExpense;
	}
	public void setIncome(Income newIncome) {
		monthIncome = newIncome;
	}
	public void setSaving(Savings newSaving) {
		savings = newSaving;
	}
	
	
	public String getExpenseName(int x) {
		return monthExpenses.returnCostName(x);
	}
	
	public Double getExpenseValue(int x) {
		return monthExpenses.returnCostValue(x);
	}
	
	public String getExpenseCategory(int x) {
		return monthExpenses.returnExpenseCategory(x);
	}
	
	public String getIncomeName(int x) {
		return monthIncome.returnCostName(x);
	}
	
	public Double getIncomeValue(int x) {
		return monthIncome.returnIncomeValue(x);
	}
	
	public Double getIncomeLap(int x) {
		return monthIncome.returnIncomeLap(x);
	}
	
	public void refreshDisplayed() {
		monthIncome.refreshIncomeDisplay();
		monthExpenses.refreshExpenseDisplay();
	}
	
	
	
	}
	

