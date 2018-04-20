/**
 * A subclass of EmployeeInfo for part time employees.
 * Stores the employee's hourly wage, hours worked per week, and weeks worked per year.
 * @author Longman Xu
 * @version 2018-04-04
 *
 */
public class PartTimeEmployee extends EmployeeInfo{
	
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
		// call constructor of EmployeeInfo superclass
		super(employeeNumber, firstName, lastName, sex, workLocation, deductionsRate);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
		this.weeksPerYear = weeksPerYear;
	}
	
	/**
	 * Calculate the part time employee's annual gross income.
	 * @return the employee's annual gross income.
	 */
	public double calcAnnualGrossIncome() {
		return(this.hourlyWage * this.hoursPerWeek * this.weeksPerYear);
	}
	
	/**
	 * Calculate the part time employee's annual net income.
	 * @return the employee's annual net income.
	 */
	public double calcAnnualNetIncome() {
		return(calcAnnualGrossIncome() * (1 - this.deductionsRate));
	}

}
