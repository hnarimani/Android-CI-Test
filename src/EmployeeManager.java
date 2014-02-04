

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * EmployeeManager model class
 * 
 * @author Hamid_Narimani
 * 
 * step 1)Read the csv file line by line (record by record) with comma separator ","
 *         -store into empList ArrayList<Employee>()
 *         -check our record be > 1000
 *           -if it is more than 1000 stop reading and storing 
 *      2) Sort our ArrayList order by EmployeeID
 *          -print as user request
 *      3) print as user request the Employee Pension Eligibility with condition for those who have 5 years of service or more
 *      
 *  Ref:   -http://stackoverflow.com/questions/7712524/java-import-csv-to-arraylist
 *         -http://stackoverflow.com/questions/16784014/importing-csv-file-into-2d-string-array
 *         -http://codereview.stackexchange.com/questions/10681/java-function-to-read-a-csv-file
 *        -https://forums.oracle.com/message/4968211
 */
public class EmployeeManager {

	public void convertCsvToJava(boolean x) {
		String csvFileToRead = "Files/hamid.csv";
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		int count = 0;
		int limit=1000; // Use variable limit to limited our csv record under 1000.
		List<Employee> empList = new ArrayList<Employee>();

		try {

			br = new BufferedReader(new FileReader(csvFileToRead));
			while ((line = br.readLine()) != null) {
				count++;
				// split on comma(',')
				String[] Employee = line.split(splitBy);
				Employee empObject = new Employee();// create Employee object to  store values
				empObject.setFirstName(Employee[0]);// add values from csv to Employee object
				empObject.setLastName(Employee[1]);
				empObject.setEmployeeID(Employee[2]);
				empObject.setRole(Employee[3]);
				empObject.setSalary(Employee[4]);
				empObject.setPension(Employee[5]);
				empObject.setCity(Employee[6]);
				empList.add(empObject); // adding Employee objects to a list
				if (count > limit) {
					System.out
							.println("You reach to 1000 record and This App can just load 1000 record!!!!!!");
					break;
				}
			}
			// print values stored in EmployeeList
			if (x) {
				printSortByEmployeeID(empList);
			} else {
				printEmployeePensionEligibility(empList);
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {

				}
			}
		}
	}

	public void printSortByEmployeeID(List<Employee> empListToPrint) {
		SortEmployee sEmp = new SortEmployee(3);
		empListToPrint = sEmp.sort(empListToPrint);

		for (int i = 0; i < empListToPrint.size(); i++) {
			try {

				System.out.println("Employee [First Name= "
						+ empListToPrint.get(i).getFirstName()
						+ " , Last Name=" + empListToPrint.get(i).getLastName()
						+ " , Employee ID="
						+ empListToPrint.get(i).getEmployeeID() + " , Role="
						+ empListToPrint.get(i).getRole() + " , Salary= "
						+ empListToPrint.get(i).getSalary() + ", Pension= "
						+ empListToPrint.get(i).getPension() + ", City= "
						+ empListToPrint.get(i).getCity() + "]");
			} catch (Exception ex) {
			}
		}
	}

	public void printEmployeePensionEligibility(List<Employee> empListToPrint) {
		SortEmployee sEmp = new SortEmployee(3);
		empListToPrint = sEmp.sort(empListToPrint);

		for (int i = 0; i < empListToPrint.size(); i++) {
			try {
				if (Integer.parseInt(empListToPrint.get(i).getPension()) >= 5) {
					System.out.println("Employee [First Name= "
							+ empListToPrint.get(i).getFirstName()
							+ " , Last Name="
							+ empListToPrint.get(i).getLastName()
							+ " , Employee ID="
							+ empListToPrint.get(i).getEmployeeID()
							+ " , Role=" + empListToPrint.get(i).getRole()
							+ " , Salary= " + empListToPrint.get(i).getSalary()
							+ ", Pension= "
							+ empListToPrint.get(i).getPension() + ", City= "
							+ empListToPrint.get(i).getCity() + "]");
				}
			} catch (Exception ex) {
			}
		}
	}

	public static void main(String[] args) {

		EmployeeManager csvToJavaObject = new EmployeeManager();

		System.out
				.println(" \n1)Please enter value 1 For  sort  by employee ID  "
						+ "\n2)Please enter value 2 For only those who have 5 years of service or more");

		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int userChoise = Integer.parseInt(input);
		switch (userChoise) {
		case 1:

			csvToJavaObject.convertCsvToJava(true);
			break;

		case 2:

			csvToJavaObject.convertCsvToJava(false);
			break;

		default:
			System.out.println("Invalid input ");
			break;
		}
	}

}
