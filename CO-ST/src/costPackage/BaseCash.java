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
	
	public void removeAt(int x) {
		totalCost.remove(x);
		totalCostNames.remove(x);
		displayedCost.remove(x);
	}
	
	public void setBase(double newCost, String newName) {
		totalCost.add(newCost);
		totalCostNames.add(newName);
	}
	
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
	
	
	public void setDisplayed(String one) {
		displayedCost.add(one);
		System.out.println(displayedCost);
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

