package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class displayServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String s=(String) req.getAttribute("uname");
		PrintWriter out=res.getWriter();
		out.println("<html>\r\n" +
				"<head>\r\n" + 
				"	<title>Display page</title>\r\n" + 
				"    <style>\r\n" + ".wrapper {\r\n" + 
						"  display: flex;\r\n" + 
						"  align-items: center;\r\n" + 
						"  flex-direction: column; \r\n" + 
						"  justify-content: center;\r\n" + 
						"  width: 100%;\r\n" + 
						"  min-height: 100%;\r\n" + 
						"  padding: 20px;\r\n" + 
						"}" +
				"    h2 {\r\n" + 
				"	display: inline;\r\n" + 
				"	position: relative;\r\n" + 
				"	font: 70px Helvetica, Sans-Serif;\r\n" + 
				"	letter-spacing: -5px;\r\n" + 
				"	color: rgba(0,0,255,0.5); \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" +
				"	<div class=\"wrapper\"><h2><span>welcome   "+s+"   !!!!!<span></h2></div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
