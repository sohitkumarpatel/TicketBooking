package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ViewTrainsServlet extends HttpServlet{
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null) {
			pw.println("Login First..<br>");
			RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
		}else {
			String uName=c[0].getValue();
			pw.println("Welcome User:"+uName+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Link2.html");
			rd.include(req, res);
			pw.println("<br>--Train List---");
			RetriveDAO r=new RetriveDAO();
			ServletContext sct=this.getServletContext();
			Collection col=r.retrive(sct);
			if(col==null) {
				pw.println("--No Train Found--<br>");
			}else {
				col.forEach((k)->{
					TrainBean tb=(TrainBean) k;
					pw.println("<br>");
					pw.println("<a href='select?tNo="+tb.gettNo()+"'>"+tb.gettNo()+"</a>");
					pw.println("&nbsp&nbsp"+tb.gettName());
				});
			}
		}
	}
	

}
