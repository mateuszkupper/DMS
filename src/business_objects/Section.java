package business_objects;

public class Section {
	private int id;
	private String title;
	private int document_id;
	private String couch_db_section_id;
	private int previous_version_id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getDocument_id() {
		return document_id;
	}
	
	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}
	
	public String getCouch_db_section_id() {
		return couch_db_section_id;
	}
	
	public void setCouch_db_section_id(String couch_db_section_id) {
		this.couch_db_section_id = couch_db_section_id;
	}
	
	public int getPrevious_version_id() {
		return previous_version_id;
	}
	
	public void setPrevious_version_id(int previous_version_id) {
		this.previous_version_id = previous_version_id;
	}	
}
