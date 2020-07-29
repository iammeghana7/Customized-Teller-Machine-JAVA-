import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/transfer")
public class transfer extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		int amt=0;
		try{
			amt=Integer.parseInt(request.getParameter("amt"));
			System.out.println("Enter amt:\t"+amt);
		}
		catch(Exception e)
		{
			System.out.println("In exception "+amt+ e);
		}
		
		int b=Validate.transferAmt(amt,username);
		System.out.println("Value of b is "+ b);
		//if(b==1)
		//{
			RequestDispatcher rs=request.getRequestDispatcher("transfer.html");
			rs.forward(request,response);
		//}
		//else
		//{
			out.println("Username doesnot exists");
			RequestDispatcher rs1=request.getRequestDispatcher("welcome.html");
			rs1.include(request,response);
			
		//}
	}
}