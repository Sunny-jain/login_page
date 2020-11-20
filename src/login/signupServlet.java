package login;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class signupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		PrintWriter out=res.getWriter();
		Connection c=DBUtil.getDBConnection();
		Statement s;
		try {
			int flag=0;
			s = c.createStatement();
			ResultSet rs=s.executeQuery("select * from login_info");
			while(rs.next())
			{
				if(rs.getString(1).equals(uname))
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
			{
				out.print("<html><head><script>alert(\"username already taken\");</script></head></html>");
				RequestDispatcher rd=req.getRequestDispatcher("signup.html");
				rd.include(req,res);
			}
			else
			{
				PreparedStatement p=c.prepareStatement("insert into login_info values(?,?)");
				p.setString(1, uname);
				p.setString(2, pass);
				p.executeUpdate();
				out.print("<html><head><script>alert(\"username inserted\");</script></head></html>");
				RequestDispatcher rd=req.getRequestDispatcher("index.html");
				rd.forward(req, res);
			}
		}
		catch(Exception e)
		{
			
		}
	}

}
