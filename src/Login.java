import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/login")
public class Login extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String pin=request.getParameter("pin");
		System.out.println("Username and pin are:\t"+username+pin);
		boolean b=Validate.checkUser(username,pin);
		System.out.println("Value of b is "+ b);
		if(b)
		{
			RequestDispatcher rs=request.getRequestDispatcher("welcome.html");
			rs.forward(request,response);
		}
		else
		{
			out.println("Username or Password incorrect");
			RequestDispatcher rs=request.getRequestDispatcher("index.html");
			rs.include(request,response);
			
		}
	}
}