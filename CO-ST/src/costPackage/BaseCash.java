/*
 * The base class for the Expense and Income class. Used to set and collect the values of both classes. 
 * 
 * Provides three array lists ; totalCost and totalCostNames keeps the names and costs of the class, while displayedCost provides a string that is used for displaying the values in lists.
 * 
 */



package costPackage;
import java.util.ArrayList;

// Sets up a base Class for both the Expense and Income classes. 
// Provides many of the base methods both classes use.

public class BaseCash {
	/* totalCost and totalCostNames are used to store the variables for the expenses and income. They are stored
	 * at the same time to ensure they are the same. 
	 * As well, displayedCost is used to display out to the graphical interface, and is contained as a string.
	*/
	private ArrayList<Double> totalCost = new ArrayList<Double>();
	private ArrayList<String> totalCostNames = new ArrayList<String>();
	public ArrayList<String> displayedCost = new ArrayList<String>();
	
	
	// Returns the TotalCost value of the array at int Where. 
	public double returnCostValue(int Where) {
		return totalCost.get(Where);
	}
	
	// Remove a value from all arrays at index x. Used for removing expense/income.
	public void removeAt(int x) {
		totalCost.remove(x);
		totalCostNames.remove(x);
		displayedCost.remove(x);
	}
	// Used to set the cost and name for child classes. 
	public void setBase(double newCost, String newName) {
		totalCost.add(newCost);
		totalCostNames.add(newName);
	}

	
	// Returns the TotalCostName value of the array at int Where.
	public String returnCostName(int Where) {
		return totalCostNames.get(Where);
	}
	
	// Returns the displayedCost array list at int Where.
	public String returnDisplayed(int Where) {
		return displayedCost.get(Where);
	}
	
	// Returns the array length of totalCost.
	public int returnLength() {
		return totalCost.size();
	}
	
	// Adds to the displayedCost array, and used in creation of income and expenses.
	public void setDisplayed(String one) {
		displayedCost.add(one);
	}
	
	// Returns the entire displayedCost arrayList.
	public ArrayList<String> returnDisplayed() {
		return displayedCost;
	}
	

	// Returns the size of displayedCost.
	public int displayedLength() {
		return displayedCost.size();
	}
	
	
	// Returns the size of an array. Used for testing.
	public int returnSize() {
		return totalCostNames.size();
	}
	
	// Returns the total value of the entire array. Used for calculating balance in costMonth.
	public double returnTotalCost() {
		double total = 0.0;
		for (int x = 0; x < totalCost.size(); x++) {
			total += totalCost.get(x);
			
		}
		return total;
	}
}

