/**
 * A subclass of EmployeeInfo for part time employees.
 * Stores the employee's hourly wage, hours worked per week, and weeks worked per year.
 * @author Longman Xu and Tommy Huang
 * @version 2018-06-19
 *
 */
public class PartTimeEmployee extends EmployeeInfo {
	
	// added contents of the PartTimeEmployee object for calculating income
	private double hourlyWage;
	private double hoursPerWeek;
	private double weeksPerYear;
	
	/**
	 * Constructs a new PartTumeEmployee object.
	 * @param employeeNumber the employee number.
	 * @param firstName the first name.
	 * @param lastName the last name.
	 * @param sex the sex (0 is male, 1 is female, 2 is other).
	 * @param workLocation the work location.
	 * @param deductionsRate the deductions rate (between 0.0 and 1.0).
	 * @param hourlyWage the hourly wage.
	 * @param hoursPerWeek the number of hours worked per week.
	 * @param weeksPerYear the number of weeks worked per year.
	 */
	public PartTimeEmployee(int employeeNumber, String firstName, String lastName, int sex, int workLocation,
			double deductionsRate, double hourlyWage, double hoursPerWeek, double weeksPerYear) {
		super(employeeNumber, firstName, lastName, sex, workLocation, deductionsRate);
		if (hourlyWage < 0) {
			throw new IllegalArgumentException("The hourly wage should be greater than 0.");
		}
		else if (hoursPerWeek < 0 || hoursPerWeek > 168) {
			throw new IllegalArgumentException("The hours worked per week should be between 0 and 168.");
		}
		else if (weeksPerYear < 0 || weeksPerYear > 365/7) {
			throw new IllegalArgumentException("The weeks worked per year should be between 0 and 365/7");
		}
		// call constructor of EmployeeInfo superclass
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
		this.weeksPerYear = weeksPerYear;
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public double getWeeksPerYear() {
		return weeksPerYear;
	}

	public void setWeeksPerYear(double weeksPerYear) {
		this.weeksPerYear = weeksPerYear;
	}
	
	/**
	 * Calculate the part time employee's annual gross income.
	 * @return the employee's annual gross income.
	 */
	@Override
	public double calcAnnualGrossIncome() {
		double result = this.hourlyWage * this.hoursPerWeek * this.weeksPerYear;
		return ((double) Math.round(result * 100))/100.0;
	}
	
	/**
	 * Calculate the part time employee's annual net income.
	 * @return the employee's annual net income.
	 */
	@Override
	public double calcAnnualNetIncome() {
		double result = calcAnnualGrossIncome() * (1 - this.deductionsRate);
		return ((double) Math.round(result * 100))/100.0;
	}

}
