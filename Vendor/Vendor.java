package Vendor;

public class Vendor {
	
	private int vid;
	private String name;
	private String email;
	private String password;
	public Vendor(int vid, String name, String email, String password) {
		super();
		this.vid = vid;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
