package com.sirma.itt.javacourse.objects.supermarket;

/**
 * Represents employee.
 * 
 * @author smustafov
 */
public class Employee extends Person {

	private static int employeeID = 0;
	private Departments department;

	/**
	 * Creates a new employee.
	 * 
	 * @param name
	 *            - the employee's name to be set
	 * @param age
	 *            - the employee's age to be set
	 * @param department
	 *            - the employee's working department to be set
	 */
	public Employee(String name, int age, Departments department) {
		super(name, age);
		this.department = department;
		Employee.employeeID++;
	}

	/**
	 * @return - the employee's ID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @return - the employee's department
	 */
	public Departments getEmployeeDepartment() {
		return department;
	}

}
