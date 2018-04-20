/**
 * A subclass of EmployeeInfo for full time employees. Stores the employee's yearly salary.
 * @author Longman Xu
 * @version 2018-04-04
 *
 */
public class FullTimeEmployee extends EmployeeInfo{
	
	// the FullTimeEmployee's annual salary
	protected double yearlySalary;
	
	
	/**
	 * Constructs a new FullTimeEmployee object.
	 * @param employeeNumber the employee number.
	 * @param firstName the first name.
	 * @param lastName the last name.
	 * @param sex the sex (0 is male, 1 is female, 2 is other).
	 * @param workLocation the work location.
	 * @param deductionsRate the deductions rate (between 0.0 and 1.0).
	 * @param yearlySalary the annual salary.
	 */
	public FullTimeEmployee(int employeeNumber, String firstName, String lastName, int sex, int workLocation,
			double deductionsRate, double yearlySalary) {
		// call constructor of EmployeeInfo superclass
		super(employeeNumber, firstName, lastName, sex, workLocation, deductionsRate);
		this.yearlySalary = yearlySalary;
	}
	
	/**
	 * Calculate the part time employee's annual gross income.
	 * @return the employee's annual gross income.
	 */
	public double calcAnnualGrossIncome() {
		return(this.yearlySalary);
	}
	
	/**
	 * Calculate the part time employee's annual net income.
	 * @return the employee's annual net income.
	 */
	public double calcAnnualNetIncome() {
		return(this.yearlySalary * (1 - this.deductionsRate));
	}

}
