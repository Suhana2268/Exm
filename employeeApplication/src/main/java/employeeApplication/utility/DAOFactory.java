package employeeApplication.utility;

import employeeApplication.dao.EmployeeDaoImpl;
import employeeApplication.dao.EmployeeDaoInterface;

public class DAOFactory {

	private DAOFactory() {
		// TODO Auto-generated constructor stub
	}

	public static EmployeeDaoInterface createDaoObject() {
		return new EmployeeDaoImpl();
	}
}
