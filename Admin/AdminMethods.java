package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connacter.DbConnect;

public class AdminMethods implements AdminDao {

	@Override
	public String login(String email, String password) {
		String msg="wrong input";
		
		try(Connection conn=DbConnect.connection()) {
			
		    PreparedStatement ps=conn.prepareStatement("select name from administrator where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String d=rs.getString("name");
				msg="helloo Mr."+d+" how are you";
			}
			else {
				 throw new AdministratorDW("!!!!!!.wrong user name and password.!!!!!!!");	
			}
			
		} catch (SQLException e) {
			msg=e.getMessage();
		} catch (AdministratorDW e) {
			msg=e.getMessage();
		}
		
		return msg;
		
	}

}
