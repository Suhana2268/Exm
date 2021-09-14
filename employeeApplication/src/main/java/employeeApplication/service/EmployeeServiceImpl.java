package employeeApplication.service;

import java.sql.SQLException;
import java.util.List;

import employeeApplication.dao.EmployeeDaoInterface;
import employeeApplication.model.Employee;
import employeeApplication.utility.DAOFactory;

public class EmployeeServiceImpl implements EmployeeServiceInterface{
	
	EmployeeDaoInterface iDao;
	

	public EmployeeServiceImpl() {
		
		iDao = DAOFactory.createDaoObject();
		}
		
		public int createEmployee(Employee user) throws SQLException {
			return iDao.createEmployee(user);
		}
		
		public List<Employee> viewAllEmployees() {
			return iDao.viewAllEmployees();
		}
		public int updateEmployee(Employee user) throws SQLException {
			System.out.println(user.getEmail()+"Serviceee");
			int i = 0;
			Employee em = null;
		
			i = iDao.updateEmployee(user);
			if(i > 0) {
				em = user;
			}
			return i;
			
		}
		public Employee viewEmployee(Employee user) throws SQLException{
			Employee employee = null;
				
			employee = iDao.viewEmployee(user);
			return employee;
		}

}
