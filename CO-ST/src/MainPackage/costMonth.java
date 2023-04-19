package MainPackage;
// LocalDate and Month will be used to help keep track of the current date - useful for income calculations, and knowing what month it is in general. 

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import costPackage.Expense;
import costPackage.Income;
import costPackage.Savings;
import timePackage.costDate;


public class costMonth {
	
	
	// The Expense, Income, and theDate objects required to make costMonth work. Refer to classes for how they work.
	Expense monthExpenses = new Expense();
	Income monthIncome = new Income();
	costDate theDate = new costDate();
	category sorting = new category();
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
		double returnIncomeCycle = monthIncome.countIncomeLap(Num);
		String newString = Num + 1 + ": " + returnIncomeName + " $" + returnIncomeValue + ", Cycle: " + returnIncomeCycle + " days.";
		return newString;
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
	
	public void showDate() {
		System.out.println(setDate);
	}
	
	public void setSavings(double newSavings) {
		savings.setSavings(newSavings);
	}
	
	public double getSavings() {
		return savings.getSavings();
	}
	
	public void categorySave(String what) {
		sorting.chooseCategory(monthExpenses.returnExpenseCategory(monthExpenses.findExpenseNamesLocation(what)));
		
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
		for (double z = theDate.remainderDays(); z > monthIncome.countIncomeLap(a); z = z - monthIncome.countIncomeLap(a)) {
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
	
	
	
	}
	/*
	
	// Provides a start up that the month will have. Temporary.
	public void startUp() {
		System.out.println("Welcome to the CO-ST Financial Manager!");
		System.out.println("The date is " + setDate + " and it is " + setTime + ". ");
		this.demoStart();
	}
	// Shows off what is done so far in a fun matter. Will be removed.
	public void demoStart() {
		System.out.println("This demo will show you the current features of our product!");
		Scanner newScan = new Scanner(System.in);
		System.out.println("Please provide the name of your job, or income stream!");
		String newJob = newScan.nextLine();
		System.out.println("Wonderful! Please provide the amount of money you make from that income!");
		double newValue = newScan.nextDouble();
		System.out.println("Great! Lastly, please provide the amount of days between each pay cycle, via a numerical value!");
		double newCycle = newScan.nextDouble();
		this.newIncome(newJob, newValue, newCycle);
		findIncome(newJob);
		newScan.nextLine();
		System.out.println();
		System.out.println("Now, let's now make an expense!");
		System.out.println("Please provide the name of the expense.");
		String newExpense = newScan.nextLine();
		System.out.println("Please provide the cost of the expense!");
		double newExpenseValue = newScan.nextDouble();
		newScan.nextLine();
		System.out.println("Lastly, please provide the category of the expense, between these five choices; ");
		System.out.println("housing, utilities, groceries, personal, entertainment");
		String newExpenseCategory = newScan.nextLine();
		this.newExpense(newExpense, newExpenseValue, newExpenseCategory);
		this.findExpense(newExpense);
		System.out.println();
		System.out.println("Let's now check our balance!");
		this.showBalance();
		System.out.println();
		
	}
	
	*/


