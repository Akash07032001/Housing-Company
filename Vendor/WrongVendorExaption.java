package Vendor;

import com.mysql.cj.exceptions.ExceptionInterceptor;

public class WrongVendorExaption extends Exception {

	public WrongVendorExaption() {
		//super();
		
	}

	public WrongVendorExaption(String message) {
		super(message);
		
	}

	
}
