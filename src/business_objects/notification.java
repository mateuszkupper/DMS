package business_objects;

public class notification {
	private int id;
	private int section_master_id;
	private int section_slave_id;
	private String details;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSection_master_id() {
		return section_master_id;
	}
	
	public void setSection_master_id(int section_master_id) {
		this.section_master_id = section_master_id;
	}
	
	public int getSection_slave_id() {
		return section_slave_id;
	}
	
	public void setSection_slave_id(int section_slave_id) {
		this.section_slave_id = section_slave_id;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}	
}
