package MainPackage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class costYear {

	LocalDate checkDate = LocalDate.now();
	
	costMonth one,
	two,
	three,
	four,
	five,
	six,
	seven,
	eight,
	nine,
	ten,
	eleven,
	twelve,
	current = new costMonth();
	
	public costYear() {
		one = new costMonth();
		two = new costMonth();
		three = new costMonth();
		four = new costMonth();
		five = new costMonth();
		six = new costMonth();
		seven = new costMonth();
		eight = new costMonth();
		nine = new costMonth();
		ten = new costMonth();
		eleven = new costMonth();
		twelve = new costMonth();
	}
			  
	
	
	
	public void ChangeMonth() {
		switch (checkDate.getMonthValue()) {
		case 1:
			twelve = current;
			current = one;
			break;
		case 2:
			one = current;
			current = two;
			break;
		case 3:
			two = current;
			current = three;
			break;
		case 4:
			three = current;
			current = four;
			break;
		case 5:
			four = current;
			current = five;
			break;
		case 6:
			five = current;
			current = six;
			break;
		case 7:
			six = current;
			current = seven;
			break;
		case 8:
			seven = current;
			current = eight;
			break;
		case 9:
			eight = current;
			current = nine;
			break;
		case 10:
			nine = current;
			current = ten;
			break;
		case 11:
			ten = current;
			current = eleven;
			break;
		case 12:
			eleven = current;
			current = twelve;
			break;
		
		}
	}
	
	public void makeExpense(String newName, double newValue, String newCat) {
		current.newExpense(newName, newValue, newCat);
	}
	
	public String getExpense(String newExpense) {
		return current.findExpense(newExpense);
	}
	
	public void makeIncome(String newName, double newValue, double rot) {
		current.newIncome(newName, newValue, rot);
	}
	
	public String getIncome(String newIncome) {
		return current.findIncome(newIncome);
	}
	
	public String getExpenseCount(int Num) {
		return current.findExpenseCount(Num);
	}
	
	public String getIncomeCount(int Num) {
		return current.findIncomeCount(Num);
	}
	
	public int returnExpenseLength() {
		return current.findExpenseLength();
	}
	
	public int returnIncomeLength() {
		return current.findIncomeLength();
	}
	public double getSavings() {
		return current.getSavings();
	}
	public void setSavings(double Savings) {
		current.setSavings(Savings);
	}
}
