import java.time.LocalDate;
import java.time.Month;
// To be used to keep track of the days.
public class costDate {

	// Sets dates for the actual date, day, month, and year, in value.
	LocalDate currentDate = LocalDate.now();
	int currentDay = currentDate.getDayOfMonth();
	Month currentMonth = currentDate.getMonth();
	int currentYear = currentDate.getYear();
	
	
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
}