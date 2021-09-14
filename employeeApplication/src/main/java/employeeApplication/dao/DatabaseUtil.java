package employeeApplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	
public static Connection con;
	
	static {
		try {
			String path = "jdbc:mysql://localhost:3306/EmployeeWebsite";
			String username = "root";
			String password = "Tejas@123";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(path, username, password);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
