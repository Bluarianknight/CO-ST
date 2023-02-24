
// Attempting to test Expenses.
public class exampleClass {

	public static void main(String[] Args) {
		// Sets up a new calculations for calculating expenses, and sets two expenses to return the total expense. Works.
		calculations Calc = new calculations();
		Expense Car = new Expense();
		Car.setName("Car");
		Car.setValue(12.0);
		
		Expense Cat = new Expense();
		Cat.setName("Cat");
		Cat.setValue(55.0);
		
		Calc.inputExpense(Cat);
		Calc.inputExpense(Car);
		System.out.println(Calc.returnTotalExpense());
		
	}
	
	
	


}
