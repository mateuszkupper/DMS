package business_objects;

public class permission {
	private int document_id;
	private int user_id;
	private int permissions;
	
	public int getDocument_id() {
		return document_id;
	}
	
	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getPermissions() {
		return permissions;
	}
	
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}	
}
