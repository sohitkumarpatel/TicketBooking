package test;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
public class RetriveDAO {
  public ArrayList<TrainBean> al;
  @SuppressWarnings("rawtypes")
  public Collection retrive(ServletContext sct) {
	 try {
		 
		 Connection con=DBConnection.getCon();
		 PreparedStatement ps=con.prepareStatement("select * from Train21");
		 al=new ArrayList<TrainBean>();
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			 TrainBean tb=new TrainBean();
			 tb.settNo(rs.getString(1));
			 tb.settName(rs.getString(2));
			 tb.setfStation(rs.getString(3));
			 tb.settStation(rs.getString(4));
			 tb.setAvl(rs.getInt(5));
			 al.add(tb);
		 }//end of while loop
		 sct.setAttribute("jcfRef",al);
		 
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return al;
	  
  }
}
