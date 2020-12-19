package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {
	
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String uName=req.getParameter("uname");
	String pWord=req.getParameter("pword");
	String name=req.getParameter("s1");
	LoginDAO ld=new LoginDAO();
	boolean k=ld.validate(uName, pWord, name);
	if(k) {
		Cookie ck=new Cookie("uName",uName);
		res.addCookie(ck);
		pw.println("Welcome User:"+uName+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("Link2.html");
		rd.include(req, res);
	}else {
		pw.println("Invalid UserName Or Password..!!<br>");
		RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
		rd.include(req, res);
		
	}
}
}
