package employeeApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employeeApplication.model.Employee;

public class EmployeeDaoImpl implements EmployeeDaoInterface{
	
	Connection con;
	PreparedStatement ps;
	
public EmployeeDaoImpl() {
		
		con = DatabaseUtil.con;
		
	}
	
	
	
	public int createEmployee(Employee user) throws SQLException{
		
		
		int status = 0;
		String name = user.getName();
		String email = user.getEmail();
		String password = user.getPassword();
		String department = user.getDepartment();
		
		
		String query = "insert into employeetable values(?,?,?,?)";
		
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, email);
		ps.setString(4, department);
		
		int i = ps.executeUpdate();
		if(i == 1) status = 1;
		
		return status;
	}
	
	public List<Employee> viewAllEmployees()
	{
		
		List<Employee> employeeList=new ArrayList<Employee>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employeetable1");
			
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				Employee emp=new Employee();
				emp.setName(res.getString(1));
				emp.setPassword(res.getString(2));
				emp.setEmail(res.getString(3));
				emp.setDepartment(res.getString(4));
				
				employeeList.add(emp);
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return employeeList;
	}
	public int updateEmployee(Employee e) throws SQLException {

		String query = "update employeetable set name =?,password = ?, department =? where email =?";
		
		ps = con.prepareStatement(query);
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getDepartment());
		ps.setString(4, e.getEmail());
		
		
		
		int i = 0;
			i=	ps.executeUpdate();
		
		
		return i;
		
	}
	
public Employee viewEmployee(Employee user) throws SQLException{
		
		Employee employee = new Employee();
		
		String query = "select * from employeetable where email=?";
	
		ps = con.prepareStatement(query);
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			
			String name = rs.getString(1);
			String password = rs.getString(2);
			String email = rs.getString(3);
			String department = rs.getString(4);
			
			employee.setPassword(password);
			employee.setName(name);
			employee.setEmail(email);
			employee.setDepartment(department);
			
		}
		
		
		return employee;
	}
}





	
