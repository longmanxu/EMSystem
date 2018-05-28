
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
	 * Sort the EmployeeArrayList by employee number.
	 */
	public void sortByEmployeeNumber() {
		sort((EmployeeInfo o1, EmployeeInfo o2) -> Integer.compare(o1.getEmployeeNumber(), o2.getEmployeeNumber()));
	}
	
	/**
	 * Sort the EmployeeArrayList by first name.
	 */
	public void sortByFirstName() {
		sort((EmployeeInfo o1, EmployeeInfo o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()));
	}
	
	/**
	 * Sort the EmployeeArrayList by last name.
	 */
	public void sortByLastName() {
		sort((EmployeeInfo o1, EmployeeInfo o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
	}
	
	public void display(){
		for(EmployeeInfo employee : this){
			System.out.println(employee.toString());
		}
	}
	
	public static void main(String[] args) {
		EmployeeArrayList a = new EmployeeArrayList();
		a.add(new FullTimeEmployee(100, "hello", "bye", 0, 0, 0, 0));
		a.add(new FullTimeEmployee(99, "what", "aa", 0, 0, 0, 0));
		a.add(new FullTimeEmployee(1, "WHAT", "BB", 0, 0, 0, 0));
		a.display();
		System.out.println("\nSorted by employee number:");
		a.sortByEmployeeNumber();
		a.display();
		System.out.println("\nSorted by first name:");
		a.sortByFirstName();
		a.display();
		System.out.println("\nSorted by last name:");
		a.sortByLastName();
		a.display();
		System.out.println("\nSorted by first name:");
		a.sortByFirstName();
		a.display();
	}
}
