/*
 * The base class for the Expense and Income class. Used to set and collect the values of both classes. 
 * 
 * Provides three array lists ; totalCost and totalCostNames keeps the names and costs of the class, while displayedCost provides a string that is used for displaying the values in lists.s
 * 
 */



package costPackage;
import java.util.ArrayList;

// Sets up a base Class for both the Expense and Income classes. 
// Provides many of the base methods both classes use.

public class BaseCash {
	/* totalCost and totalCostNames are used to store the variables for the expenses and income. They are stored
	 * at the same time to ensure they are the same. 
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
	
	// Returns the name of 
	public String getCostName(String name) {
		return totalCostNames.get(findCostNamesLocation(name));
	}
	
	public double getCost(String name) {
		return totalCost.get(findCostNamesLocation(name));
	}
	
	// Returns the TotalCostName value of the array at int Where.
	public String returnCostName(int Where) {
		return totalCostNames.get(Where);
	}
	
	public String returnDisplayed(int Where) {
		return displayedCost.get(Where);
	}
	
	public int returnLength() {
		return totalCost.size();
	}
	
	
	public void setDisplayed(String one) {
		displayedCost.add(one);
	}
	
	public ArrayList<String> returnDisplayed() {
		return displayedCost;
	}
	

	
	public int displayedLength() {
		return displayedCost.size();
	}
	
	// Finds a variable in the array by searching for it's name. Will return 999 if not found - needs to be changed.
	
	public int findCostNamesLocation(String What) {
		if (totalCostNames.size() == 0) {
			return 0;
		}
		
		for (int i = 0; i < totalCostNames.size() - 1; i++) {
			if (this.returnCostName(i).equalsIgnoreCase(What)) {
				return i;
			}
				
			}
		return 0;
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

