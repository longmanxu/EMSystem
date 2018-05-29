
import java.io.*;
import java.util.ArrayList;

/**
 * A subclass of ArrayList&lt;EmployeeInfo&gt; which provides sorting algorithms for the EmployeeInfo elements.
 * @author longm
 * @version 2018-05-28
 */
public class EmployeeArrayList extends ArrayList<EmployeeInfo> {
	/**
	 * Construct a new EmployeeArrayList.
	 */
	public EmployeeArrayList() {
		super();
	}
	
	/**
	 * Construct a new EmployeeArraylist from an ArrayList&lt;EmployeeInfo&gt;.
	 * @param originalList the ArrayList&lt;EmployeeInfo&gt; to be created from.
	 */
	public EmployeeArrayList(ArrayList<EmployeeInfo> originalList) {
		super(originalList);
	}
	
	/**
	 * Save the EmployeeArrayList to the specified file.
	 * Saved file may be opened using the open() method.
	 * @param filePath the file path of the filed to be saved to.
	 * @throws IOException if an IOException is encountered.
	 */
	public void save(String filePath) throws IOException {
		// wrapped in try-with-resources to ensure writer will be closed.
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			// first line of file is number of employees
			writer.write(Integer.toString(this.size()));
			writer.newLine();
			
			// each employee is on a new line
			// each piece of data is seperated by a '~'
			for (EmployeeInfo employee : this) {
					// F' for full time, 'P' for part time, '?' for neither
					if (employee instanceof FullTimeEmployee) {
						writer.write(String.format("F~%f~",((FullTimeEmployee) employee).getYearlySalary()));
					}
					else if (employee instanceof PartTimeEmployee) {
						PartTimeEmployee fullEmployee = (PartTimeEmployee) employee;
						writer.write(String.format("P~%f~%f~%f~",
								fullEmployee.getHourlyWage(),
								fullEmployee.getHoursPerWeek(),
								fullEmployee.getWeeksPerYear()
						));
					}
					
					// employee num, name, sex, loc, deductions
					writer.write(String.format("%d~%s~%s~%s~%s~%f",
							employee.getEmployeeNumber(),
							employee.getFirstName(),
							employee.getLastName(),
							employee.getSex(),
							employee.getWorkLocation(),
							employee.getDeductionsRate()
					));
					writer.newLine();
			}
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * Create a new EmployeeArrayList from a file saved using save();
	 * @param filePath the file path of the file to be opened.
	 * @return a new EmployeeArrayList.
	 * @throws IOException if an IOException is encountered.
	 */
	public static EmployeeArrayList open(String filePath) throws IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			EmployeeArrayList newList = new EmployeeArrayList();
			int listSize = Integer.parseInt(reader.readLine());
			for (int i = 0; i < listSize; i++) {
				String[] data = reader.readLine().split("~");
				if (data[0].equals("F")) {
					newList.add(new FullTimeEmployee(
							Integer.parseInt(data[2]),
							data[3],
							data[4],
							Integer.parseInt(data[5]),
							Integer.parseInt(data[6]),
							Double.parseDouble(data[7]),
							Double.parseDouble(data[1])
					));
				}
				else if (data[0].equals("P")) {
					newList.add(new PartTimeEmployee(
							Integer.parseInt(data[4]),
							data[5],
							data[6],
							Integer.parseInt(data[7]),
							Integer.parseInt(data[8]),
							Double.parseDouble(data[9]),
							Double.parseDouble(data[1]),
							Double.parseDouble(data[2]),
							Double.parseDouble(data[3])
					));
				}
			}
			return newList;
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * Finds and returns the EmployeeInfo object with the specified employee number.
	 * @param employeeNumber the employee number of the EmployeeInfo object to be searched for.
	 * @return the EmployeeInfo object with the given employee number, or null if one was not found.
	 */
	public EmployeeInfo findEmployee(int employeeNumber) {
		for (EmployeeInfo employee : this) {
			if (employee.getEmployeeNumber() == employeeNumber) {
				return employee;
			}
		}
		return null;
	}
	
	/**
	 * Removes the first EmployeeInfo object with the specified employee number from the hash table.
	 * @param employeeNumber the employee number of the EmployeeInfo object to be removed.
	 * @return the EmployeeInfo object that was found and removed, or null if one was not found.
	 */
	public boolean removeEmployee(int employeeNumber) {
		for (EmployeeInfo employee : this) {
			if (employee.getEmployeeNumber() == employeeNumber) {
				this.remove(employee);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sort the EmployeeArrayList by employee number.
	 */
	public void sortByEmployeeNumber() {
		this.sort((EmployeeInfo o1, EmployeeInfo o2) -> Integer.compare(o1.getEmployeeNumber(), o2.getEmployeeNumber()));
	}
	
	/**
	 * Sort the EmployeeArrayList by first name.
	 */
	public void sortByFirstName() {
		this.sort((EmployeeInfo o1, EmployeeInfo o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()));
	}
	
	/**
	 * Sort the EmployeeArrayList by last name.
	 */
	public void sortByLastName() {
		sort((EmployeeInfo o1, EmployeeInfo o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
	}
	
	/**
	 * Print out all the contents of the EmployeeArrayList.
	 */
	public void display(){
		for (EmployeeInfo employee : this) {
			System.out.println(employee.toString());
		}
	}
	
	/**
	 * A method for testing the EmployeeArrayList class.
	 * @param args 
	 */
	public static void main(String[] args) {
		EmployeeArrayList a = new EmployeeArrayList();
		a.add(new FullTimeEmployee(100, "hello", "bye", 0, 0, 0, 0));
		a.add(new FullTimeEmployee(99, "what", "aa", 0, 0, 0, 0));
		a.add(new PartTimeEmployee(52, "lad", "ayy", 2, 8, 0.6, 33, 20, 30));
		a.add(new FullTimeEmployee(1, "WHAT", "BB", 0, 0, 0, 0));
		EmployeeArrayList b;
		try {
			a.save("hello.txt");
			b = EmployeeArrayList.open("hello.txt");
			b.display();
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
}
