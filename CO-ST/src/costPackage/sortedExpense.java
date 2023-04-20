package costPackage;


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
	
	public void sortDisplay(int i){
		displayedCost = i + ": " + totalCostNames + ": $" + totalCost;
	}
	public String returnDisplay() {
		return displayedCost;
	}
	
	public double returnCost() {
		return totalCost;
	}

	@Override
	public int compareTo(sortedExpense other) {
		sortedExpense newExpense = other;
		return Double.compare(totalCost, newExpense.returnCost());
	}
}
