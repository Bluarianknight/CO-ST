package costPackage;
import java.util.ArrayList;

// Income, extends from BaseCash.
public class Income extends BaseCash {
	
	// Name may change - refers to time between paychecks. 
	ArrayList<Double> totalIncomeLap = new ArrayList<Double>();
	
	// Adds a new income, with a name, double cost, and an incomeLap for calculating monthly pay.
	public void newIncome(String newName, double newCost, double newIncomeLap) {
		this.setBase(newCost, newName);
		totalIncomeLap.add(newIncomeLap);
		this.setDisplayed(totalIncomeLap.size() + ": " + newName + ": $" + newCost + ", pays every " + newIncomeLap + " days.");
	}
	
	public void removeIncome(int x) {
		System.out.println(x);
		this.removeAt(x);
		totalIncomeLap.remove(x);
	}
	
	// Refer to returnCostValue at BaseCash.
	public double returnIncomeValue(int Where) {
		return super.returnCostValue(Where);
	}
	
	// Refer to returnCostName at BaseCash.
	public String returnIncomeName(int Where) {
		return super.returnCostName(Where);
	}
	
	// refer to findCostNamesLocation at BaseCash.
	public int findIncomeNamesLocation(String What) {
			return findCostNamesLocation(What);
	}
	
	// Returns the name of a value if it exists. It only exists for use for findExpense in costMonth.
	public String findIncomeNames(String What) {
		return this.getCostName(What);	
	}
	
	// Returns the income value if What equals a name of an income. 
	public Double findIncomeCost(String What) {
		return this.getCost(What);
	}
	
	// Returns the IncomeLap if What == an income name. 
	public Double findIncomeLap(String What) {
		return totalIncomeLap.get(findIncomeNamesLocation(What));
	}
	
	public Double returnIncomeLap(int What) {
		return totalIncomeLap.get(What);
	}
	
	public int returnIncomeLength() {
		return totalIncomeLap.size();
	}
	
	public ArrayList<String> returnDisplayedIncome() {
		ArrayList<String> secondArray = new ArrayList<String>();
		if (this.displayedLength() > 0) {
		return this.returnDisplayed();
		} else {
			return secondArray;
		}
	}
	
}
