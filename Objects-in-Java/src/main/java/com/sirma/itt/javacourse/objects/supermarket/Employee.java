package com.sirma.itt.javacourse.objects.supermarket;

/**
 * @author smustafov
 */
public class Employee extends Supermarket {

	private Person employee;
	private Department department;

	/**
	 * Creates a new employee.
	 * 
	 * @param employee
	 *            - the employee to be set
	 * @param department
	 *            - the employee's working department
	 */
	public Employee(Person employee, Department department) {
		this.employee = employee;
		this.department = department;
	}

}
