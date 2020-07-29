import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Welcome user");
        out.println("<html><body>");
        out.println("<form action = './credit'><input type=submit value=CREDIT /></form>'");
        out.println("<form action = './withdraw'><input type=submit value=WITHDRAW /></form>'");
        out.println("<form action = './transfer'><input type=submit value=TRANSFER /></form>'");
        out.println("<form action = './balance'><input type=submit value=BALANCE /></form>'");
        //out.println("<input type=Submit value = credit/>");
     //   out.println("</form>");
      }  
    
}
