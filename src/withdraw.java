

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.sql.*;
@WebServlet("/withdraw")
public class withdraw extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		System.out.println("In credit fn");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		System.out.println("im here");
		int balance=0;
		System.out.println("Opened credit");
		try
		{
		balance=Integer.parseInt(request.getParameter("amount"));
		}
		catch(NumberFormatException e)
		{
			System.out.println("Exception " +e);
		}
		System.out.println("Opened credit");
		
		
		
	//	String contact=request.getParameter("contact");
		System.out.println(balance);
		System.out.println("\nIn credit "+Validate.gpin);
		
		int b=Validate.debitBal(balance);
		System.out.println("\nIn update bal is :\t"+b);
		
			RequestDispatcher rs=request.getRequestDispatcher("withdraw.html");
			rs.forward(request,response);
			
		
			request.getRequestDispatcher("welcome.html").include(request, response);
	
		
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		out.close();
	}

}
