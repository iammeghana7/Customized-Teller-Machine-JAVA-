import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/logout")
public class logout extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();

		//	RequestDispatcher rs=request.getRequestDispatcher("logout.html");
		//	rs.forward(request,response);
//
//			
//			RequestDispatcher rs1=request.getRequestDispatcher("index.html");
//			rs1.include(request,response);
//			
		request.getRequestDispatcher("welcome.html").include(request, response);
		out.println("successfully logged out");
		RequestDispatcher rs=request.getRequestDispatcher("index.html");
		rs.forward(request,response);
		
		
	}
}