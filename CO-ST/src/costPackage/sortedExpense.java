
/*
 * This class was made to help sort expenses - due to Expense's variables being between BaseCash and itself, it became easier to simply create a new class for this.
 */


package costPackage;

// The class contains the four variables of Expense in one location.
public class sortedExpense implements Comparable<sortedExpense> {
	private double totalCost;
	private String totalCostNames;
	private String displayedCost; 
	private String category;
	
	public sortedExpense(String newName, double newCost,  String newDisplay, String newCategory) {
		totalCost = newCost;
		totalCostNames = newName;
		displayedCost = newName + ": $" + newCost; 
		category = newCategory;
}
	
	// Sets the displayedCost of the sortedExpense properly for sortExpenses() in mainClass.
	public void sortDisplay(int i){
		displayedCost = i + ": " + totalCostNames + ": $" + totalCost;
	}
	// Returns the displayedCost as a string.
	public String returnDisplay() {
		return displayedCost;
	}
	// Returns the totalCost as a double.
	public double returnCost() {
		return totalCost;
	}
	// Returns the category as a String.
	public String returnCategory() {
		return category;
	}

	@Override
	// Sets to compare by totalCost.
	public int compareTo(sortedExpense other) {
		sortedExpense newExpense = other;
		return Double.compare(totalCost, newExpense.returnCost());
	}
}
