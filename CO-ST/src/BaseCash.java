

// Sets up a base Class for use for income, expenses, and so forth.
public class BaseCash {
	String name;
	Double value;
	
	public BaseCash() {
		name = "Error Expense";
		value = 6969.69;
		
	}
	
	// Sets the value of the expense based on a newName string and newValue double.
	public BaseCash(String newName, double newValue) {
		name = newName;
		value = newValue;
	} 
	// Sets the value of the class.
	public void setValue(double newValue) {
		value = newValue;
	}
	// Sets the name of the class.
	public void setName(String newName) {
		name = newName;
	}
	
	// Returns the value of baseCash.
	public double returnValue() {
		return value;
	}
	// Returns the name of the baseCash.
	public String returnName() {
		return name;
	}
}

