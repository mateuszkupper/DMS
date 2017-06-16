package business_objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "notifications")
public class Permission {

	@Column(name = "details")
	private int permissions;
	
    @ManyToOne
    @MapsId	
	private Document document;
	
    public Permission() {
    	
    }
    
	public Permission(int permissions, Document document) {
		this.permissions = permissions;
		this.setDocument(document);
	}
	
	public int getPermissions() {
		return permissions;
	}
	
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}	
}
