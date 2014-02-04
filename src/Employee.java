

/**
 * Employee model class
 * 
 * @author Hamid_Narimani
 */
public class Employee {

	private String firstName;
	private String lastName;
	private String employeeID;
	private String role;
	private String salary;
	private String pension;
	private String city;

	public Employee(String firstName, String lastName, String employeeID,
			String role, String salary, String pension, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.role = role;
		this.salary = salary;
		this.pension = pension;
		this.city = city;
	}

	public Employee() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employee) {
		this.employeeID = employee;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String employee) {
		this.salary = employee;
	}

	public String getPension() {
		return pension;
	}

	public void setPension(String employee) {
		this.pension = employee;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	 @Override
	 public String toString() {
	 return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName
	 + ", employeeID=" + employeeID + ", role=" + role + ", pension=" +
	 pension + ", city=" + city + '}';
	 }
}
