// LocalDate and Month will be used to help keep track of the current date - useful for income calculations, and knowing what month it is in general. 

import java.time.LocalDate;
import java.time.Month;

public class costMonth {
	
	
	// The Expense, Income, and theDate objects required to make costMonth work. Refer to classes for how they work.
	Expense monthExpenses = new Expense();
	Income monthIncome = new Income();
	costDate theDate = new costDate();
	
	// Set values for use in dates.
	LocalDate setDate;
	int setDay;
	Month setMonth;
	int setYear;
	
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
	
	// Create a new expense in the monthExpenses object.
	public void newExpense(String newName, double newValue) {
		monthExpenses.newExpense(newName, newValue);
	}
	
	// Creates a new income in the monthIncome object. 
	
	public void newIncome(String newName, double newValue, double newLap) {
		monthIncome.newIncome(newName, newValue, newLap);
	}
	
	// Prints out an expense based on the string entered.
	public void findExpense(String Expense) {
		String returnExpenseName = monthExpenses.findExpenseNames(Expense);
		double returnExpenseCost = monthExpenses.findExpenseCost(Expense);
		System.out.println("The Expense is: " + returnExpenseName + " and the cost is " + returnExpenseCost + ". "); 
	}
	
	// Returns the balance of income and expenses calculated together as a double.
	public double getBalance() {
		double balance = monthIncome.returnTotalCost() - monthExpenses.returnTotalCost();
		return balance;
	}
	
	// Prints out the balance. 
	public void showBalance() {
		System.out.println("The balance is currently: $" + getBalance());
	}
	
	
	

}
