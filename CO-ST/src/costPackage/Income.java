package costPackage;
import java.util.ArrayList;

// Income, extends from BaseCash.
public class Income extends BaseCash {
	
	// totalIncomeLap refers to the time between pay.
	ArrayList<Double> totalIncomeLap = new ArrayList<Double>();
	// calcIncome is the total monthly value the income provides. 
	ArrayList<Double> calcIncome = new ArrayList<Double>();
	
	// Adds a new income, with a name, double cost, and an incomeLap for calculating monthly pay.
	public void newIncome(String newName, double newCost, double newIncomeLap) {
		this.setBase(newCost, newName);
		totalIncomeLap.add(newIncomeLap);
		this.setDisplayed(totalIncomeLap.size() + ": " + newName + ": $" + newCost + ", pays every " + newIncomeLap + " days.");
		calcSingleTotalIncome(newIncomeLap, newCost);
	}
		
	// Calculates the total income the set value would make in a 30 day month, by subtracting lap from 30 until it is smaller than a lap.
	public void calcSingleTotalIncome(double lap, double value) {
		double x = 0;
		for (double z = 30; z > lap; z = z - lap) {
			x += value;
		}
		calcIncome.add(x);
	}
	
	// Returns the monthly income at index x.
	public double getTotal(int x) {
		return calcIncome.get(x);
	}
	
	// Removes the income at index x from all arrays. 
	public void removeIncome(int x) {
		this.removeAt(x);
		totalIncomeLap.remove(x);
		calcIncome.remove(x);
	}
	
	// Refer to returnCostValue at BaseCash.
	public double returnIncomeValue(int Where) {
		return super.returnCostValue(Where);
	}
	
	// Refer to returnCostName at BaseCash.
	public String returnIncomeName(int Where) {
		return super.returnCostName(Where);
	}
	
	// Returns the income lap at index X.
	public Double returnIncomeLap(int What) {
		return totalIncomeLap.get(What);
	}
	
	// Returns the length of the income arrays by using the totalIncomeLap array.
	public int returnIncomeLength() {
		return totalIncomeLap.size();
	}
	
	// Returns the displayed income, unless the display is less than zero, than it displays nothing. 
	public ArrayList<String> returnDisplayedIncome() {
		ArrayList<String> secondArray = new ArrayList<String>();
		if (this.displayedLength() > 0) {
		return this.returnDisplayed();
		} else {
			return secondArray;
		}
	}
	
}
