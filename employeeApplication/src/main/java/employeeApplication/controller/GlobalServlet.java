package employeeApplication.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import employeeApplication.model.Employee;
import employeeApplication.service.EmployeeServiceInterface;
import employeeApplication.utility.ServiceFactory;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 EmployeeServiceInterface employeeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalServlet() {
        super();
        // TODO Auto-generated constructor stub
       
		
		employeeService = ServiceFactory.createServiceObject();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String a = request.getParameter("ac");
		PrintWriter out=response.getWriter();
		
		if(a.equals("register")) {
			String name=request.getParameter("nm");
			String password=request.getParameter("pass");
			String email=request.getParameter("em");
			String department=request.getParameter("dep");
		
			
			Employee user = new Employee();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setDepartment(department);
			
			int i = 0;
			try {
				i = employeeService.createEmployee(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			response.setContentType("text/html");
			
			
			out.println("<html><body>");
			if(i>0) {
				request.setAttribute("message", "profile created");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Register.jsp");
				rd.forward(request, response);
			}
			else {
				out.println("could not create profile");
			}

		}
		
		
		if(a.equals("editEmployee")) {
			String email=request.getParameter("uid");
			
			Employee empUser=new Employee();
			
			empUser.setEmail(email);
			
			
			Employee empU = null;
			try {
				empU = employeeService.viewEmployee(empUser);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			Gson g=new Gson();
			String ss=g.toJson(empU);
			
			System.out.println("myjson "+ss);
			
			if(empU!=null) {
				out.println(ss);
				out.println("<form action=GlobalServlet?ac=usereditprofile method=post>");
					out.println("Name <input type=text name=nm value="+empU.getName()+">");
					out.println("Password <input type=text name=pass value="+empU.getPassword()+">");
					out.println("Email <input type=text name=em value="+empU.getEmail()+" disabled>");
					out.println("<input type=hidden name=em1 value="+empU.getEmail()+" >");
					out.println("Department <input type=text name=depart value="+empU.getDepartment()+">");
					out.println(" <input type=submit value=edit>");
				out.println("</form>");
				
				
			}
			else {
				out.println("record not found");
			}
		}
		
		if(a.equals("usereditprofile")) {
			
			System.out.println("in");

				String name=request.getParameter("nm");
				String password=request.getParameter("pass");
				String email=request.getParameter("em1");
				String department=request.getParameter("depart");
			
				
				
				System.out.println(name+password+email+department);
				Employee user = new Employee();
				user.setName(name);
				user.setPassword(password);
				user.setEmail(email);
				user.setDepartment(department);
			
					
			
			int i = 0;
			try {
				i = employeeService.updateEmployee(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			
			if(i>0) {
				
				out.println("profile edited");
			}
			

			
		}
		
		if(a.equals("displayAllProfile")) {
			List<Employee> empList = employeeService.viewAllEmployees();
			
			System.out.println(empList.size());
			if(empList.size() > 0) {
				request.setAttribute("data", empList);
				
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/timeline.jsp");
				rd.forward(request, response);
			}
			out.println("</body></html>");	
		}
		
		
		}

}
