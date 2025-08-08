package libaryapp;
import java.util.*;
import java.sql.*;

public class loginDAO {
	
	
	public void register(String username,String password) throws SQLException {

		String query="insert into logininfo values(?,?);";
		Connection con=dbconnection.getconnection();
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,username);
		pst.setString(2, password);
		pst.executeUpdate();
		System.out.println("Register Successfully");
	}
	

	public boolean validate(String username, String password) throws SQLException {
		String query="select * from logininfo where username=? and password=? ";
		Connection con=dbconnection.getconnection();
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,username);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		return rs.next();
	}

}
