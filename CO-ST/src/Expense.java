import java.util.ArrayList;

// Expense class made for expenses. Used BaseCash method for most of it - many of the methods are simply BaseCash methods but renamed, or tweaked.
public class Expense extends BaseCash {
	// expenseCategory - to help sort the expenses. Not implemented fully currently.
	ArrayList<String> expenseCategory = new ArrayList<String>();
	
	public Expense (){
		
	}
	// Adds a new expense, taking a String and double value for cost and name.
	public void newExpense(String newName, double newCost) {
		totalCost.add(newCost);
		totalCostNames.add(newName);
	}
	
	// Returns the variable of CostValue at Where.
	public double returnExpenseValue(int Where) {
		return super.returnCostValue(Where);
	}
	
	// Returns the variable of CostName at Where. 
	public String returnExpenseName(int Where) {
		return super.returnCostName(Where);
	}
	
	// Uses findCostNamesLocation, refer to BaseCash for documentation.
	public int findExpenseNamesLocation(String What) {
			return findCostNamesLocation(What);
	}
	
	// Returns the name of a value if it exists. Unsure why this exists.
	public String findExpenseNames(String What) {
		return totalCostNames.get(findExpenseNamesLocation(What));
	}
	
	// Returns the cost of the String What if it exists as an expense. 
	public Double findExpenseCost(String What) {
		return totalCost.get(findExpenseNamesLocation(What));
	}
	
	
}