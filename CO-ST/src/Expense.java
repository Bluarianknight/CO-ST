import java.util.ArrayList;

// Expense class made for expenses. Used BaseCash method for most of it - many of the methods are simply BaseCash methods but renamed, or tweaked.
public class Expense extends BaseCash {
	// expenseCategory - to help sort the expenses. Not implemented fully currently.
	ArrayList<String> expenseCategory = new ArrayList<String>();
	
	public Expense (){
		
	}
	// Adds a new expense, taking a String and double value for cost and name.
	public void newExpense(String newName, double newCost, String newCategory) {
		totalCost.add(newCost);
		totalCostNames.add(newName);
		setCategory(newCategory);
	}
	
	// Returns the variable of CostValue at Where.
	public double returnExpenseValue(int Where) {
		return super.returnCostValue(Where);
	}
	
	// Returns the variable of CostName at Where. 
	public String returnExpenseName(int Where) {
		return super.returnCostName(Where);
	}
	
	public String returnExpenseCategory(int Where) {
		return expenseCategory.get(Where);
	}
	
	// Uses findCostNamesLocation, refer to BaseCash for documentation.
	public int findExpenseNamesLocation(String What) {
			return findCostNamesLocation(What);
	}
	
	// Returns the name of a value if it exists. It only exists for use for findExpense in costMonth.
	public String findExpenseNames(String What) {
		return totalCostNames.get(findExpenseNamesLocation(What));
	}
	
	// Returns the cost of the String What if it exists as an expense. 
	public Double findExpenseCost(String What) {
		return totalCost.get(findExpenseNamesLocation(What));
	}
	
	// Returns the category of an expense if it exists.
	public String findExpenseCategory(String What) {
		return expenseCategory.get(findExpenseNamesLocation(What));
	}
	
	// Sets the category. 
	public void setCategory(String newCategory) {
		switch (newCategory.toLowerCase()) {
		case "housing":
			
		case "utilities":
			
		case "groceries":
			
		case "personal":
		
		case "entertainment":

		case "other":
			expenseCategory.add(newCategory.toLowerCase());
			break;
		
		default:
			System.out.println("System cannot categorize. Error.");
			expenseCategory.add("ERROR");
			break;
		}
	}
	
	
}