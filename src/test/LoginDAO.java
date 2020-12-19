package test;
import java.sql.*;

public class LoginDAO {
	public boolean z;
	public boolean validate(String uName,String pWord,String name) {
		try {
			Connection con=DBConnection.getCon();
			if(name.equals("UserLogin")) {
				
				PreparedStatement ps=con.prepareStatement("select * from UserReg20 where uname=? and pWord=?");
				ps.setString(1, uName);
				ps.setString(2, pWord);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					z=true;
					
				}
			}
			else {
				PreparedStatement ps=con.prepareStatement("select * from Admin25 where uname=? and pWord=?");
				ps.setString(1, uName);
				ps.setString(2, pWord);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					z=true;
					
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
		
	}

}
