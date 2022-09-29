package Vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.mysql.cj.xdevapi.Result;

import Admin.AdministratorDW;
import Connacter.DbConnect;

public class VendorMethod implements VenderDao {

	
	@Override
	public int registerV(String name,String email, String password) {
		int chacker=0;
        try(Connection conn=DbConnect.connection()){
        	
        	PreparedStatement ps=conn.prepareStatement("insert into vendor(vname,vemail,password) values(?,?,?)");
        	ps.setString(1,name);
        	ps.setString(2, email);
        	ps.setString(3, password);
        	
        	chacker=ps.executeUpdate();
        	
        }catch(SQLException e){
        	
        }
		return chacker;
	}
	
	//===================================================================================
	@Override
	public List<Vendor> viewVendor() {
		
		List<Vendor> list = new ArrayList<>();
		
		try(Connection conn=DbConnect.connection()) {
			  PreparedStatement ps=conn.prepareStatement("Select * from vendor");
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
					 
				 int r= rs.getInt("vid");
				  String n=rs.getString("vname");
				  String e=rs.getString("vemail");
				  String p=rs.getString("password");
				  
				  list.add(new Vendor(r, n, e, p));  
			  }
			 
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return list;
	}
//================================================================================
	@Override
	public int assignTender(String name, int vid) {
		int chack =0;
		try(Connection conn=DbConnect.connection()){
			PreparedStatement ps=conn.prepareStatement("upadte tender set taid=? where tname=?");
			chack=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return chack;
	}
   //=================================================================================
	@Override
	public String login(String email, String password) throws WrongVendorExaption {
	String msg="wrong input";
		
		try(Connection conn=DbConnect.connection()) {
			
		    PreparedStatement ps=conn.prepareStatement("select vname from vendor where vemail=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String d=rs.getString("vname");
				msg="helloo Mr."+d+" how are you";
			}
			else {
				 throw new WrongVendorExaption("!!!!!!.wrong user name and password.!!!!!!!");	
			}
			
		} catch (SQLException e) {
			msg=e.getMessage();
		}
		
		return msg;
	}
	


	
}
