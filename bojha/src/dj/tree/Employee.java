package dj.tree;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private long employeeId;

	private List<Employee> subordinates;

	private List<Employee> managers;

	/**
	 * To add subordinates.
	 * @param subordinate
	 */
	public void addSubordinate(Employee subordinate) {
		addToList(subordinates,subordinate);
	}
	
	public void addManagers(Employee manager) {
		addToList(managers,manager);
	}

	private void addToList(List<Employee> employeeList,Employee employee){
		if (employeeList == null) {
			employeeList = new ArrayList<Employee>();
		} 
		if (!employeeList.contains(employee)) {
			employeeList.add(employee);
		}
	}
}
