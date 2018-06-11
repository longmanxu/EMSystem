import java.io.*;
import java.util.ArrayList;

/**
 * A open hashing/closed addressing hash table class for EmployeeInfo objects.
 * Contains methods for adding and removing EmployeeInfo objects from the hash table, as well as a method for displaying its contents.
 * @author Longman Xu
 * @version 2018-05-15
 * 
 */

/*
TODO: 
- save and open to files
- edit employees
- change locations
*/
public class EmployeeHashTable implements Serializable {
	
	private final int k;  // the k value (number of buckets, length of hashTable)
	private int num;  // keep track of total number of employees, for re-optimizing 
	private final EmployeeArrayList[] hashTable; // the hash table, which is an array of ArrayLists (buckets) of EmployeeInfo objects
	private final ArrayList<String> locationList;
	private File prevSaveLoc = null;
	
	/**
	 * Constructs a new open hashing/closed addressing hash table with the specified k value.
	 * @param k the k value (number of buckets).
	 */
	public EmployeeHashTable(int k) {
		this.k = k; // set the k value
		this.num = 0;
		this.hashTable = new EmployeeArrayList[k]; // initialize the hashTable array to contain k number of buckets
		this.locationList = new ArrayList<>();
		
		// initialize the ArrayLists (buckets) within the hashTable array
		for (int i = 0; i < k; i++) {
			this.hashTable[i] = new EmployeeArrayList();
		}
	}
	
	/**
	 * Saves the EmployeeHashTable at the specified file.
	 * @param file the file to be saved to.
	 * @throws IOException if an I/O error occurs.
	 */
	public void save(File file) throws IOException {
		// wrapped in try-with-resources to ensure output stream will be closed.
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			outputStream.writeObject(this);
			this.prevSaveLoc = file;
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * Saves the EmployeeHashTable at the specified file path.
	 * @param filePath the file path to be saved to.
	 * @throws IOException if an IOException occurs.
	 */
	public void save(String filePath) throws IOException {
		save(new File(filePath));
	}
	
	/**
	 * Saves the EmployeeHashTable at the previous save location.
	 * @throws IOException if an IOException occurs.
	 */
	public void save() throws IOException {
		if (prevSaveLoc == null) {
			throw new IllegalArgumentException("File has not been saved before");
		}
		save(this.prevSaveLoc);
	}
	
	/**
	 * Open and return a new EmployeeHashTable saved at the given file.
	 * @param file the file of the EmployeeHashTable to be opened.
	 * @return the EmployeeHashTable.
	 * @throws IOException if an I/O exception occurs.
	 * @throws ClassNotFoundException if a ClassNotFoundException occurs.
	 */
	public static EmployeeHashTable open(File file) throws IOException, ClassNotFoundException {
		// use try-with-resources to automatically close reader
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
			EmployeeHashTable newTable = (EmployeeHashTable) inputStream.readObject();
			newTable.prevSaveLoc = file;
			return newTable;
		} catch (IOException | ClassNotFoundException e) {
			throw e;
		}
	}
	
	/**
	 * Open and return a new EmployeeHashTable saved at the given file path name.
	 * @param filePath the file path of the EmployeeHashTable to be opened.
	 * @return the EmployeeHashTable.
	 * @throws IOException if an I/O exception occurs.
	 * @throws ClassNotFoundException if a ClassNotFoundException occurs.
	 */
	public static EmployeeHashTable open(String filePath) throws IOException, ClassNotFoundException {
		return open(new File(filePath));
	}
	
	/**
	 * Adds the specified EmployeeInfo object to the hash table.
	 * @param newItem the new EmployeeInfo to be added.
	 */
	public void add(EmployeeInfo newItem) {
		// for every employee within the correct bucket, check if its SN == the given SN
		for (EmployeeInfo employee : hashTable[newItem.getEmployeeNumber() % k]) {
			// return false if a duplicate employee number is found
			if (employee.getEmployeeNumber() == newItem.getEmployeeNumber()) {
				throw new IllegalArgumentException("Duplicate employee numbers are not allowed.");
			}
		}
		// if duplicate not found, add the new employee
		hashTable[newItem.getEmployeeNumber() % k].add(newItem);
		num++;
	}
	
	/**
	 * Finds and returns the EmployeeInfo object with the specified employee number.
	 * @param employeeNumber the employee number of the EmployeeInfo object to be searched for.
	 * @return the EmployeeInfo object with the given employee number, or null if one was not found.
	 */
	public EmployeeInfo find(int employeeNumber) {
		// for every employee within the correct bucket, check if its SN == the given SN
		for (EmployeeInfo employee : hashTable[employeeNumber % k]) {
			// return the employee if it has the correct SN
			if (employee.getEmployeeNumber() == employeeNumber) {
				return employee;
			}
		}
		// return null if no employee with the correct SN is found
		return null;
	}
	
	/**
	 * Removes the first EmployeeInfo object with the specified employee number from the hash table.
	 * @param employeeNumber the employee number of the EmployeeInfo object to be removed.
	 * @return the EmployeeInfo object that was found and removed, or null if one was not found.
	 */
	public EmployeeInfo remove(int employeeNumber) {
		// create an ArrayList pointing to the bucket containing the target employee
		ArrayList<EmployeeInfo> targetBucket = hashTable[employeeNumber % k];
		// iterate through the bucket until finding a EmployeeInfo object with the specified SN
		for (int i = 0; i < targetBucket.size(); i++) {
			// if the EmployeeInfo object has the correct SN, return and remove it
			if (targetBucket.get(i).getEmployeeNumber() == employeeNumber) {
				num--;
				return targetBucket.remove(i);
			}
		}
		// return null if no employee with the correct SN is found
		return null;
	}
	
	/**
	 * Display the contents of the hash table.
	 * The contents will be formatted as follows: Bucket number: [first EmployeeInfo], [second EmployeeInfo], ...
	 */
	public void display() {
		for (int i = 0; i < k; i++) {
			// print the bucket number
			System.out.print("Bucket " + Integer.toString(i) + ": ");
			
			// create an ArrayList pointing to the current bucket
			ArrayList<EmployeeInfo> tempBucket = hashTable[i];
			
			// only iterate through the current bucket if it is not empty (will get IndexOutOfBounds otherwise)
			if (!tempBucket.isEmpty()) {
				// display every employee in the bucket with a trailing comma, except the last one
				for (int j = 0; j < tempBucket.size() - 1; j++) {
					System.out.print("[" + tempBucket.get(j).toString() + "], ");
				}
				// display the last employee in the bucket without a trailing comma
				System.out.print("[" + tempBucket.get(tempBucket.size() - 1).toString() + "]");
			}
			
			System.out.println(); // print a newline after every bucket
		}
	}
	
	// returns an array off all the employees
	public EmployeeArrayList returnAllEmployees() {
		EmployeeArrayList resultList = new EmployeeArrayList();
		for (EmployeeArrayList bucket : hashTable) {
			resultList.addAll(bucket);
		}
		
		return resultList;
	}
	
	/**
	 * Converts an ArrayList&lt;EmployeeInfo&gt; into an EmployeeHashTable.
	 * @param sourceList the ArrayList&lt;EmployeeInfo&gt; to be converted.
	 * @return the EmployeeHashTable created from the sourceList.
	 */
	public static EmployeeHashTable arrayListToHashTable (ArrayList<EmployeeInfo> sourceList) {
		EmployeeHashTable newTable = new EmployeeHashTable(10);
		for (EmployeeInfo newEmployee : sourceList) {
			newTable.add(newEmployee);
		}
		return newTable;
	}
	
	/**
	 * Add a new locationIndex.
	 * @param locationName the new locationIndex.
	 */
	public void addLocation(String locationName) {
		if (this.locationList.contains(locationName)) {
			throw new IllegalArgumentException("This location already exists.");
		}
		this.locationList.add(locationName);
	}
	
	public void removeLocation(String locationName) {
		int locationIndex = this.locationList.indexOf(locationName);
		for (EmployeeArrayList bucket : this.hashTable) {
			for (EmployeeInfo employee : bucket) {
				if (employee.getWorkLocation() == locationIndex) {
					throw new IllegalArgumentException("Cannot remove this location.");
				}
			}
		}
		this.locationList.remove(locationIndex);
	}
	
	/**
	 * Converts a locationIndex number to a locationIndex name.
	 * @param locationNumber the locationIndex number.
	 * @return the locationIndex name.
	 */
	public String getLocationName(int locationNumber) {
		return this.locationList.get(locationNumber);
	}
	
	/**
	 * Return the list of locations.
	 * @return the list of locations.
	 */
	public ArrayList<String> getLocationList() {
		return this.locationList;
	}
	
	/**
	 * Get the number of employees.
	 * @return the number of employees.
	 */
	public int getNum() {
		return this.num;
	}
	
	/**
	 * Get the k value.
	 * @return the k value.
	 */
	public int getK() {
		return this.k;
	}
	
	/**
	 * Get the hash table.
	 * @return the hash table.
	 */
	public EmployeeArrayList[] getHashTable() {
		return this.hashTable;
	}
	
}
