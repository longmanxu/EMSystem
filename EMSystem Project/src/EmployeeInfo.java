
import java.io.Serializable;

/**
 * An object for storing an employee's first name, last name, employee number, sex, work location, and deductions rate.
 * @author Longman Xu and Tommy Huang
 * @version Date: 2018-06-19
 * 
 */
abstract public class EmployeeInfo implements Serializable {
	
	// the contents of the EmployeeInfo object
	private int employeeNumber;
	private String firstName;
	private String lastName;
	private int sex; // 0 is male, 1 is female, 2 is other
	private int workLocation;
	protected double deductionsRate; // between 0.0 and 1.0.
	
	/**
	 * Constructs a new EmployeeInfo object.	
	 * @param employeeNumber the employee number (a non-negative integer).
	 * @param firstName the first name.
	 * @param lastName the last name.
	 * @param sex the sex (0 is male, 1 is female, 2 is other).
	 * @param workLocation the work location, represented as a non-negative integer.
	 * @param deductionsRate the deductions rate (between 0.0 and 1.0).
	 * @throws IllegalArgumentException if any given argument is invalid.
	 */
	public EmployeeInfo(int employeeNumber, String firstName, String lastName, int sex, int workLocation,
			double deductionsRate) {
		// check for illegal parameters
		if (employeeNumber < 0) {
			throw new IllegalArgumentException("The employee number should be a non-negative integer.");
		}
		else if (firstName.contains("~")) {
			throw new IllegalArgumentException("The first name may not contain '~'");
		}
		else if (lastName.contains("~")) {
			throw new IllegalArgumentException("The last name may not contain '~'");
		}
		else if (sex < 0 || sex > 2) {
			throw new IllegalArgumentException("The sex should be 0 (male), 1 (female), or 2 (other).");
		}
		else if (workLocation < 0) {
			throw new IllegalArgumentException("The work locations should be a non-negative integer");
		}
		else if (deductionsRate < 0 || deductionsRate > 1) {
			throw new IllegalArgumentException("The deductions rate should be between 0.0 and 1.0");
		}
		else {
			this.employeeNumber = employeeNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.sex = sex;
			this.workLocation = workLocation;
			this.deductionsRate = deductionsRate;
		}
	}

	/**
	 * Converts the EmployeeInfo object into a legible string.
	 * @return a string representation of the EmployeeInfo.
	 */
	@Override
	public String toString() {
		return Integer.toString(this.employeeNumber) + ", " + this.firstName + " " + this.lastName;
	}
	
	/**
	 * Gets the employee number.
	 * @return the employee number.
	 */
	public int getEmployeeNumber() {
		return this.employeeNumber;
	}
	
	/**
	 * Sets the employee number.
	 * @param employeeNumber the employee number.
	 * @throws IllegalArgumentException if the employee number is not a non-negative integer.
	 */
	public void setEmployeeNumber(int employeeNumber) {
		if (employeeNumber >= 0) {
			this.employeeNumber = employeeNumber;
		}
		else {
			throw new IllegalArgumentException("The employee number should be a non-negative integer.");
		}
	}
	
	/**
	 * Gets the first name.
	 * @return the first name.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Sets the first name.
	 * @param firstName the first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 * @return the last name.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Sets the last name.
	 * @param lastName the last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the sex (0 is male, 1 is female, 2 is other).
	 * @return the sex (0 is male, 1 is female, 2 is other).
	 */
	public int getSex() {
		return sex;
	}
	
	/**
	 * Gets the sex as a string.
	 * @return the sex.
	 */
	public String getSexString() {
		switch (sex) {
			case 0:
				return "Male";
			case 1:
				return "Female";
			default: return "Other";
		}
	}

	/**
	 * Sets the sex (0 is male, 1 is female, 2 is other).
	 * @param sex the sex (0 is male, 1 is female, 2 is other).
	 * @throws IllegalArgumentException if the sex is not 0, 1, or 2.
	 */
	public void setSex(int sex) {
		if (sex >= 0 && sex <= 2) {
			this.sex = sex;
		}
		else {
			throw new IllegalArgumentException("The sex should be 0, 1, or 2.");
		}
	}

	/**
	 * Gets the work location.
	 * @return the work location.
	 */
	public int getWorkLocation() {
		return workLocation;
	}

	/**
	 * Sets the work location.
	 * @param workLocation the work location.
	 * @throws IllegalArgumentException if the work location is not a non-negative integer.
	 */
	public void setWorkLocation(int workLocation) {
		if (workLocation >= 0) {
			this.workLocation = workLocation;
		}
		else {
			throw new IllegalArgumentException("The work locations should be a non-negative integer");
		}
	}

	/**
	 * Gets the deductions rate (between 0.0 and 1.0).
	 * @return the deductions rate.
	 */
	public double getDeductionsRate() {
		return deductionsRate;
	}

	/**
	 * Sets the deductions rate (between 0.0 and 1.0).
	 * @param deductionsRate the deductions rate.
	 * @throws IllegalArgumentException if the deductions rate is not between 0.0 and 1.0.
	 */
	public void setDeductionsRate(double deductionsRate) {
		if (deductionsRate >= 0 && deductionsRate <= 1) {
			this.deductionsRate = deductionsRate;
		}
		else {
			throw new IllegalArgumentException("The deductions rate should be between 0.0 and 1.0");
		}
	}
	
	
	/**
	 * Calculate the employee's annual gross income. To be overridden by subclasses.
	 * @return the employee's annual gross income.
	 */
	abstract public double calcAnnualGrossIncome();
	
	/**
	 * Calculate the employee's annual net income. To be overridden by subclasses.
	 * @return the employee's annual net income.
	 */
	abstract public double calcAnnualNetIncome();
	
}
