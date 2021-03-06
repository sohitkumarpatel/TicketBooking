package test;
import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;
@SuppressWarnings("serial")
public class SelectedTrainServlet extends HttpServlet {
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null) {
			pw.println("Login First--<br>");
			RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
			
		}else {
			String uName=c[0].getValue();
			pw.println("Welcome User:"+uName+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Link2.html");
			rd.include(req, res);
			String tNo=req.getParameter("tNo");
			ServletContext sct=this.getServletContext();
			ArrayList<TrainBean> al=(ArrayList<TrainBean>) sct.getAttribute("jcfRef");
			List l=al.stream().filter((p)->p.gettNo().equals(tNo)).collect(Collectors.toList());
			pw.println("<br>--Train Details--");
			l.forEach((q)->{
				TrainBean tb=(TrainBean)q;
				pw.println("<br>"+tb.gettNo()+"&nbsp&nbsp"+
				                 tb.gettName()+"&nbsp&nbsp"+
				                 tb.getfStation()+"&nbsp&nbsp"+
				                 tb.gettStation()+"&nbsp&nbsp"+
				                 tb.getAvl());
			
			});
			
		}
	}

}
