package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		Connection c=DBUtil.getDBConnection();
		Statement s;
		try {
			int flag=0;
			s = c.createStatement();
			ResultSet rs=s.executeQuery("select * from login_info");
			while(rs.next())
			{
				
				if(rs.getString(1).equals(uname) && rs.getString(2).equals(pass))
				{
					flag=1;
					break;
				}
			}
			
			if(flag==1)
			{
				req.setAttribute("uname", uname);
				RequestDispatcher rd=req.getRequestDispatcher("display");
				rd.forward(req,res);
			}
			else
			{
			   PrintWriter out=res.getWriter();
			   out.print("<html><head><script>alert(\"Incorrect Username or Password\");</script></head></html>");
				RequestDispatcher rd=req.getRequestDispatcher("index.html");
				rd.include(req,res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}