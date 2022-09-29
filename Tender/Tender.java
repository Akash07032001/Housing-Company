package Tender;

public class Tender {

	private int tid;
	private String tname;
	private int budget;
	private int taid;
	public Tender(int tid, String tname, int budget, int taid) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.budget = budget;
		this.taid = taid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getTaid() {
		return taid;
	}
	public void setTaid(int taid) {
		this.taid = taid;
	}
	@Override
	public String toString() {
		return "Tender [tid=" + tid + ", tname=" + tname + ", budget=" + budget + ", taid=" + taid + "]";
	}
	
}
