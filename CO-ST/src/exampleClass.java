
// Attempting to test Expenses.
public class exampleClass {

	public static void main(String[] Args) {
		// Sets up a new calculations for calculating expenses, and sets two expenses to return the total expense. Works.
		costMonth newMonth = new costMonth();
		
		newMonth.newExpense("Cat", 25.00);
		newMonth.newExpense("Car", 550.00);
		
		newMonth.newIncome("Doordash", 55, 7);
		
		newMonth.findExpense("Car");
		newMonth.showBalance();
		
	}
	
	
	


}
