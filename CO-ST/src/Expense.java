

// Expense class made for expenses. 
public class Expense {
	String name;
	double value;
	
	
	// Default Expense for debugging purposes. Value set for humorous and also for a noticable mark - if 6969 pops up in expenses, it shows that someone messed up somewhere.
	public Expense() {
		name = "Error Expense";
		value = 6969;
		
	}
	
	// Sets the value of the expense based on a newName string and newValue double.
	public Expense(String newName, double newValue) {
		name = newName;
		value = newValue;
	} 
	// Returns the value of the expense.
	public double returnValue() {
		return value;
	}
	// Returns the name of the expense.
	public String returnName() {
		return name;
	}
}
