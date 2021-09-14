package employeeApplication.dao;

import java.sql.SQLException;
import java.util.List;

import employeeApplication.model.Employee;

public interface EmployeeDaoInterface {
	
	int createEmployee(Employee user) throws SQLException;
	int updateEmployee(Employee employee) throws SQLException;
	List<Employee> viewAllEmployees();
	Employee viewEmployee(Employee employee) throws SQLException;
	

}
