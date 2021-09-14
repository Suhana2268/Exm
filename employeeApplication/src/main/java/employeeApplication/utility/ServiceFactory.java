package employeeApplication.utility; 

import employeeApplication.service.EmployeeServiceImpl;
import employeeApplication.service.EmployeeServiceInterface;

public class ServiceFactory {
	
	private ServiceFactory() {
		
	}

	public static EmployeeServiceInterface createServiceObject() {
		return new EmployeeServiceImpl();
			
			
		}
}
