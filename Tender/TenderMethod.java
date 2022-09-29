package Tender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connacter.DbConnect;


public class TenderMethod implements TenderDao{

	@Override
	public int registerT(String name, int budget) {
		int chacker=0;
        try(Connection conn=DbConnect.connection()){
        	
        	PreparedStatement ps=conn.prepareStatement("insert into tender(tname,budget) values(?,?)");
        	ps.setString(1,name);
        	ps.setInt(2, budget);
        	
        	
        	chacker=ps.executeUpdate();
        	
        }catch(SQLException e){
        	
        }
		return chacker;
	}

	@Override
	public List<Tender> viewTender() {
        List<Tender> list = new ArrayList<>();
		
		try(Connection conn=DbConnect.connection()) {
			  PreparedStatement ps=conn.prepareStatement("Select * from tender");
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
					 
				int i=rs.getInt("tid");
				String n=rs.getString("tname");
				int b=rs.getInt("budget");
				int aid=rs.getInt("taid");
				  
				  list.add(new Tender(i, n, b, aid));  
			  }
			 
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new TenderMethod().viewTender());
	}
	

}
