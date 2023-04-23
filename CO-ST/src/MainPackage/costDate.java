
/*
 * This class was originally going to manage the various classes that would keep track of the date, calculate month-by-month investment, and so forth. But due to time constraints, 
 * the only real use of this class is to provide the days left within the month, to calculate income to be recieved.
 */


package MainPackage;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;


// To be used to keep track of the days.
public class costDate {

	// Sets dates for the actual date, day, month, and year, in value.
	LocalDate currentDate = LocalDate.now();
	
	int currentDay = currentDate.getDayOfMonth();
	Month currentMonth = currentDate.getMonth();
	int currentYear = currentDate.getYear();
	YearMonth currentYearMonth = YearMonth.now();

	
	
	// All methods below return the variables above. 
	public LocalDate returnDate() {
		return currentDate;
	}
	
	public int returnDay() {
		return currentDay;
	}
	
	public Month returnMonth() {
		return currentMonth;
	}
	
	public int returnYear() {
		return currentYear;
	}
	 
	// Checks the amount of days left in a month. 
	public int remainderDays() {
		int length = currentYearMonth.lengthOfMonth();
		int days = currentDay;
		
		return length - days;
		
	}
}
