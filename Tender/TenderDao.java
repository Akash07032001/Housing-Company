package Tender;

import java.util.List;

public interface TenderDao {
	
	public int registerT(String name,int budget);
	public List<Tender> viewTender();

}
