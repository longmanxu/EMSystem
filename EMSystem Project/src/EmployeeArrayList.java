
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
		// wrapped in try-with-resources to ensure output stream will be closed.
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
			outputStream.writeObject(this);
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * Create a new EmployeeArrayList from a file saved using save();
	 * @param filePath the file path of the file to be opened.
	 * @return a new EmployeeArrayList from the saved file.
	 * @throws IOException if an IOException is encountered.
	 * @throws java.lang.ClassNotFoundException if a ClassNotFoundException is encountered.
	 */
	public static EmployeeArrayList open(String filePath) throws IOException, ClassNotFoundException {
		// wrapped in a try-with-resources to ensure input stream will be closed.
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
			return (EmployeeArrayList) inputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
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
		a.display();
		EmployeeArrayList b;
		try {
			a.save("hello.txt");
			b = EmployeeArrayList.open("hello.txt");
			b.display();
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace(System.err);
		}
	}
}
