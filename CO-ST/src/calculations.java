

import java.util.ArrayList; // Used for ArrayLists, for dynamic calculations. 
import java.util.Collections; // Going to be used for sorting later on. 

public class calculations {
	// Sets arrays to input expenses into.
	ArrayList<Double> totalExpenses = new ArrayList<Double>();
	ArrayList<String> totalExpensesNames = new ArrayList<String>();
	
	public calculations() {
		
	}
	
	// Sets an expense from a set Expense value. Look at BaseCash for how to set one, as it basically imports it.
	public void inputExpense(Expense newExpense) {
		totalExpensesNames.add(newExpense.returnName());
		totalExpenses.add(newExpense.returnValue());
	}
	// Returns the total expenses added up.
	public double returnTotalExpense() {
		double total = 0.0;
		for (int x = 0; x < totalExpenses.size(); x++) {
			total += totalExpenses.get(x);
			
		}
		return total;
	}
	
	
}
	
