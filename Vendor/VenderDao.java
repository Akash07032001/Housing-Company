package Vendor;

import java.util.List;
import java.util.Vector;

public interface VenderDao {
	
	public  int registerV(String name,String email, String password);
	
	public List<Vendor> viewVendor();
	
	public int assignTender(String name,int vid);
	
	public String login(String emial,String password) throws WrongVendorExaption;
		
	
	

}
