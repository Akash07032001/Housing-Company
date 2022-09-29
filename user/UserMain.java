package user;

import java.util.List;
import java.util.Scanner;

import Admin.AdminDao;
import Admin.AdminMethods;
import Admin.AdministratorDW;
import Tender.TenderDao;
import Tender.TenderMethod;
import Vendor.VenderDao;
import Vendor.VendorMethod;
import Vendor.WrongVendorExaption;

public class UserMain {
	
	//VenderDao ven=new VendorMethod();
	public static void allAdminFunction() {
		
		int order=0;
		Scanner sc= new Scanner(System.in);
	   VenderDao ven=new VendorMethod();
	   TenderDao ten=new TenderMethod();
		while(true) {
			System.out.println("Press 1 for Register new Vendor.");
			System.out.println("Press 2 for View all the vendors.");
			System.out.println("Press 3 for Create new tenders.");
			System.out.println("Press 4 for View All the tenders.");
			System.out.println("Press 5 for View All the bids of a tender");
			System.out.println("Press 6 for Assign tender to a vendor.");
			System.out.println("******************************************");
			order=sc.nextInt();
			if(order==1||order==2||order==3||order==4||order==5||order==6) {
				if(order==1) {
				   System.out.println("enter vendor name :-");
				   String name=sc.next();
				   System.out.println("enter vendor email :-");
				   String email=sc.next();
				   System.out.println("enter vendor password :-");
				   String password=sc.next();
				   int c=ven.registerV(name, email, password);
				   if(c>0) {System.out.println("entry data succfully.. (^_^)");}
				   else {System.out.println("Please enter the valid input.. (*_*)");}
				}
				else if(order==2) {
					List list=ven.viewVendor();
					if(list.size()==0) {System.out.println("vendor list is empty");}
					else {list.forEach(s->System.out.println(s));}
				}
				else if(order==3) {
					System.out.println("enter the tendor name");
					String n=sc.next();
					System.out.println("enter the tendor budget");
					int b= sc.nextInt();
					int c=ten.registerT(n, b);		
					 if(c>0) {System.out.println("entry data succfully.. (^_^)");}
					   else {System.out.println("Please enter the valid input.. (*_*)");}
					
				}
				else if(order==4) {
					List list=ten.viewTender();
					if(list.size()==0) {System.out.println("vendor list is empty");}
					else {list.forEach(s->System.out.println(s));}
					
				}
				else if(order==5) {
					
				}
				else if(order==6) {
					
					System.out.println("which tender you assign");
					String name=sc.next();
					System.out.println("wich vender you assign");
					int c=sc.nextInt();
					if(c>0) {System.out.println("entry data succfully.. (^_^)");}
					   else {System.out.println("Please enter the valid input.. (*_*)");}
					
				}
				
				System.out.println("*******************************************");
				System.out.println("if no need to GO BACK enter 'STOP' key word else prass any key");
				String s= sc.next();
				if(s.equals("STOP")) {
					break;
				}
				System.out.println("*******************************************");
			}else {
				System.out.println("Please enter right input.....");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
			public static void allVendorFunction() {
				int order=0;
				Scanner sc= new Scanner(System.in);
			   VenderDao ven=new VendorMethod();
			   TenderDao ten=new TenderMethod();
			   
			   while(true) {
				   System.out.println("Prass 1 for View All the current Tenders");
				    System.out.println("Prass 2 for View All the current Tenders");
				    System.out.println("Prass 3 for View All the current Tenders");
				    System.out.println("Prass 4 for View All the current Tenders");
				    System.out.println("******************************************");
				    order=sc.nextInt();    
				    if(order==1||order==2||order==3||order==4) {
				    	
				    	if(order==1) {
				    		List list=ten.viewTender();
							if(list.size()==0) {System.out.println("vendor list is empty");}
							else {list.forEach(s->System.out.println(s));}
				    	}
						if(order==2) {
				    		
							
				    	}if(order==3) {
				    		
				    		
				    	}if(order==4) {
				    		
				    		
				    	}
				    	
				    	System.out.println("*******************************************");
						System.out.println("if no need to GO BACK enter 'STOP' key word else prass any key");
						String s= sc.next();
						if(s.equals("STOP")) {
							break;
						}
						System.out.println("*******************************************");
				    }else {
				    	System.out.println("Please enter right input.....");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
			   }
			    
			   
			   
			   
			}
			
			
	
	
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("hello user.......\n prass 1 for Administrator \n prass 2 for Vendor");
			Scanner sc= new Scanner(System.in);
			System.out.println("enter:->");
			int p=sc.nextInt();
			if(p==1) {
				System.out.println("Enter_email:-");
				String email=sc.next();
				System.out.println("Enter_Password");
				String password=sc.next();
				AdminDao ad= new AdminMethods();
				try {
					String pass=ad.login(email, password);
					System.out.println(pass);
					UserMain.allAdminFunction();
				} catch (AdministratorDW e) {
					
					//e.getMessage();
					System.out.println("!!!!!!.wrong user name and password.!!!!!!!");
				}
			}else if(p==2) {
				System.out.println("Enter_email:-");
				String email=sc.next();
				System.out.println("Enter_Password");
				String password=sc.next();
				VenderDao ven=new VendorMethod();
				String pass;
				try {
					pass = ven.login(email, password);
					System.out.println(pass);
					UserMain.allVendorFunction();
				} catch (WrongVendorExaption e) {
					// TODO Auto-generated catch block
					System.out.println("!!!!!!.wrong user name and password.!!!!!!!");
				}
				//System.out.println(pass);
			}
		}
		
	}

}
