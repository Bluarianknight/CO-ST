package costPackage;
import java.util.ArrayList;

/*
 * A class made to handle expenses. Has four array lists, three extended from baseCash.
 * a name array, a cost value array, a displayName array, and a category Array, that handles the category of the expense.
 * 
 */

public class Expense extends BaseCash {
	// expenseCategory - Sorts the expenses into various categories. 
	private ArrayList<String> expenseCategory = new ArrayList<String>();
	
	public Expense (){
		
	}
	// Adds a new expense, taking a String and double value for cost, and a String for the category. It then converts this into the displayed value.
	public void newExpense(String newName, double newCost, String newCategory) {
		this.setBase(newCost, newName);
		setCategory(newCategory);
		this.setDisplayed(expenseCategory.size() + ": " + newName +  " - $" + newCost + " - category: " + newCategory);
	}
	
	
	
	// Returns the variable of CostValue at Where.
	public double returnExpenseValue(int Where) {
		return super.returnCostValue(Where);
	}
	
	// Removes from all arrays at index x.
	public void expenseRemove(int x) {
		this.removeAt(x);
		expenseCategory.remove(x);
	}
	
	// Returns the variable of CostName at Where. 
	public String returnExpenseName(int Where) {
		return super.returnCostName(Where);
	}
	
	// Returns the displayed String at index Where.
	public String returnDisplayed(int Where) {
		return super.returnDisplayed(Where);
	}
	
	// Returns the category as a string at index Where.
	public String returnExpenseCategory(int Where) {
		return expenseCategory.get(Where);
	}
	
	// Returns the length of the expense arrays.
	public int returnExpenseLength() {
		return this.returnLength();
	}
	
	
	// Sets the category between six values. If it cannot be read, it defaults to "other".
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
			expenseCategory.add("other");
			break;
		}
	}
	
	
}